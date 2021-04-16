package com.tyss.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DynamicUpdateUsingRunConf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstam= null;
		ResultSet rs= null;
		try {
			// loading the drivers.......
		Class.forName("com.mysql.jdbc.Driver");
		
		//Getting connection........
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		
		String query = "select * from employee where emp_id=?";
		
		pstam=conn.prepareStatement(query);
		
		String eid = args[0];
	int employee_id = 	Integer.parseInt(eid);
	//binding the parameters......
	pstam.setInt(employee_id,101 );
	
	rs=pstam.executeQuery();
	
	//processing then valuse by using the while loop
	while(rs.next()) {
		System.out.println(rs.getInt("emp_id"));
		System.out.println(rs.getString("emp_name"));
		System.out.println(rs.getInt("salary"));
		System.out.println(rs.getString("dept"));
		System.out.println(rs.getLong("phn_no"));
	}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
