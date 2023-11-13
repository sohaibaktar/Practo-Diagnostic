package com.doctors.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctors.entities.Customers;
import com.doctors.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	/*	implementation-->
	 * 	Get all Customer in table  (as a service)
	 * 	findAll --< from crud Repo
	 * 	   
	 */
	@Override
	public List<Customers> getAllCustomers() {
		
		return (List<Customers>) this.customerRepo.findAll();
	}
	/*	implementation-->
	 * 	Get details of Customer by Id   (as a service)
	 * 	findById --< from crud Repo
	 * 	   Optional used for get one user data --> like one Customer
	 */
	@Override
	public Optional<Customers> getCustomerbyId(long id) {
		Optional<Customers> res = this.customerRepo.findById((int) id);
		return res;
	}

	/*	implementation-->
	 * 	Add Customer in the table    (as a service)
	 * 	save --< from crud Repo
	 * 	   
	 */
	 @Override
	    public void saveCustomer(Customers customer) {
	        customerRepo.save(customer);
	    }

	    @Override
	    public boolean isEmailOrPhoneExists(String email, long phone) {
	        return customerRepo.existsByEmailOrPhone(email, phone);
	    }
	/*	implementation-->
	 * 	Delete All details of Customer by Id   (as a service)
	 * 	DeletebyId --< from crud Repo
	 * 	   
	 */
	@Override
	public String deleteCustomer(int id) {
		customerRepo.deleteById(id);
		String msg = "Deleted Data";
		return msg;
	}
	@Override
	public Customers updateCustomer(int id, Customers customer) {
		Optional<Customers> cst = customerRepo.findById(id);
		
		if (cst.isPresent()) {
			
			Customers originalCustomer = cst.get();
			
			 if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
				 originalCustomer.setName(customer.getName());
	            }
			 if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
				 originalCustomer.setEmail(customer.getEmail());
	            }
			 
			 if (Objects.nonNull(customer.getCity()) && !"".equalsIgnoreCase(customer.getCity())) {
				 originalCustomer.setCity(customer.getCity());
	            }
			 
			 if (Objects.nonNull(customer.getPassword()) && !"".equalsIgnoreCase(customer.getPassword())) {
				 originalCustomer.setPassword(customer.getPassword());
	            }
			 if (Objects.nonNull(customer.getPhone())) {
				 originalCustomer.setPhone(customer.getPhone());
	            }
			
	            return customerRepo.save(originalCustomer);
			
		}
				
		return null;
	}
	@Override
	public Optional<Customers> login(Customers inputCsmailpass) {
		System.out.println(inputCsmailpass.getEmail()+"--"+inputCsmailpass.getPassword());
		//Customers customer = customerRepo.findByEmailAndPassword();
		//System.out.println(customer.getEmail()+"--"+customer.getPassword());
		
		return Optional.ofNullable(customerRepo.findByEmailAndPassword(inputCsmailpass.getEmail(),inputCsmailpass.getPassword()));
	}
	

	

	
}
