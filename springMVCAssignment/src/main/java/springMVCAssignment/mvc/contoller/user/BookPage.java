package springMVCAssignment.mvc.contoller.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springMVCAssignment.mvc.entity.Books;
import springMVCAssignment.mvc.entity.Users;
import springMVCAssignment.mvc.entity.UsersBook;
import springMVCAssignment.mvc.service.BookService;
import springMVCAssignment.mvc.service.UserBookService;
import springMVCAssignment.mvc.service.UserService;

@Controller
public class BookPage {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserBookService userBookService;

	@GetMapping("/book")
	public String bookPage(Map<String, List<Books>> allBooks, Map<String, List<String>> allUserBooks,
			@CookieValue(value = "email", required = false) String userCookie, @RequestParam(required = false) String error,
			Map<String, String> errormap) {

		List<Books> books = this.bookService.getAllBooks();

		if (userCookie != null) {
			List<UsersBook> booksLater = this.userBookService.getAllUsersBookReadLater(userCookie);
			List<UsersBook> booksLiked = this.userBookService.getAllUserBooksLiked(userCookie);

			List<String> likedd = new ArrayList<String>();
			for (UsersBook us : booksLiked) {
				likedd.add(us.getBookId().getBName());
			}

			List<String> laterr = new ArrayList<String>();
			for (UsersBook us : booksLater) {
				laterr.add(us.getBookId().getBName());
			}

			allUserBooks.put("booksLiked", likedd);
			allUserBooks.put("booksLater", laterr);
		}

		if (error != null)
			errormap.put("error", error);

		allBooks.put("books", books);

		return "user/BookList";
	}

	/*
	 * // @PostMapping("/bookMapping") // public String bookMapping(Map<String,
	 * List<Books>> map) { // // List<Books> books = this.bookService.getAllBooks();
	 * // map.put("books", books); // System.out.println(books); // return
	 * "user/BookList"; // }
	 */

	@GetMapping("/bookMapping/readlater/{bookid}")
	public String readLaterBook(@PathVariable String bookid, HttpServletRequest request,
			@CookieValue(value = "email", required = false) String userCookie) {

		if (userCookie == null) {
			return "redirect:/book?error=Please login to save or like books";
		}

		Books book = null;
		try {
			book = bookService.getBookById(bookid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Users user = null;
		try {
			user = (Users) userService.getUserByEmail(userCookie);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		boolean readLater = true;

		UsersBook userBook = new UsersBook();
		userBook.setUserId(user);
		userBook.setBookId(book);
		userBook.setReadLater(readLater);

		try {
			userBookService.saveUserBook(userBook);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/book";
	}

	@GetMapping("/bookMapping/liked/{bookid}")
	public String likedBook(@PathVariable String bookid, HttpServletRequest request,
			@CookieValue(value = "email", required = false) String userCookie) {
		if (userCookie == null) {
			return "redirect:/book?error=Please login to save or like books";
		}

		Books book = null;
		try {
			book = bookService.getBookById(bookid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Users user = null;
		try {
			user = (Users) userService.getUserByEmail(userCookie);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		boolean liked = true;

		UsersBook userBook = new UsersBook();
		userBook.setUserId(user);
		userBook.setBookId(book);
		userBook.setLiked(liked);

		try {
			userBookService.saveUserBook(userBook);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/book";
	}

}
