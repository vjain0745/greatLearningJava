package com.gl.hibernateInterview.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer sId) {
		this.id = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [sId=" + id + ", name=" + name + "]";
	}
	
	
}
