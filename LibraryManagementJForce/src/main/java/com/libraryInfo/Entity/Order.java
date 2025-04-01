package com.libraryInfo.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Order_Table")
public class Order 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(name="Order_book_rel", joinColumns =@JoinColumn(name="Order_id"),
	inverseJoinColumns =@JoinColumn(name="Book_id"))
	private List<Books> book;

	@ManyToOne
	@JoinColumn(name="User_id")
	private Registration user;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, List<Books> book, Registration user) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	public Registration getUser() {
		return user;
	}

	public void setUser(Registration user) {
		this.user = user;
	}

	
	
}
