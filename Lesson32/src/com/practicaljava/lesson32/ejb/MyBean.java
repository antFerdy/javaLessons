package com.practicaljava.lesson32.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SessionBean
 */
@Stateless //Bean без состояния. Т.е не сохраняющий никаких переменных.
@LocalBean // Локальный бин. Т.е бин выполняется там же где и сервлет. Также можно выбрать Remote и 
public class MyBean {
	
	public String sayHello() {
		return "Hello world";
	}

}
