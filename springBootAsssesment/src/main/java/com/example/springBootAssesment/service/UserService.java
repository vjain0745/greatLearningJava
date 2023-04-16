package com.example.springBootAssesment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springBootAssesment.database.BookRepo;
import com.example.springBootAssesment.database.UserDb;
import com.example.springBootAssesment.database.UserRepo;
import com.example.springBootAssesment.entity.Books;
import com.example.springBootAssesment.entity.Users;

@Service
public class UserService {

	@Autowired
	private UserDb database;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BookRepo bookRepo;

	public long getAllCount() {
		return this.userRepo.count();
	}

	public List<Users> getUsers() {
		return (List<Users>) this.userRepo.findAll();
	}

	public Optional<Users> getUserByEmailId(String email) {
		return this.userRepo.findById(email);
	}

	public List<Books> getAllBooks() {
		List<Books> books = this.bookRepo.findAll();
		return books;
	}

	public List<Books> getAllBooksByPrice(HashMap<String, String> priceRange) {
		List<Books> books = null;

		if (priceRange.containsKey("endPrice")) {
			books = this.bookRepo.findByPriceLessThanEqual(Integer.parseInt(priceRange.get("endPrice")));

		} else if (priceRange.containsKey("startPrice")) {
			books = this.bookRepo.findByPriceGreaterThanEqual(Integer.parseInt(priceRange.get("startPrice")));
		}

		return books;

	}

	public List<Books> getAllBooksByPriceSorting(String sortBy) {
		List<Books> books = null;

		if (sortBy.equals("Ascending")) {
			books = this.bookRepo.findAllByOrderByPriceAsc();
		} else {
			books = this.bookRepo.findAllByOrderByPriceDesc();
		}

		return books;

	}

	public boolean validateUser(Users dto) throws Exception {
		if (this.database.loginUser(dto))
			return true;
		return false;
	}

	public boolean saveUser(Users dto) throws Exception {
		boolean user = this.database.saveUser(dto);
		System.out.println("userr-> " + user);
		if (user) {
			return true;
		}

		return false;
	}

	public Users getUserByEmail(String email) throws Exception {

		Users user = this.database.getUserById(email);
		return user;

	}

	public List<String> getAllUsersEmail() {
		List<Users> users = this.database.getAllUsers();
		List<String> useremail = new ArrayList<String>();
		users.forEach(user -> useremail.add(user.getEmail()));
		return useremail;

	}

}
