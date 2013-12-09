package com.java.lesson22;

import java.sql.*;

import com.java.lesson22.Portfolio;

public class TestPortfolio {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			stmt.addBatch("INSERT INTO Portfolio2 values" + " {2,'FFIV',189.77,900}");
			stmt.addBatch("INSERT INTO Portfolio2 values" + " {3,'GOOG,546.8,8800");
			stmt.addBatch("INSERT INTO Portfolio2 values" + " {4,'GMCR',110.25,800}");
			conn.commit();
			
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			System.out.println("Failed");
		}
	
		
		Portfolio portfGet = new Portfolio();
		Thread portf = new Thread(portfGet);
		portf.start();
		
		
		
	}

}
