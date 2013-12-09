package com.practicalJava.Lesson7.tryit;

public class TestPayIncreaseInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Payable workers[] = new Payable[3];
			workers[0] = new Employee("John"); 
			workers[1] = new Contractor("Marie");
			workers[2] = new Employee("Stanly");
			
		for(Payable p: workers) {
			((Payable)p).increasePay(30);
			
		}
			

	}

}
