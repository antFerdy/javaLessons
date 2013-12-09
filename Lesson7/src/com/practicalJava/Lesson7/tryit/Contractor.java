package com.practicalJava.Lesson7.tryit;

public class Contractor implements Payable {
	
	public String name;
	
	public Contractor (String name) {
		this.name = name;
	}

	@Override
	public boolean increasePay(int percent) {
		if(percent < Payable.INCREASE_CAP) {
			System.out.println("The salary was increased " + percent + "% ");
			return true;
		}
		
		else {
			System.out.println("Sorry, can't increase salary more than " + percent + "%");
			return false;
		}
	}
	
}
