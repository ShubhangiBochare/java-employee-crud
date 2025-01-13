package com.jdbc.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			String query = "insert into jdbc_tables.employee values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 14);
			pstmt.setString(2, "Priyanka");
			pstmt.setString(3, "Developer");
			pstmt.setDouble(4, 40000);
			
			pstmt.execute();
			
			con.close();
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
