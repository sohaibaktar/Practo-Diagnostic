package com.doctors.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "test_feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "f_id")
	private int feedbackId;
	
	private String comments;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cust_id")
	private Customers customerFeedback;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "test_id")
	private Test testFeedback;
	

}
