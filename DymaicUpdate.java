package com.tyss.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.sql.jdbc.PreparedStatement;
//import com.sun.java_cup.internal.runtime.Scanner;

public class DymaicUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		try {
	//loading the driver.....
			Class.forName("com.mysql.jdbc.Driver");
			
			//Gettting connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			
			//3.issue SQL query.......
			String query ="update  employee set  emp_name=? where emp_id=?";
			pstm = conn.prepareStatement(query);
			
			//binding the parameters.....
			//reading input from user............
			
			java.util.Scanner sc = new java.util.Scanner(System.in);
			System.out.println("enter index and name  value.....");
			pstm.setString(sc.nextInt(), sc.next());
			
			System.out.println("enter index and id value.....");
			pstm.setInt(sc.nextInt(), sc.nextInt());
			
//			pstm.setString(1, "manohar");
//			pstm.setInt(2, 101);
			int count =pstm.executeUpdate();
			System.out.println("Number of rows affected :"+count);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstm!=null)
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	

	}

}
