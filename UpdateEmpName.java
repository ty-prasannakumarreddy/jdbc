package com.tyss.ems;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateEmpName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.sql.Connection connection = null;
		java.sql.Statement stam = null;

		// 1.loaded the drivers........
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2.geting the connection........
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String updateQuere = "update employee set emp_name='boreddypkreddy' where emp_id=101";
		// issuse SQL quere via connection
		try {
			stam = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int count = stam.executeUpdate(updateQuere);
			System.out.println("Number of rows Affecte : " + count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stam != null)
				try {
					stam.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
