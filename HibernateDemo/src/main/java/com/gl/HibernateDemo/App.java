package com.gl.HibernateDemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateDemo.config.HibernateConfig;
import com.gl.HibernateDemo.entity.Author;

/**
 * Hello world!
 *
 */
public class App {
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {

//		Author a1 = new Author("Daniel", "Kids");
//		System.out.println(a1);
//		System.out.println(insertAuthor(a1));
//		System.out.println(a1);
//
//	}
//
//	// save or persist
//	public static int insertAuthor(Author author) {
//		// Create a session
//		// DML commit => transaction
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.persist(author);
//		tx.commit();
//		session.close();
//		return author.getAid();
	}
}
