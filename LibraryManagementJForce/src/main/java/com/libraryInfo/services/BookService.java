package com.libraryInfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryInfo.Entity.Books;
import com.libraryInfo.Entity.Registration;
import com.libraryInfo.Repositories.BookRepository;

@Service
public class BookService
{	
	@Autowired
	private BookRepository bookrepo;
	
	public List<Books> getAllBooks()
	{
		return bookrepo.findAll();
	}
	
	public List<Books> bookUser(Integer id)
	{
		return bookrepo.bookUser(id);
	}
	
	public Books getBookById(int id)
	{
		return bookrepo.findById(id).orElseThrow();
	}
	
	public void saveBook(Books book)
	{
		bookrepo.save(book);
	}
	
	public void deleteBook(int id)
	{
		bookrepo.deleteById(id);
	}
	
	public List<Books> getOrdersBooks(List<Integer> ids)
	{
		return bookrepo.findAllById(ids);
	}
	
}
