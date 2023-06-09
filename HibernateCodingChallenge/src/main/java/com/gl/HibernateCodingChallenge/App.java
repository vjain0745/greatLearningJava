package com.gl.HibernateCodingChallenge;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCodingChallenge.entity.Teacher;

import configurations.HibernateConfig;

public class App {
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
//		Teacher a1 = new Teacher();
//		a1.setEmail("vjain");
//		a1.setF_name("vipul");
//		a1.setL_name("jain");
//		
//		System.out.println(a1);
		
//		Add new Entry
//		System.out.println("Inserted id is ==> " + " " + insertTeacher(a1));
		
//		Edit entry
//		a1.setEmail("shivam@gmail.com");
//		a1.settId(1);
//		System.out.println("Inserted id is ==> " + " " + updateTeacher(a1));
		
//		Delete entry
//		a1.settId(2);
//		deleteTeacher(a1);
//		System.out.println(a1);
		
//		Read All Entries
//		for(Teacher t : getAllTeachers()) {
//			System.out.println(t);
//		}
		
//		Read single entry
//		System.out.println(getTeacherById(1));
		

	}

	// save or persist
	public static int insertTeacher(Teacher teacher) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(teacher);
		tx.commit();
		session.close();
		return teacher.gettId();
	}

	/*
	 * 3 states of an object 1. transient => newly created 2. persistent => save 3.
	 * detached => after you close the session merge and update
	 */
	public static Teacher updateTeacher(Teacher teacher) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Teacher updatedTeacher = session.merge(teacher);
		tx.commit();
		session.close();
		return updatedTeacher;
	}

	// remove and delete
	public static void deleteTeacher(Teacher teacher) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(teacher);
		tx.commit();
		session.close();
	}

	// get by id
	public static Teacher getTeacherById(int tid) {
		Session session = factory.openSession();
		Teacher teacher = session.get(Teacher.class, tid);
		session.close();
		return teacher;
	}

	// get all
	public static List<Teacher> getAllTeachers() {
		Session session = factory.openSession();
		// from Author [ java class ]
		List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).getResultList();
		// List<Author> authors = session.createQuery("select a from Author a",
		// Author.class).getResultList();
		session.close();
		return teachers;
	}

}
