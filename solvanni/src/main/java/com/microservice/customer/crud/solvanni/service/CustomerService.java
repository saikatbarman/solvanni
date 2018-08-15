package com.microservice.customer.crud.solvanni.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.customer.crud.solvanni.dao.ICustomerDAO;
import com.microservice.customer.crud.solvanni.entity.Customer;
import com.microservice.customer.crud.solvanni.util.ServiceResponse;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public ServiceResponse getCustomerListById(int customerId) {
		ServiceResponse serviceResponse = new ServiceResponse();
		
		Customer customer = customerDAO.getCustomerListById(customerId);
		serviceResponse.setResObject(customer);
		serviceResponse.setStatus("SUCCESS");
		
		return serviceResponse;
	}

	@Override
	public List<Customer> getCustomerList() {
		return customerDAO.getCustomerList();
	}

	@Override
	public ServiceResponse saveCustomer(Customer customer) {
		ServiceResponse serviceResponse = new ServiceResponse();
		Session session = getSession();
		try {
			customerDAO.saveCustomer(customer, session);
			serviceResponse.setStatus("SUCCESS");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse deleteCustomerById(int customerId) {
		ServiceResponse serviceResponse = new ServiceResponse();
		
		customerDAO.deleteCustomerById(customerId);
		serviceResponse.setStatus("SUCCESS");
		
		return serviceResponse;
	}

	@Override
	public ServiceResponse updateCustomer(Customer customer) {
		ServiceResponse serviceResponse = new ServiceResponse();
		Session session = getSession();
		try {
			customerDAO.updateCustomer(customer, session);
			serviceResponse.setStatus("SUCCESS");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return serviceResponse;
	}
}
