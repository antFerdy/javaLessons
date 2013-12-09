
package com.java.lesson23;
import java.sql.*;
import java.util.ArrayList;


public class Portfolio implements Runnable {


	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList<Order> list = new ArrayList<Order>();
	
	@Override
	public void run() {
	
		//ResultSetMetaData rsmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			stmt = conn.createStatement();
			String query = "Select * from Portfolio3";
			rs = stmt.executeQuery(query);
			
			
			while(rs.next()) {
				list.add(new Order(rs.getInt("id"),rs.getString("symbol"),rs.getDouble("price"),rs.getInt("quantity")));
				/*System.out.println(rs.getInt("id")+ " " + rs.getString("symbol") + " " + rs.getInt("quantity") + " " + rs.getDouble("price") + 
						" Buying power used: " +  rs.getInt("quantity") * rs.getDouble("price"));*/
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
				
			}
			
		}
		
	}

}
