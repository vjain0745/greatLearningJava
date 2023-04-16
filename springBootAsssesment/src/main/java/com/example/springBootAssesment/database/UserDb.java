package com.example.springBootAssesment.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springBootAssesment.entity.Users;

import jakarta.transaction.Transaction;

@Repository
public class UserDb {

	@Autowired
	private SessionFactory factory;

	public List<Users> getAllUsers() {
		Session session = factory.openSession();
		List<Users> users = session.createQuery("select count(*) from Users", Users.class).getResultList();
		session.close();
		return users;
	}

	public boolean loginUser(Users dto) throws Exception {
		Session session = factory.openSession();
		System.out.println("working here1");
		Users user = session.get(Users.class, dto.getEmail());
		System.out.println("working here");
		if (user != null) {
			if (dto.getPassword().equals(user.getPassword()))
				return true;
		}
		throw new Exception("Invalid Credentials");
	}
	
	public boolean saveUser(Users dto) throws Exception {
		Session session = factory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		System.out.println("DTO--->" + dto);
		session.save(dto);
		tx.commit();
		
		session.close();
		return true;
	}

	public Users getUserById(String email) throws Exception {
		Session session = factory.openSession();
		System.out.println("herr1");
			
		Users user = session.get(Users.class, email);
		System.out.println("herr");
		return user;
	}
}

