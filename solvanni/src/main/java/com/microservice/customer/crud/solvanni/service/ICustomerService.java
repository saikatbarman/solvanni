package com.microservice.customer.crud.solvanni.service;

import java.util.List;

import com.microservice.customer.crud.solvanni.entity.Customer;
import com.microservice.customer.crud.solvanni.util.ServiceResponse;

public interface ICustomerService {

	ServiceResponse getCustomerListById(int customerId);

	List<Customer> getCustomerList();

	ServiceResponse saveCustomer(Customer customer);

	ServiceResponse deleteCustomerById(int customerId);

	ServiceResponse updateCustomer(Customer customer);

}
