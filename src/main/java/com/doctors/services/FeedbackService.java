package com.doctors.services;

import java.util.List;

import com.doctors.entities.Feedback;

public interface FeedbackService {

	List<Feedback> getAllFeedbacks();

	Feedback addFeedback(Feedback feedback);

	Feedback updateFeedback(int id, Feedback feedback);

	String deleteFeedback(int id);

}
