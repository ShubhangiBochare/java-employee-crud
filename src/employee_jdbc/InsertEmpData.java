package employee_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmpData {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "root";
		
			try {
				//Step 1: Load Driver 
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Drier class loaded");
				
				//Step 2: Get Connection
				Connection con = DriverManager.getConnection(url, username, password);
				System.out.println("Connection object created" +con);
				
				//Step 3: Get Connection
				Statement stmt = con.createStatement();
				
				//Step 4: Execute Query
				String query = "insert into jdbc_tables.employee values(13, 'poonam', 'cyber security analyst', 30000)";
				stmt.execute(query);
				
				//Step 5: Close connection
				
				con.close();
				
				System.out.println("Employee Data is Inserted");
				
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
