package springMVCAssignment.mvc.database;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springMVCAssignment.mvc.dto.LoginDto;
import springMVCAssignment.mvc.entity.Users;

@Repository
public class UsersDatabase {

	@Autowired
	private SessionFactory factory;

	public List<Users> getAllUsers() {
		Session session = factory.openSession();
		List<Users> users = session.createQuery("from Users", Users.class).getResultList();
		session.close();
		return users;
	}

	public boolean loginUser(LoginDto dto) throws Exception {
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
		Transaction tx = session.beginTransaction();
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
//		if (user != null) {
//			return user;
//		}
//
//		throw new Exception("User Doesn't Exist !");
		return user;
	}
}
