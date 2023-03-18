package com.gl.HibernateCodingChallenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//author is a database managed entity
@Entity
@Table(name = "teacher") // optional
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacherId")
	private int tId;
	private String f_name;
	private String l_name;
	private String email;

	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}

	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tId + ", firstName=" + f_name + ", lastName=" + l_name + ", email=" + email + "]";
	}
	public Teacher(String firstName, String lastName, String email) {
		super();
		this.f_name = firstName;
		this.l_name = lastName;
		this.email = email;
	}
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	
		
}
