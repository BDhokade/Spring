package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomerList();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int custid);

	public void deleteCustomer(int custid);

}
