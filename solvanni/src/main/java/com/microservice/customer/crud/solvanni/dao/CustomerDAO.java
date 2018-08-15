package com.microservice.customer.crud.solvanni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import com.microservice.customer.crud.solvanni.entity.Customer;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer getCustomerListById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customer = entityManager.createQuery("Select a From Customer a", Customer.class).getResultList();
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer, Session session) {
		session.saveOrUpdate(customer);
	}

	@Override
	@Rollback(true)
	public void deleteCustomerById(int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		if(customer != null){
			entityManager.remove(customer);
        }
	}

	@Override
	public void updateCustomer(Customer customer, Session session) {
		session.saveOrUpdate(customer);
	}

}
