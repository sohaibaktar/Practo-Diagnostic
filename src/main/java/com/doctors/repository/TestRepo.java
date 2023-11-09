package com.doctors.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.doctors.entities.Test;

public interface TestRepo extends CrudRepository<Test,Integer>{
	
	
	//@Query("select u from tests u where u.testName=:n") @Param("n") 
	public List<Test> findByTestName(String name);
	
	List<Test> findByCustomerId_Id(int customerId);

}
