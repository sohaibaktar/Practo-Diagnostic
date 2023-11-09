package com.doctors.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tests")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int test_id;
	@Column(name = "test_name")
	private String testName;
	@Column(name = "test_date")
	private Date testDate;

	@Column(name = "doctor")
	private String doctor;
	
	@Lob
	@Column(name = "prescription")
    private byte[] prescriptionImage;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cust_id", referencedColumnName = "id")
	private Customers customerId;
	

}
