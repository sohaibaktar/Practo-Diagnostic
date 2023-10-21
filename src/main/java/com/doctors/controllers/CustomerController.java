package com.doctors.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.entities.Customers;
import com.doctors.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	/*
	 * GetMapping used for get the data
	 * PostMapping used for Add the data
	 * PutMapping used for Update the data
	 * DeleteMapping used for Delete the data
	 * 
	 */
	@GetMapping("/patients")
	public List<Customers> getCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping("/patients/{id}")
	public Optional<Customers> getCustomer(@PathVariable int id ){
		return this.customerService.getCustomerbyId(id);
	}
	
	@PostMapping("/patients")
	public Customers addpatients(@RequestBody Customers customer) {
		return this.customerService.addCustomer(customer);
	}
	
	@DeleteMapping("/patients/{id}")
	public void deleteCustomer(@PathVariable int id ){
		 customerService.deleteCustomer(id);
	}
	
	
	
	

}
