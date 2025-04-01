package com.libraryInfo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libraryInfo.Entity.Order;
import com.libraryInfo.services.BookService;
import com.libraryInfo.services.RegistrationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private RegistrationService regiservice;
	
	@GetMapping("/userbooklist")
	public String getAllBooks(Model model ,HttpSession session)
	{	
		
		model.addAttribute("booklist", bookservice.getAllBooks());
		return"UserBookList";
	}
	
	@GetMapping("/userbookdetails/{id}")
	public String bookDetails(Model model,@PathVariable Integer id)
	{	
		model.addAttribute("details",bookservice.getBookById(id));
		return"UserBookDetails";
	}
}
