package com.libraryInfo.Entity;

import java.util.List;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Books_Table")
public class Books 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Book_Title")
	private String title;
	@Column(name="Book_Author")
	private String author;
	@Column(name="Book_Description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private Registration user;
//	
//	@ManyToMany(mappedBy = "book")
//	private List<Order> order;
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(int id, String title, String author, String description, Registration user) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Registration getUser() {
		return user;
	}

	public void setUser(Registration user) {
		this.user = user;
	}

	
	
}
