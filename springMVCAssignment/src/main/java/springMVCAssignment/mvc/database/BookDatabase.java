package springMVCAssignment.mvc.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springMVCAssignment.mvc.dto.LoginDto;
import springMVCAssignment.mvc.entity.Books;
import springMVCAssignment.mvc.entity.Users;

@Repository
public class BookDatabase {
	
	@Autowired
	private SessionFactory factory;

	public List<Books> getAllBooks() {
		Session session = factory.openSession();
		List<Books> books = session.createQuery("from Books", Books.class).getResultList();
		session.close();
		return books;
	}
	
	public boolean saveBooks(Books dto) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		
		session.close();
		return true;
	}

	public Books getBookById(String bookId) throws Exception {
		Session session = factory.openSession();
			
		Books book = session.get(Books.class, bookId);
		System.out.println("herr");
		return book;
	}
}
