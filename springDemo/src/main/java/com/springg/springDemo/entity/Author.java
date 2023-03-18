package com.springg.springDemo.entity;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;


@Component
public class Author {

	@Value("1")
	private int aid;
	
	@Value("vipul")
	private String aname;
	
	@Value("suspense")
	private String genre;
	
	public Author() {
	}

	public Author(int aid, String aname, String genre) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.genre = genre;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", aname=" + aname + ", genre=" + genre + "]";
	}

	
}
