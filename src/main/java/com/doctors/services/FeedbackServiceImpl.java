package com.doctors.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doctors.entities.Feedback;
import com.doctors.repository.FeedbackRepo;
@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackRepo feedbackRepo;

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return (List<Feedback>) feedbackRepo.findAll();
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackRepo.save(feedback);
	}

	@Override
	public Feedback updateFeedback(int id, Feedback feedback) {
		// first i have to find by id which data i want to update
				Optional<Feedback> previousData = feedbackRepo.findById(id);
						//.orElseThrow(()->new ConfigDataResourceNotFoundException("Not exitst"+id));
				
				//now i have to add new one that store in test object
				if(previousData.isPresent()) {
					Feedback originalTestDetails = previousData.get();
					
					
					originalTestDetails.setComments(feedback.getComments());
					originalTestDetails.setCustomerFeedback(feedback.getCustomerFeedback());
					originalTestDetails.setTestFeedback(feedback.getTestFeedback());
					
					
					return feedbackRepo.save(originalTestDetails);
				}
				
				return null;
	}

	@Override
	public String deleteFeedback(int id) {
		feedbackRepo.deleteById(id);
		return "Feedback Deleted";
	}
	


}
