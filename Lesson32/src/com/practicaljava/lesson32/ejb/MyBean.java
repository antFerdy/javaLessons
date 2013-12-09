package com.practicaljava.lesson32.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SessionBean
 */
@Stateless //Bean ��� ���������. �.� �� ����������� ������� ����������.
@LocalBean // ��������� ���. �.� ��� ����������� ��� �� ��� � �������. ����� ����� ������� Remote � 
public class MyBean {
	
	public String sayHello() {
		return "Hello world";
	}

}
