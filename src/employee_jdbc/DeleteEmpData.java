package employee_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmpData {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "root";
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Drier class loaded");
				Connection con = DriverManager.getConnection(url, username, password);
				System.out.println("Connection object created" +con);
				Statement stmt = con.createStatement();
				String query = "delete from  jdbc_tables.employee where id = 12";
				stmt.execute(query);
				con.close();
				System.out.println("Employee Data is Deleted");
				
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
