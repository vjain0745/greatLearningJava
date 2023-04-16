package com.example.springBootAssesment.controller;

import java.util.HashMap;

import javax.management.openmbean.KeyAlreadyExistsException;
import javax.naming.directory.InvalidAttributesException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootAssesment.dto.LoginDto;
import com.example.springBootAssesment.dto.RegisterDto;
import com.example.springBootAssesment.dto.ResponseData;
import com.example.springBootAssesment.entity.Users;
import com.example.springBootAssesment.jwt.JwtTokenUtil;
import com.example.springBootAssesment.service.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

	@Autowired
	AuthService authService;

	@Autowired
	JwtTokenUtil JwtTokenUtil;

	@PostMapping("/login")
	public ResponseData login(@RequestBody LoginDto loginCred, HttpServletResponse response) {
		ResponseData responseObj = new ResponseData();

		try {
			if (loginCred.getEmail() == null || loginCred.getPassword() == null || loginCred.getEmail().isBlank()
					|| loginCred.getPassword().isBlank()) {
				throw new InvalidAttributesException("Please provide valid credentials");
			}

			boolean userAvail = this.authService.login(loginCred.getEmail(), loginCred.getPassword());
			if (userAvail) {

				final String token = JwtTokenUtil.generateToken(loginCred.getEmail());

				System.out.println(token);

				Cookie cookie = new Cookie("token", token);
				cookie.setHttpOnly(true);

				// add a cookie to the response
				response.addCookie(cookie);
				HashMap<String, String> respon = new HashMap<>();
				respon.put("token", token);

				responseObj.setMessage("User logged in successfully !");
				responseObj.setData(respon);
				return responseObj;
			}
		} catch (Exception e) {
			responseObj.setMessage(e.getMessage());
			return responseObj;
		}

		return responseObj;
	}

	@PostMapping("/register")
	public String register(@RequestBody RegisterDto registerCred) {
		try {
			if (registerCred.getEmail() == null || registerCred.getPassword() == null
					|| registerCred.getEmail().isBlank() || registerCred.getPassword().isBlank()) {
				throw new InvalidAttributesException("Please provide valid credentials");
			}

			if (authService.getUserById(registerCred.getEmail()) != null) {
				throw new KeyAlreadyExistsException("Email already exist, Please login to continue !");
			}

			// create user object
			Users user = new Users();
			user.setName(registerCred.getName());
			user.setMobileNumber(registerCred.getMobileNumber());
			user.setEmail(registerCred.getEmail());
			user.setPassword(registerCred.getPassword());

			Users savedUser = authService.saveUser(user);

			if (savedUser != null) {
				return "User Saved Successfully !, Please login to continue";
			} else {
				throw new AccountNotFoundException("Something Went Wrong, Please try again !");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@GetMapping("/logout")
	public ResponseData logout(@CookieValue(value = "token", required = false) String token,
			HttpServletResponse response) {
		ResponseData responseObj = new ResponseData();
		try {
			if (token == null) {
				throw new CredentialNotFoundException("Something went wrong !");
			}

			// create a cookie
			Cookie cookie = new Cookie("token", null);
			cookie.setMaxAge(0);
			cookie.setHttpOnly(true);

			// add a cookie to the response
			response.addCookie(cookie);
			responseObj.setMessage("User logout successfully !");

			return responseObj;
		} catch (Exception e) {
			responseObj.setMessage(e.getMessage());
			return responseObj;
		}
	}
}
