package com.libraryInfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryInfo.Entity.Order;
import com.libraryInfo.Repositories.OrderRepository;

@Service
public class OrderService 
{	
	@Autowired
	private OrderRepository orderRepo;
	
	public List<Order> getAllOrders()
	{
		return orderRepo.findAll();
	}
	
	public Order saveOrder(Order order)
	{
		return orderRepo.save(order);
	}
	
	public void deleteOrder(int id)
	{
		 orderRepo.deleteById(id);
	}
}
