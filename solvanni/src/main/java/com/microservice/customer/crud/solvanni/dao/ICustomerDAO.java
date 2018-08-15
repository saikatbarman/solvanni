package com.microservice.customer.crud.solvanni.dao;

import java.util.List;

import org.hibernate.Session;

import com.microservice.customer.crud.solvanni.entity.Customer;

public interface ICustomerDAO {

	Customer getCustomerListById(int customerId);

	List<Customer> getCustomerList();

	void saveCustomer(Customer customer, Session session);

	void deleteCustomerById(int customerId);

	void updateCustomer(Customer customer, Session session);

}
