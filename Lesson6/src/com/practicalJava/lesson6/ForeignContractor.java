package com.practicalJava.lesson6;

public class ForeignContractor implements Payable {

	public ForeignContractor(String name) {
	}
	
	public boolean increasePay (int percent) {
		System.out.println("I'm just a foreign worker");
		return true;
	}
	
	
	
}
