package com.tyss.ems;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

//import java.sql.DriverManager;
//import java.sql.SQLException;
//import com.mysql.jdbc.Driver;

public class StaticInsert {
	public static void main(String[] args) {
		java.sql.Connection con=null;
		Statement stm= null;
		
		// load the drive
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
//			Driver  driver= new Driver();
//			DriverManager.registerDriver(driver);
			System.out.println("driver loaded successfully.......");
		}
		catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
//			catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			//2.get connection via connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.issue SQL query via connection
		//String query1 = "insert into employee values(101,'prasanna',35000,'developer',7995475117)";
		String query2 = "insert into employee values(202,'manohar',150000,'CA',7675990245)";
		String query3 = "insert into employee values(303,'boreddy',45000,'developer',7989265963)";
		String query4 = "insert into employee values(404,'marynirmala',85000,'creater',6303440797)";
		 try {
			stm = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count;
		try {
		//	count = stm.executeUpdate(query1);
			count = stm.executeUpdate(query2);
			count = stm.executeUpdate(query3);
			count = stm.executeUpdate(query4);
			System.out.println("Number of rows affected : "+count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stm!=null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		 
		
	}
	

}
