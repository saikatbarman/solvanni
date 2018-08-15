package com.microservice.customer.crud.solvanni.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.customer.crud.solvanni.entity.Customer;
import com.microservice.customer.crud.solvanni.service.ICustomerService;
import com.microservice.customer.crud.solvanni.util.ServiceResponse;

@RestController
@RequestMapping("/customer-service/api/")
public class CustomerController {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping(value = { "getCustomerListById/{customerId}" }, produces = "application/json")
	public ResponseEntity<ServiceResponse> getCustomerListById(@PathVariable("customerId") int customerId) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = customerService.getCustomerListById(customerId);
		}
		catch(Exception e)
		{
			serviceResponse.setStatus("FAILURE");
			serviceResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.OK);
		
	}
	
	@GetMapping(value = { "getCustomerList" }, produces = "application/json")
	public ResponseEntity<Customer> getCustomerList() {
		List<Customer> customer = customerService.getCustomerList();
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@PostMapping(value = "saveCustomer", produces="application/json")
	public ResponseEntity<ServiceResponse> saveCustomer(@RequestBody Customer customer) {
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			customer.setCreate_date(new Timestamp(System.currentTimeMillis()));
			serviceResponse = customerService.saveCustomer(customer);
		} catch (Exception e) {
			serviceResponse.setStatus("FAILURE");
			serviceResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = { "deleteCustomerById/{customerId}" }, produces = "application/json")
	public ResponseEntity<ServiceResponse> deleteCustomerById(@PathVariable("customerId") int customerId) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = customerService.deleteCustomerById(customerId);
		}
		catch(Exception e)
		{
			serviceResponse.setStatus("FAILURE");
			serviceResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "updateCustomer", produces="application/json")
	public ResponseEntity<ServiceResponse> updateCustomer(@RequestBody Customer customer) {
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			customer.setUpdate_date(new Timestamp(System.currentTimeMillis()));
			serviceResponse = customerService.updateCustomer(customer);
		} catch (Exception e) {
			serviceResponse.setStatus("FAILURE");
			serviceResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.OK);
	}
}
