package com.web.customer.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.customer.model.Customer;
import com.web.customer.model.ServiceRequest;
 
@RestController
public class CustomerController {
 
    @Autowired
	RestTemplate restTemplate;
    
    //-------------------Retrieve All Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllUsers() {
        List<Customer> customers = null;
        
        try {
			String json = restTemplate.getForObject("http://localhost:8091/customer-service/api/getCustomerList" , String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			customers = objectMapper.reader().forType(new TypeReference<List<Customer>>() {
				}).readValue(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
    	Customer customer = new Customer();
        
        try {
			ServiceRequest serviceRequest = restTemplate.getForObject( "http://localhost:8091/customer-service/api/getCustomerListById/"+ id, ServiceRequest.class);
			if (serviceRequest.getStatus().equalsIgnoreCase("SUCCESS"))
			{
				ObjectMapper objectMapper = new ObjectMapper();
				customer = objectMapper.convertValue(serviceRequest.getResObject(), Customer.class);
			} else {
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
    	ServiceRequest serviceRequest = new ServiceRequest();
    	try {
    		serviceRequest = restTemplate.postForObject("http://localhost:8091/customer-service/api/saveCustomer", customer, ServiceRequest.class);
    	} catch (Exception e) {
    		 return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
 
    	if(serviceRequest.getStatus().equalsIgnoreCase("SUCCESS")) {
    		HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getCustomer_id()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    	} else {
    		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	}
    }
 
    
     
    //------------------- Update a Customer --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
    	ServiceRequest serviceRequest = new ServiceRequest();
    	try {
    		serviceRequest = restTemplate.postForObject("http://localhost:8091/customer-service/api/updateCustomer", customer, ServiceRequest.class);
    		/*ObjectMapper objectMapper = new ObjectMapper();
			customer = objectMapper.convertValue(serviceRequest.getResObject(), Customer.class);*/
    	} catch (Exception e) {
    		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
 
    	if(serviceRequest.getStatus().equalsIgnoreCase("SUCCESS")) {
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    	}
    }
 
    
    
    //------------------- Delete a Customer --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteUser(@PathVariable("id") long id) {
 
        ServiceRequest serviceRequest = new ServiceRequest();
    	try {
    		serviceRequest = restTemplate.getForObject("http://localhost:8091/customer-service/api/deleteCustomerById/"+id, ServiceRequest.class);
    	} catch (Exception e) {
    		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
 
    	if(serviceRequest.getStatus().equalsIgnoreCase("SUCCESS")) {
    		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    	} else {
    		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    	}
    }
}