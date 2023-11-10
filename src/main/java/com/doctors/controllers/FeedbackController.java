package com.doctors.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.entities.Feedback;
import com.doctors.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/feedback")
	public List<Feedback> getFeedback(){
		return feedbackService.getAllFeedbacks();
	}
	
	@PostMapping("/feedback")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.addFeedback(feedback);
	}
	
	//Update
	@PutMapping("/feedback/{id}")
	public Feedback updateFeedback(@PathVariable int id,@RequestBody Feedback feedback ){
		 return feedbackService.updateFeedback(id,feedback);
	}
	
	//Delete
	@DeleteMapping("/feedback/{id}")
	public String deleteFeedback(@PathVariable int id ){
		 return feedbackService.deleteFeedback(id);
	}
}
