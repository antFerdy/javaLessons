package com.practicalJava.lesson6;

public class Person {
	private String name;
	
	//create a constructor
	public Person(String name) {
		this.name = name;
	}
	
	//getter
	public String getName() {
		return " Person's name is " + name;
	}

}
