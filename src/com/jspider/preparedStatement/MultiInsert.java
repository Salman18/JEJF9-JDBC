package com.jspider.jdbcprograms.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MultiInsert {
	public static void main(String[] args){
		System.out.println("Main Started");
		
		String Query="insert into jejf9.student_table values(?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		Scanner scan=new Scanner(System.in);
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		    pstmt=con.prepareStatement(Query);
		    
		    for(int i=0;i<5;i++){
		    	System.out.println("Enter Student ID");
		    	int id=scan.nextInt();
		    	
		    	System.out.println("\nEnter Student Name");
		    	String Name=scan.next();
		    	System.out.println("Enter Student Department");
		    	String dept=scan.next();
		    	
		    	pstmt.setInt(1, id);
		    	pstmt.setString(2, Name);
		    	pstmt.setString(3, dept);
		    	
		    	int res=pstmt.executeUpdate();
		    	System.out.println("Number of records inserted  "+res);
		    	
				  
		  
		    }
		    
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} finally{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
				  e.printStackTrace();
				}
			}
			
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		System.out.println("MainEnded");
	}
	}

}
