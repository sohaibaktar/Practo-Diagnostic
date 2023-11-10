package com.doctors.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctors.entities.Test;
import com.doctors.repository.TestRepo;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepo testRepo;
	
	@Override
	public List<Test> getAllTest() {
		
		return (List<Test>) this.testRepo.findAll();
	}
	@Override
	public Optional<Test> getTestById(int id) {
		Optional<Test> ans =  testRepo.findById((int) id);
		return ans;
	}
	@Override
	public Test addTests(Test test) {
		
		return testRepo.save(test);
	}
	@Override
	public Test updateTests(int id, Test test) {
		// first i have to find by id which data i want to update
		Optional<Test> previousData = testRepo.findById(id);
				//.orElseThrow(()->new ConfigDataResourceNotFoundException("Not exitst"+id));
		
		//now i have to add new one that store in test object
		if(previousData.isPresent()) {
			Test originalTestDetails = previousData.get();
			
			
			originalTestDetails.setTestDate(test.getTestDate());
			originalTestDetails.setTestName(test.getTestName());
			originalTestDetails.setCustomerId(test.getCustomerId());
			
			
			return testRepo.save(originalTestDetails);
		}
		
		return null;
	}
	@Override
	public String deleteTest(int id) {
		testRepo.deleteById(id);
		String msg = "Deleted Data";
		return msg;
		
	}
	@Override
	@Transactional
	public List<Test> findAllByTestName(String testName) {
		// TODO Auto-generated method stub
		return testRepo.findByTestName(testName);
	}
	@Override
	@Transactional
    public List<Test> getAllTestsByCustomerId(int customerId) {
        return testRepo.findByCustomerId_Id(customerId);
    }
	

}
