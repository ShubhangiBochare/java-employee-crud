package employee_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				String url = "jdbc:mysql://localhost:3306";
				String username = "root";
				String password = "root";
				
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stmt = con.createStatement();
					String query = "select * from jdbc_tables.employee";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {
						System.out.println(rs.getInt(1));
						System.out.println(rs.getString(2));
						System.out.println(rs.getString(3));
						System.out.println(rs.getDouble(4));
						System.out.println("----------------------------");
					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
