package com.jspider.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MultipleInsert {

	public static void main(String[] args) {
		System.out.println("main Started");
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registerd");
			
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			 stmt=con.createStatement();
			
			String Query1="insert into jejf9.student_table values(3,'khan','IS')";
			String Query2="insert into jejf9.student_table values(4,'Tajammul','IS')";
			String Query3="insert into jejf9.student_table values(5,'Mahadev','CS')";
			
			
			int r1=stmt.executeUpdate(Query1);
			int r2=stmt.executeUpdate(Query2);
			int r3=stmt.executeUpdate(Query3);
			
			System.out.println(r1+"\t"+r2+"\t"+r3+"\t");
		   } 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		 finally{
			 if(stmt!=null){
				 try{
					 stmt.close();
				 }catch(SQLException e){
					 e.printStackTrace();
				 }
			 }
			 if(con!=null){
				 try{
					 con.close();
					 
				 }catch(SQLException e){
					 e.printStackTrace();
					 
				 }
			 }
		 }
		
		
		
		
		
		
		
		System.out.println("main Ended");

	}

}
