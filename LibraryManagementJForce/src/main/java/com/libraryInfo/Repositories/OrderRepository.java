package com.libraryInfo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryInfo.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	
}
