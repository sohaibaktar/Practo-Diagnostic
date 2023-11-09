package com.doctors.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doctors.entities.Customers;
import com.doctors.entities.Test;
import com.doctors.entities.TestDTO;
import com.doctors.services.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	//by customerId
	@GetMapping("/tests/findbycustId/{customerId}")
	public ResponseEntity<List<Test>> getAllTestsByCustomerId(@PathVariable int customerId) {
        List<Test> tests = testService.getAllTestsByCustomerId(customerId);
        return ResponseEntity.ok(tests);
    }
	

	/*
	 * Add data to test aslo foreign key referenced by Customer
	 */
	@PostMapping("/tests")
	public ResponseEntity<String> addtest(@RequestParam("file") MultipartFile file,
            @RequestParam("data") String jsonData) {
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            TestDTO testDTO = objectMapper.readValue(jsonData, TestDTO.class);

            Test test = new Test();
            test.setTestName(testDTO.getTestName());
            test.setDoctor(testDTO.getDoctor());
            test.setPrescriptionImage(file.getBytes());
            test.setTestDate(testDTO.getTestDate());

            // Set userId in the Test entity
         // Set customerId in the Test entity
            Customers customer = new Customers();
            customer.setId(testDTO.getCustomerId());
            test.setCustomerId(customer);

            // Assuming you have a service to save the test
            testService.addTests(test);

            return ResponseEntity.ok()
            		.contentType(MediaType.APPLICATION_JSON)
            		.body("Test data and image uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading test data and image");
        }
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
