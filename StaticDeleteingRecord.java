package com.tyss.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticDeleteingRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection= null;
		Statement stm = null;
		try {
			//loading the Drivers........
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting connection via driverManager interface 
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			
			//issus SQL query .....
			String query = "delete from employee where emp_id=202";
			stm=connection.createStatement();
			int count=stm.executeUpdate(query);
			System.out.println("Number of rows Affected : "+count);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null)
				try {
					connection.close();
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
