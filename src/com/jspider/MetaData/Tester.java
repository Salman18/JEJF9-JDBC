package com.jspider.metaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Tester {
	

	public static void main(String[] args) {
		System.out.println("main method started");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		//Using collection of type ArrayList
		ArrayList<Employee> al=new ArrayList<Employee>();
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement("select * from jejf9.employee_table");
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString("name");
				double salary=rs.getDouble("salary");
				System.out.println(id+"\t"+name+"\t"+salary);
				Employee emp=new Employee(id, name, salary);
				al.add(emp);
				
			}
			
			
			Iterator<Employee> it=al.iterator();
			while(it.hasNext()){
				Employee emp=it.next();
				System.out.println(emp);
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		
		
		
	System.out.println("Main method ended");
	}
}

