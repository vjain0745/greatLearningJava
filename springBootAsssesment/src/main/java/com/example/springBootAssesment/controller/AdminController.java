package com.example.springBootAssesment.controller;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootAssesment.dto.LoginDto;
import com.example.springBootAssesment.dto.ResponseData;
import com.example.springBootAssesment.entity.Books;
import com.example.springBootAssesment.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/getAllBooks")
	public HashMap<String, List<Books>> getAllBooks() {
		HashMap<String, List<Books>> responseObj = new HashMap<>();
		try {
			List<Books> books = adminService.getAllBooks();
			System.out.println(books);
			responseObj.put("data", books);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}

	@GetMapping("/getBook")
	public HashMap<String, Books> getAllBooks(@RequestParam("bId") String bId,
			@RequestParam("authorId") String authorId) {
		HashMap<String, Books> responseObj = new HashMap<>();
		try {
			Books books = null;
			if (bId != null) {
				books = adminService.getBookById(bId);
			} else if (authorId != null) {
				books = adminService.getBookById(authorId);
			}

			responseObj.put("data", books);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}

	@PostMapping("/saveBook")
	public HashMap<String, Books> saveBooks(@RequestBody Books book) {
		HashMap<String, Books> responseObj = new HashMap<>();
		try {
			System.out.println(book);
			if (book.getBId() != null && adminService.getBookById(book.getBId()) != null) {
				throw new KeyAlreadyExistsException("Book already exist, Please add some other book !");
			}

			Books savedBook = adminService.saveBook(book);
			responseObj.put("data", savedBook);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}

	@PostMapping("/updateBook")
	public HashMap<String, Books> updateBooks(@RequestBody Books book) {
		HashMap<String, Books> responseObj = new HashMap<>();
		try {

			if (book.getBId() == null && adminService.getBookById(book.getBId()) == null) {
				throw new KeyAlreadyExistsException("Book does not exist, Please update some other book !");
			}

			Books savedBook = adminService.saveBook(book);
			responseObj.put("data", savedBook);

			return responseObj;
		} catch (Exception e) {
			return responseObj;

		}
	}

	@PostMapping("/deleteBook")
	public ResponseData deleteBooks(@RequestBody String bookId) {
		ResponseData responseObj = new ResponseData();
		try {

			if (bookId == null) {
				throw new KeyAlreadyExistsException("Book does not exist, Please delete some other book !");
			}

			adminService.deleteBookById(bookId);
			responseObj.setMessage("Book deleted successfully !");

			return responseObj;
		} catch (Exception e) {
			responseObj.setMessage(e.getMessage());
			return responseObj;

		}
	}
}
