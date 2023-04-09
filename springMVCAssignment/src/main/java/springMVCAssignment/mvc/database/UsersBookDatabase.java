package springMVCAssignment.mvc.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;

import springMVCAssignment.mvc.entity.Users;
import springMVCAssignment.mvc.entity.UsersBook;

@Repository
public class UsersBookDatabase {
	@Autowired
	private SessionFactory factory;
	
	public boolean saveUsersBook(UsersBook dto) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("DTO--->" + dto);
		session.save(dto);
		tx.commit();
		
		session.close();
		return true;
	}
	
	public List<UsersBook> getAllUsersBookReadLater(Users user) {
		Session session = factory.openSession();
		System.out.println("user---> " + user);
		org.hibernate.query.Query<UsersBook> query = session.createQuery("from UsersBook E where E.userId=:email and E.readLater=1 ", UsersBook.class).setString("email", user.getEmail());
		List<UsersBook> usersbook = query.getResultList();
		
		session.close();
		return usersbook;
	}
	
	public List<UsersBook> getAllUsersBookLiked(Users user) {
		Session session = factory.openSession();
		System.out.println("user---> " + user);
		org.hibernate.query.Query<UsersBook> query = session.createQuery("from UsersBook E where E.userId=:email and E.liked=1 ", UsersBook.class).setString("email", user.getEmail());
		List<UsersBook> usersbook = query.getResultList();
		
		session.close();
		return usersbook;
	}
}
