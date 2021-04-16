package com.tyss.ems;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProducersSelecting {

	public static void main(String[] args) {

		Connection connection = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			//loading the drivers.......
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting the connection via Drivermanagement.........
		connection =	DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		
		cstm= connection.prepareCall("call employee_details()");
		
	rs=	cstm.executeQuery();
	 
	while(rs.next()) {
		System.out.println(rs.getInt("emp_id"));
		System.out.println(rs.getString("emp_name"));
		System.out.println(rs.getInt("salary"));
		System.out.println(rs.getString("dept"));
		System.out.println(rs.getLong("phn_no"));
		System.out.println("--------------------------------------");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(connection!=null)
					 connection.close();
					if(cstm!=null)
					  cstm.close();
					if(rs!=null)
						rs.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
