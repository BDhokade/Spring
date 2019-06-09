package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomerList() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		
		// Execute query and return a results list 
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int custid) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Customer.class, custid);
	}

	@Override
	public void deleteCustomer(int custid) {
		
		Session currSession = sessionFactory.getCurrentSession();
		
		Query<?> custQuery = currSession.createQuery("delete from Customer where id = :custid");
		custQuery.setParameter("custid", custid);
		custQuery.executeUpdate();
	}

}
