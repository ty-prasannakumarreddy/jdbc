package com.tyss.ems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class UsingPropertyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader filereader=null;
		String user=null;
		String password=null;
		ResultSet rs = null;
		
		try {
		 filereader = new FileReader("C:\\Users\\Prasanna Kumar\\Desktop\\java\\Properties.properties");
		 Properties properties = new Properties();
		 try {
			properties.load(filereader);
			 user=(String)properties.get("user");
			 password=(String)properties.get("password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		Connection connection = null;
		Statement stm = null;
		
		try {
			//loading the Drivers.........
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting the connection via DriverManager.......
			connection=DriverManager.getConnection("jdbc:mysql://loacahost:3306/ems",user,password);
			
			//issue SQL query.........
			String query = "select * from employee where emp_id=404";
			stm=connection.createStatement();
			rs=stm.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("emp_id"));
				System.out.println(rs.getString("emp_name"));
				System.out.println(rs.getInt("salary"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getLong("phn_no"));
				System.out.println("--------------------------------------");
					}
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
