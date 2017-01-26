package com.jspider.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PrepareStatement {

	public static void main(String[] args) {
		System.out.println("Main Method Started");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String qry="insert into jejf9.student_table values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			 pstmt=con.prepareStatement(qry);
			 
			 pstmt.setInt(1,6);
			 pstmt.setString(2,"pasha");
			 pstmt.setString(3, "IS");
			 
			 int res=pstmt.executeUpdate();
			 System.out.println(res);
			 
			 pstmt.setInt(1,7);
			 pstmt.setString(2,"Abuzar");
			 pstmt.setString(3, "IS");
			 
			 int res1=pstmt.executeUpdate();
			 System.out.println(res1);
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
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
		System.out.println("Main Method Ended");

	}

}
