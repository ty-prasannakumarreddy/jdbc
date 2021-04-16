package com.tyss.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectingRows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		ResultSet res = null;

		try {
			// loading the drivires.......
			Class.forName("com.mysql.jdbc.Driver");

			// 2.getting connection via connectors.......
		//	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?password=root&user=root");
			//Overloaded method of getConnection 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");

			// 3.issus SQL queries via connection...........
			stm = con.createStatement();
			res = stm.executeQuery("select * from employee");

			// 4. processing the result vis result set...........
			while (res.next()) {
				System.out.println(res.getInt("emp_id"));
				System.out.println(res.getString("emp_name"));
				System.out.println(res.getInt("salary"));
				System.out.println(res.getString("dept"));
				System.out.println(res.getLong("phn_no"));
				System.out.println("---------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null || stm != null || res != null)
				try {
					con.close();
					stm.close();
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
