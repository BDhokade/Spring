package com.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{custId}")
	public Customer getCustomer(@PathVariable int custId) {
		
		Customer customer = customerService.getCustomer(custId);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer id " + custId + " does not exist");
			
		}

		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{custId}")
	public String deleteCustomer(@PathVariable int custId) {
		
		Customer theCustomer = customerService.getCustomer(custId);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("The Customer with id " + custId + " does not exist.");
		}
		
		customerService.deleteCustomer(custId);
		
		return "Customer with Id " + custId + " is deleted";
	}
	

}


