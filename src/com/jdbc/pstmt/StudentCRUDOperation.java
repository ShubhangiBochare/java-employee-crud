package com.jdbc.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCRUDOperation {
	
	public static void insert(int id,String name,String designation, double salary)
	{
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			String query = "insert into jdbc_tables.employee values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, designation);
			pstmt.setDouble(4, salary);
			
			pstmt.execute();
			
			con.close();
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void update(int id, String name)
	{
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			String query = "update jdbc_tables.employee set name = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			
			pstmt.execute();
			
			con.close();
			System.out.println("Data Updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void delete(int id)
	{
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			String query = "delete from jdbc_tables.employee where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			pstmt.execute();
			
			con.close();
			System.out.println("Data Deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void printAllData(int id)
	{
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			String query = "select * from  jdbc_tables.employee where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getDouble(4));
			}
			
			con.close();
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
