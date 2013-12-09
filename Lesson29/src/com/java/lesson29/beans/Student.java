package com.java.lesson29.beans;

import javax.annotation.ManagedBean;

@ManagedBean
public class Student {
	private String name;
	private long studentId;
	private int classId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	
	
	
	
}
