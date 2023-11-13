package com.doctors.repository;

import org.springframework.data.repository.CrudRepository;

import com.doctors.entities.Customers;

public interface CustomerRepo extends CrudRepository<Customers, Integer>{

//	@Query("SELECT * FROM User u WHERE u.email = :email AND u.password = :password")
	public Customers findByEmailAndPassword(String email, String password);
	
	boolean existsByEmailOrPhone(String email, long phone);
	
}
