package com.doctors.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctors.entities.Customers;
import com.doctors.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Customers> getAllCustomers() {
		
		return (List<Customers>) this.customerRepo.findAll();
	}

	@Override
	public Optional<Customers> getCustomerbyId(long id) {
		Optional<Customers> res = this.customerRepo.findById((int) id);
		return res;
	}

	@Override
	public Customers addCustomer(Customers customer) {
		
		return this.customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepo.deleteById(id);
		System.out.println("Deleted");
		
	}

	

	
}
