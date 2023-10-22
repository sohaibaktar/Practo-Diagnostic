package com.doctors.repository;


import org.springframework.data.repository.CrudRepository;

import com.doctors.entities.Customers;

public interface CustomerRepo extends CrudRepository<Customers, Integer>{

	//public List<Customers> find();

}
