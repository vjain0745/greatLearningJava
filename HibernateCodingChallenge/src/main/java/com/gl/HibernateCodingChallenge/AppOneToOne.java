package com.gl.HibernateCodingChallenge;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCodingChallenge.entity.Address;
import com.gl.HibernateCodingChallenge.entity.Student;
import com.gl.HibernateCodingChallenge.entity.Teacher;

import configurations.HibernateConfig;

public class AppOneToOne {
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
		
//		Add new Entry
		Student s1 = new Student();
//		s1.setFirstName("vipul");
//		s1.setLastName("jain");
//		s1.setEmailId("vjain@gmail.com");
		
//		List<Address> addresses = new ArrayList<>();
		
		Address a1 = new Address();
//		a1.setHouseNo("f-118");
//		a1.setCity("delhi");
//		a1.setLocality("krishna nagar");
//		a1.setPincode("110029");
//		
//		addresses.add(a1);
////		
//		a1.setStudent(s1);
//		s1.setAddress(a1);
//
//		
//		System.out.println("Inserted id in student is ==> " + " " + insertStudent(s1));

		
//		Edit entry
//		a1.setEmail("shivam@gmail.com");
//		a1.settId(1);
//		System.out.println("Inserted id is ==> " + " " + updateTeacher(a1));

//		Delete entry
//		a1.setaId(1);
		
//		a1.setaId(1);
//		s1.setAddress(null);
		
		a1 =  getAddressById(1);
		System.out.println(a1);
		
		deleteAddress(a1);
		
//		Read All Entries
//		for(Student s : getAllStudents()) {
//			System.out.println(s);
//		}
		
//		for(Address a : getAllAddress()) {
//			System.out.println(a);
//		}

//		Read single entry
//		System.out.println(getTeacherById(1));

	}

	// save or persist
	public static int insertAddress(Address address) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(address);
		tx.commit();
		session.close();
		return address.getaId();
	}
	
	// save or persist
	public static int insertStudent(Student student) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
		return student.getsId();
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
	public static void deleteAddress(Address address) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(address);
		tx.commit();
		session.close();
	}
	
	// remove and delete
	public static void deleteStudent(Student student) {
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(student);
		tx.commit();
		session.close();
	}

	// get by id
	public static Address getAddressById(int aId) {
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();

		Address address = session.get(Address.class, aId);
		
//		session.remove(address);
//		tx.commit();
		session.close();
		return address;
	}
	
	public static Teacher getTeacherById(int tid) {
		Session session = factory.openSession();
		Teacher teacher = session.get(Teacher.class, tid);
		session.close();
		return teacher;
	}

	// get all
	public static List<Student> getAllStudents() {
		Session session = factory.openSession();
		// from Author [ java class ]
		List<Student> students = session.createQuery("from Student", Student.class).getResultList();
		// List<Author> authors = session.createQuery("select a from Author a",
		// Author.class).getResultList();
		session.close();
		return students;
	}
	
	// get all
	public static List<Address> getAllAddress() {
		Session session = factory.openSession();
		// from Author [ java class ]
		List<Address> address = session.createQuery("from Address", Address.class).getResultList();
		// List<Author> authors = session.createQuery("select a from Author a",
		// Author.class).getResultList();
		session.close();
		return address;
	}

}
