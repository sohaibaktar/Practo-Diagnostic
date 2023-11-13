package com.doctors.services;

import java.util.List;
import java.util.Optional;

import com.doctors.entities.Customers;

public interface CustomerService {
	
	public List<Customers> getAllCustomers();
	
	public Optional<Customers> getCustomerbyId(long id);
	
	void saveCustomer(Customers customer);
    boolean isEmailOrPhoneExists(String email, long phone);

	public String deleteCustomer(int id);

	public Customers updateCustomer(int id, Customers customer);

	public Optional<Customers> login(Customers customer);

	

	
	

}
