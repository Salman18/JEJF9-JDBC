package com.jspider.jdbcprograms.batchDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateDemo {

	public static void main(String[] args) {
		
		
		System.out.println();
		
		
		String Query1="insert into jejf9.student_table values(7,'prem','ec')";
		String Query2="update jejf9.student_table set department='ISE' where id=5";
		String Query3="delete from jejf9.student_table where department='ec'";
		
		Connection con=null;
		Statement stmt=null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		    stmt=con.createStatement();
		    
			
		    stmt.addBatch(Query1);
			stmt.addBatch(Query3);
			stmt.addBatch(Query2);
			
			
			System.out.println("DML statements are added into thr batch");
			
			int[] res=stmt.executeBatch();
			
			System.out.println("Batch executed");

			for (int i = 0; i < res.length; i++) {
				System.out.println("res["+i+"]---->"+res[i]);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}finally{
			if(stmt!=null)
			{
				try {
					stmt.close();
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
		
		
		}
	}
}
	
		
	
