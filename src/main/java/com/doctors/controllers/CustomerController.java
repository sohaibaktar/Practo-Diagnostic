package com.doctors.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	//Sign up	
	@PostMapping("/patients")
	public ResponseEntity<String> addpatients(@RequestBody Customers customer) {
		 if (customerService.isEmailOrPhoneExists(customer.getEmail(), customer.getPhone())) {
	            return new ResponseEntity<>("Email or phone already exists", HttpStatus.BAD_REQUEST);
	        }
	        
	        customerService.saveCustomer(customer);
	        return new ResponseEntity<>("Account Created!!", HttpStatus.OK);
	}
	
	@DeleteMapping("/patients/{id}")
	public String deleteCustomer(@PathVariable int id ){
		 return customerService.deleteCustomer(id);
	}
	
	//Update Customer Data
	@PutMapping("/patients/{id}")
	public Customers updateCustomer(@PathVariable int id,@RequestBody Customers customer ){
		 return customerService.updateCustomer(id,customer);
	}
	
	
	//Login by email id and password
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Customers inputCsmailpass) {
		Optional<Customers> customer = customerService.login(inputCsmailpass);
		
		 if (customer.isPresent()) {
		        // Return the customerId in the response
		        return ResponseEntity.ok(Collections.singletonMap("customerId", customer.get().getId()));
		    } else {
		        return ResponseEntity.badRequest().body("Invalid email or password");
		    }
	}
		

}
