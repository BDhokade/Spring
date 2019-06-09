package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CustomerDao;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDao custDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		return custDao.getCustomerList();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		custDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int custid) {
		
		return custDao.getCustomer(custid);
	}

	@Override
	@Transactional
	public void deleteCustomer(int custid) {
		
		custDao.deleteCustomer(custid);
	}

}
