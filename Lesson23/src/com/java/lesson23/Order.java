package com.java.lesson23;

public class Order {
	int id;
	String symbol; 
	double price;
	int quantity;
	
	Order(int id,String symbol,double price,int quantity) {
		this.id = id;
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
	}
	
}
