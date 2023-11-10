package com.doctors.entities;

import java.sql.Date;

import lombok.Data;

@Data
public class TestDTO {
	private int customerId;
    private String testName;
    private String doctor;
    private Date testDate;
	
    

}
