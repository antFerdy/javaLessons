package com.java.lesson22;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	//Data Transfer Object
	//Properties
	private int empNumber;
	private String empName;
	private String empJob; 
	
	//Setters 
	public void setNumber(int num) {
		empNumber = num; 
	}
	
	public void setName(String name) {
		empName = name;
	}
	
	public void setJob(String job) {
		empJob = job;
	}
	
	
	
	//Getters 
	public int getNum() {
		return empNumber;
	}
	
	public String getName() {
		return empName;
	}
	
	public String getJob() {
		return empJob;
	}
	
	
}
