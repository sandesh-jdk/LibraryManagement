package com.libraryInfo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.libraryInfo.Entity.Order;
import com.libraryInfo.services.BookService;
import com.libraryInfo.services.OrderService;
import com.libraryInfo.services.RegistrationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController
{	
	@Autowired
	private OrderService orderservice;
	
	@Autowired
	private RegistrationService regiservice;
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/saveorder")
	public String saveorder(Model model)
	{	
		Order order = new Order();
		model.addAttribute("order1", order);
		model.addAttribute("books",bookservice.getAllBooks());
		return"AddOrder";
	}
	
	@GetMapping("/ordersaved")
	public String savedOrder(@ModelAttribute("order1") Order order,HttpSession session)
	{	
		order.setUser(regiservice.getuser((Integer)session.getAttribute("uid")));
		orderservice.saveOrder(order);
		return "redirect:/userbooklist";
	}
	
//	@GetMapping("/vieworders")
//	public String viewOrder(Model model)
//	{	
//		List<Order> ids = orderservice.getAllOrders();
//		List<Integer> oid =new ArrayList<Integer>();
//		for(Order o : ids)
//		{		
//			Integer i =o.getId();
//			if(i!=null)
//			{
//				oid.add(i);
//			}
//		}
//		
//		model.addAttribute("allorders",bookservice.getOrdersBooks(oid));
//		return"View_Orders";
//	}
//	
//	
}
