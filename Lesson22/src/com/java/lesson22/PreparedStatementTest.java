package com.java.lesson22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.derby.client.am.PreparedStatement;

public class PreparedStatementTest {
	
	
	public static void main(String[] args) {
		Connection conn = null;
		java.sql.PreparedStatement st = null;
		ResultSet rs = null;
		Integer [] empNumbers = {1844,1895,1474};
		
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			st = conn.prepareStatement("SELECT * from Employee WHERE empno=?");
			for(int i = 0; i < empNumbers.length; i++ ) {
				st.setInt(1, empNumbers[i]);
				rs = st.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("EMPNAME"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
}
