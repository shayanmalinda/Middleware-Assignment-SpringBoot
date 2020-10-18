package com.shayanmalinda.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "count")
	private Integer count;

	public Book() {


	}

	public Book(String isbn, String title, String author, Integer count) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.count = count;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getisbn() {
		return isbn;
	}

	public void setisbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
