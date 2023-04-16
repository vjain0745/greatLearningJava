package com.gl.hibernateInterview;

import org.hibernate.SessionFactory;

import com.gl.hibernateInterview.config.HibernateConfig;
import com.gl.hibernateInterview.entity.Student;
import com.mysql.cj.Session;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Student s = new Student();
        s.setId(1);
        s.setName("Vipul");
        insertStudent(s);
    }
    
	public static Student insertStudent(Student st) {

		org.hibernate.Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		tx.begin();
		session.persist(st);
		tx.commit();
		session.close();
		return st;
	}
}
