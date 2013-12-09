package com.java.lesson22;

import java.sql.*;

public class ShowAnyData {

	
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * from Employee";
		
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			ResultSetMetaData column = rs.getMetaData();
			int columnCount = column.getColumnCount();
			
			for(int i = 1; i <= columnCount; i++) {
				System.out.println(column.getColumnName(i) + " ");
			}
			System.out.println();
				
			while(rs.next()) {
				System.out.println(rs.getInt("EMPNO") + " " + rs.getString("EMPNAME") + " " + rs.getString("JOBTITLE"));
				System.out.println("\n");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		

	}

}
