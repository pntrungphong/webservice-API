package com.phongpham.restful.controller;

import com.phongpham.restful.entities.Customer;

public class UpdateCustomerRequest {
	private int id;
	private Customer customer;
	public UpdateCustomerRequest() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
