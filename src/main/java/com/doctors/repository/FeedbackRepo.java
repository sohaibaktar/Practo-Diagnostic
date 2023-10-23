package com.doctors.repository;

import org.springframework.data.repository.CrudRepository;

import com.doctors.entities.Feedback;

public interface FeedbackRepo extends CrudRepository<Feedback, Integer>{

}
