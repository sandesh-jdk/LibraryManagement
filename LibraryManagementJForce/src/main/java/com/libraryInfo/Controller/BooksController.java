package com.libraryInfo.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.libraryInfo.Entity.Books;
import com.libraryInfo.Entity.Registration;
import com.libraryInfo.services.BookService;
import com.libraryInfo.services.RegistrationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BooksController
{	
	@Autowired
	private BookService bookservice;
	@Autowired
	private RegistrationService regiservice;
	
	
	
	@GetMapping("/booklist")
	public String getAllBooks(Model model ,HttpSession session)
	{	

		model.addAttribute("booklist", bookservice.bookUser((Integer)session.getAttribute("uid")));
		return"BookList";
	}
	
	
	
	@GetMapping("/addbook")
	public String addBook(Model model)
	{
		Books b = new Books();
		model.addAttribute("book",b);
		return "AddBook";
	}
	
	@GetMapping("/add")
	public String bookAdded(@ModelAttribute("book") Books b1,HttpSession session)
	{	
		b1.setUser(regiservice.getuser((Integer)session.getAttribute("uid")));
		bookservice.saveBook(b1);
		return "redirect:/booklist";
	}
	
	@GetMapping("/update/{id}")
	public String updateBook(Model model , @PathVariable Integer id)
	{	
		
		Books b1 = bookservice.getBookById(id);
		model.addAttribute("update",b1);
		
		return "UpdateBook";
	}
	
	@GetMapping("/bookupdated/{id}")
	public String bookUpdated(@ModelAttribute Books book, @PathVariable Integer id,HttpSession session )
	{	
		
		book.setId(id);
		book.setUser(regiservice.getuser((Integer)session.getAttribute("uid")));
		bookservice.saveBook(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id)
	{	
		bookservice.deleteBook(id);
		return "redirect:/booklist";
	}
	
	@GetMapping("/details/{id}")
	public String bookDetails(Model model,@PathVariable Integer id)
	{	
		model.addAttribute("details",bookservice.getBookById(id));
		return"BookDetails";
	}
}
