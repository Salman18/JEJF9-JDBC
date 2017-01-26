package com.jspider.TransactionProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) {
	System.out.println("main Method Started");
	
	Connection con=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	
	
	String Query1="insert into jejf9.student_info values(?,?,?)";
	String Query2="insert into jejf9.student_academics values(?,?,?)";
	
      
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter student info\nID--->");
	 int id=sc.nextInt();
	 System.out.println("name--->");
	   String Name=sc.next();
	   System.out.println("Place--->");
	   String Place= sc.next();
	   System.out.println("percentage--->");
	   double perc=sc.nextDouble();
	   sc.close();
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		 con=DriverManager.getConnection("jdbc:mysql:///localhost:3306?user=root&password=root");
		
		con.setAutoCommit(false);
		System.out.println("Auto commit mode is Disabled");
		
		pstmt1=con.prepareStatement(Query1);
		pstmt1.setInt(1, id);
		pstmt1.setString(2, Name);
		pstmt1.setString(3, Place);
		
		 int i=pstmt1.executeUpdate();
		 System.out.println("Number of Records of Affected.."+i);

		 
		pstmt2=con.prepareStatement(Query2);
		pstmt2.setInt(1, id);
		pstmt2.setString(2, Name);
		pstmt2.setDouble(3,perc);
		
		
		 i=pstmt2.executeUpdate();
		 System.out.println("Number of Records of Affected.."+i);
		 
		 
		 con.commit();
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		try {
			con.rollback();
			System.out.println("Rollback happened");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}finally{
		if(pstmt2!= null){
           			
			try {
				pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt1!= null){
   			
			try {
				pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!= null){
   			
			try {
				pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
			
		

	
	
	
	System.out.println("Main Method ended");
	}

}
