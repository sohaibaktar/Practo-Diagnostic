package com.doctors.services;

import java.util.List;
import java.util.Optional;

import com.doctors.entities.Customers;

public interface CustomerService {
	
	public List<Customers> getAllCustomers();
	
	public Optional<Customers> getCustomerbyId(long id);

	public Customers addCustomer(Customers customer);

	public void deleteCustomer(int id);
	

}
