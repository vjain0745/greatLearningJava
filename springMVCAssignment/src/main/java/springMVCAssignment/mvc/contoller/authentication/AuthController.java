package springMVCAssignment.mvc.contoller.authentication;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springMVCAssignment.mvc.dto.LoginDto;
import springMVCAssignment.mvc.entity.Users;
import springMVCAssignment.mvc.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage(HttpServletRequest request, Map<String, String> errormap,
			@RequestParam(required = false) String error) {
		// GET
		if (error != null)
			errormap.put("error", error);
		System.out.println("login request " + request.getMethod());
		return "authentication/Login";
	}

	@GetMapping("/register")
	public String registerPage(HttpServletRequest request, Map<String, String> errormap,
			@RequestParam(required = false) String error, @RequestParam(required = false) String message) {
		// GET
		if (error != null)
			errormap.put("error", error);
		
		if(message != null)
			errormap.put("message", message);

		return "authentication/Register";
	}

	@PostMapping("/login")
	public String loginUser(LoginDto dto, HttpServletRequest request, HttpSession session, HttpServletResponse resp) {
		// POST
		System.out.println("login request " + request.getMethod());
		System.out.println("email " + dto.getEmail());
		System.out.println("pwd " + dto.getPassword());

//		if (dto.getEmail().equals("admin@admin.com") && dto.getPassword().equals(("admin"))) {
//			session.setAttribute("email", dto.getEmail());
//			return "redirect:admin";
//		}

		try {
			if (this.userService.validateUser(dto)) {
				Cookie cookie = new Cookie("email", dto.getEmail());
				session.setAttribute("email", dto.getEmail());
				resp.addCookie(cookie);
				return "redirect:book";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return "redirect:login?error=Invalid-credentials";
		}
		// failure => redirect (GET)
		return "redirect:login?error=Invalid-credentials";
	}

	@PostMapping("/register")
	public String registerUser(Users dto, HttpServletRequest request, HttpSession session,
			HttpServletResponse resp) {
		// POST
		try {
			
			System.out.println(dto);
			Users user = this.userService.getUserByEmail(dto.getEmail());
			System.out.println(dto);
			if (user != null) {
				return "redirect:register?error=User ALready Exist";
			}

			if (this.userService.saveUser(dto)) {
				return "redirect:register?message=User saved successfully, Please Login in";
			} 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return "redirect:register?error=" + e.getMessage();
		}
		// failure => redirect (GET)
		return "redirect:register?error=Invalid-credentials";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,
			HttpServletResponse resp,
			HttpServletRequest request)
	{
		Cookie cookies[] = request.getCookies();
		System.out.println(cookies.length);
		for(Cookie cookie : cookies)
		{
			System.out.println(cookie.getName());
			if(cookie.getName().equals("email"))
				cookie.setMaxAge(0);
			else if(cookie.getName().equals("JSESSIONID"))
				cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:login";
	}
}
