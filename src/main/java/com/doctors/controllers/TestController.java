package com.doctors.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.doctors.entities.Test;

import com.doctors.services.TestService;
@RestController
public class TestController {
	@Autowired
	TestService testService;
	/*
	 * Get All Tests Details from database
	 */
	@GetMapping("/tests")
	public List<Test> getTestsDetails(){
		return testService.getAllTest();
	}
	/*
	 * Get test details by test_Id
	 */
	@GetMapping("/tests/{id}")
	public Optional<Test> getTest(@PathVariable int id){
		return testService.getTestById(id);
	}
	
	//by name
	@GetMapping("/tests/findbyName/{testName}")
	public List<Test> findByTestName(@PathVariable String testName){
		return testService.findAllByTestName(testName);
	}
	

	/*
	 * Add data to test aslo foreign key referenced by Customer
	 */
	@PostMapping("/tests")
	public Test addtest(@ModelAttribute Test test) {
		return testService.addTests(test);
	}
	
	/*
	 * Update the data of test table 
	 */
	@PutMapping("/tests/{id}")
	public Test updateTests(@PathVariable int id, @RequestBody Test test){
		return testService.updateTests(id,test);
		
	}
	/*
	 * Delete the data from Test table
	 */
	@DeleteMapping("/tests/{id}")
	public String deleteTest(@PathVariable int id ){
		 return testService.deleteTest(id);
	} 
}
