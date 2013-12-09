package com.java.lesson22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeList {

	
	
	
	
	public static void main(String[] args) {
		/*try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			
			String query = "SELECT * from Employee";
			state = conn.createStatement();
			
			rs = state.executeQuery(query);
			
			
			while(rs.next()) {
				int eNom = rs.getInt("EMPNO");
				String name = rs.getString("EMPNAME");
				String jobTitle = rs.getString("JOBTITLE");
				
				System.out.println("Номер работника: " + eNom + ". имя работника: " + name + ". должность работника: " + jobTitle);
				
			}
			
			
			
			
		} catch (SQLException e) {
			e.getErrorCode();
			e.printStackTrace();
		}
		
		

	}

}
