package com.example.springBootAssesment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootAssesment.database.BookRepo;
import com.example.springBootAssesment.entity.Books;
import com.example.springBootAssesment.entity.Users;

@Service
public class AdminService {

	@Autowired
	BookRepo bookRepo;
	

	public long getAllCount() {
		return this.bookRepo.count();
	}
	
	public List<Books> getAllBooks() {
		List<Books> books = this.bookRepo.findAll();
		return books;
	}

	public Books getBookById(String id) {
		Books book = this.bookRepo.findById(id).orElse(null);
		return book;
	}
	
	public Books getBookByAuthorId(String authorId) {
		Books book = this.bookRepo.findByAuthorId(authorId);
		return book;
	}
	
	public boolean deleteBookById(String id) {
		this.bookRepo.deleteById(id);
		return true;
	}
	
	public Books saveBook(Books book) {
		Books savedBook = this.bookRepo.save(book);
		return savedBook;
	}

}
