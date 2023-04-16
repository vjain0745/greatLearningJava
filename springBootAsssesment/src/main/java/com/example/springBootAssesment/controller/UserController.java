package com.example.springBootAssesment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootAssesment.entity.Books;
import com.example.springBootAssesment.entity.UserBooks;
import com.example.springBootAssesment.entity.Users;
import com.example.springBootAssesment.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/greet")
	public String heelo() {
		return "Hello Vipul";
	}

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		long users = this.userService.getAllCount();
		return this.userService.getUsers();
	}

	@GetMapping("/getUserByEmail/{email}")
	public Optional<Users> getUserByEmail(@PathVariable("email") String email) {
		System.out.println(email);
		Optional<Users> users = this.userService.getUserByEmailId(email);
		return users;
	}

	@GetMapping("/user/getAllBooks")
	public HashMap<String, List<Books>> getAllBooks() {
		HashMap<String, List<Books>> responseObj = new HashMap<>();
		try {
			List<Books> books = userService.getAllBooks();
			System.out.println(books);
			responseObj.put("data", books);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}

	@GetMapping("/user/getAllBooksByPrice")
	public HashMap<String, List<Books>> getAllBooksByPrice(
			@RequestParam(required = false) HashMap<String, String> priceRange) {
		HashMap<String, List<Books>> responseObj = new HashMap<>();
		try {
			List<Books> books = new ArrayList<>();
			if (priceRange.containsKey("startPrice") || priceRange.containsKey("endPrice")) {
				books = userService.getAllBooksByPrice(priceRange);
			}
			System.out.println(books);
			responseObj.put("data", books);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}
	
	@GetMapping("/user/getAllBooksByPriceSorting")
	public HashMap<String, List<Books>> getAllBooksByPrice(
			@RequestParam(required = false) String sortBy) {
		HashMap<String, List<Books>> responseObj = new HashMap<>();
		try {
			List<Books> books = new ArrayList<>();
			if (!sortBy.isEmpty()) {
				books = userService.getAllBooksByPriceSorting(sortBy);
			}
			
			System.out.println(books);
			responseObj.put("data", books);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}
	
	@PostMapping("/user/likeBook")
	public String likeBook(
			@RequestBody(required = false) UserBooks userBook) {
		HashMap<String, Books> responseObj = new HashMap<>();
		try {
			System.out.println(userBook);

			return "l";
		} catch (Exception e) {
			return "";

		}
	}

}