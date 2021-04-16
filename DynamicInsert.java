package com.tyss.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class DynamicInsert {

	public static void main(String[] args) {
		
		Connection connection= null;
		PreparedStatement pstm = null;
		try {
			//loading the Drivers.........
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting the connection via drivers.......
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			
			//issue SQL query ...........
			String query = "insert into employee values(?,?,?,?,?)";
			pstm=connection.prepareStatement(query);
			
//			pstm.setInt(1, 202);
//			pstm.setString(2, "prasannakumar");
//			pstm.setInt(3, 55000);
//			pstm.setString(4, "engineer");
//			pstm.setLong(5, 1234567890);
			
			//here we taking the values by using the Scanner class which are us505er input.....
			Scanner sc = new Scanner(System.in);
			System.out.println("enter emp_id......");
			pstm.setInt(1,sc.nextInt());
			System.out.println("enter employee name......");
			pstm.setString(2, sc.next());
			System.out.println("enter salary......");
			pstm.setInt(3, sc.nextInt());
			System.out.println("enter department......");
			pstm.setString(4, sc.next());
			System.out.println("enter phone number.....");
			pstm.setLong(5, sc.nextLong());
			
			
			pstm.executeUpdate();//here we are executing the query and inserting the values.......
			System.out.println("successfully updated data.....");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				try {
					connection.close();
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
