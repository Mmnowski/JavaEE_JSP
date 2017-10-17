package com.example.servletjspdemo.domain;

public class Order {
	
	private String firstName = "unknown";
	private String lastName = "unknown";
	private int orderDay = 1;
	
	public Order() {
		super();
	}
	
	public Order(String firstName, String lastName, int orderDay) {
		super();
		this.firstName = firstName;
		this.orderDay = orderDay;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(int orderDay) {
		this.orderDay = orderDay;
	}
}
