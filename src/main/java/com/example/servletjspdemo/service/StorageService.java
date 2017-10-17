package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Order;

public class StorageService {
	
	private List<Order> db = new ArrayList<Order>();
	
	public void add(Order order){
		Order newOrder = new Order(order.getFirstName(), order.getLastName(), order.getOrderDay());
		db.add(newOrder);
	}
	
	public List<Order> getAllOrders(){
		return db;
	}

}
