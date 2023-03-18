package com.springg.springDemo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Book {

	@Value("1")
	private int bid;
	
	@Value("harry porter")
	private String bname;
	
	@Value("Magician")
	private String title;
	
	@Autowired
	private Author author;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Book(int bid, String bname, String title, Author author) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.title = title;
		this.author = author;
	}

	public Book() {
		
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
	
}
