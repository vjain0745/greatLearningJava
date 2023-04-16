package com.example.springBootAssesment.service;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootAssesment.database.AuthRepo;
import com.example.springBootAssesment.entity.Users;

@Service
public class AuthService {

	@Autowired
	private AuthRepo authRepo;

	public long getAllCount() {
		return this.authRepo.count();
	}

	public Users getUserById(String email) {
		Users user = this.authRepo.findById(email).orElse(null);
		return user;
	}
	
	public Users saveUser(Users user) {
		System.out.println(user);
		Users savedUser = this.authRepo.save(user);
		return savedUser;
	}

	public boolean login(String email, String password) throws AccountNotFoundException {
		Users user = getUserById(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			} else {
				throw new AccountNotFoundException("Username/Password is wrong !");
			}
		} else {
			throw new AccountNotFoundException("Username/Password is wrong !");
		}
	}

}
