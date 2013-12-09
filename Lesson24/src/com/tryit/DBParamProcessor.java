package com.tryit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DBParamProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Получаем класс из названия 
			Class currentClass = Class.forName("com.tryit.myDBworker");
			
			//Получаем аннотацию
			Annotation [] annot = currentClass.getDeclaredAnnotations();
			
			//Принтуем аннтоции
			for(int i = 0; i<annot.length;i++) {
				System.out.println(annot[i].toString());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
