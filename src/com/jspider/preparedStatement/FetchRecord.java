package com.jspider.jdbcprograms.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchRecord {

	public static void main(String[] args) {
		
		System.out.println("main started");
		String Query="select * from jejf9.student_table";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		    pstmt=con.prepareStatement(Query);
		    
		    boolean res=pstmt.execute();
		    System.out.println("platform Created");
		   
		    	if(res){
		    		rs=pstmt.getResultSet();
		    		System.out.println("Result set Created");
		    		
		    		//if(rs.absolute(5))
		    		while(rs.next()){
		    			int id=rs.getInt(1);
		    			String Name=rs.getString("Name");
		    			String dept=rs.getString(3);
		    			
		    			System.out.println(id+"\t"+Name+"\t"+dept);
		    			
		    		}
		    	}
		    
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} finally{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
				  e.printStackTrace();
				}
			}
			
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
		}
		
		
		
		
		System.out.println("MainEnded");

		}
		
		
		
		
		
	}
		
