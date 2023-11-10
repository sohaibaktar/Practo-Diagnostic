package com.doctors.services;

import java.util.List;
import java.util.Optional;
import com.doctors.entities.Test;

public interface TestService {
	
	public List<Test> getAllTest();

	public Optional<Test> getTestById(int id);

	public Test addTests(Test test);

	public Test updateTests(int id, Test test);

	public String deleteTest(int id);

	public List<Test> findAllByTestName(String testName);

	List<Test> getAllTestsByCustomerId(int customerId);

//	public Optional<Test> getTestByName(String name);

}
