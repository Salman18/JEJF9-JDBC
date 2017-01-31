package com.jspider.metaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class MetaDataDemo {

	public static void main(String[] args) {
		System.out.println("main method started");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement("select * from jejf9.student_info");
			
			rs=pstmt.executeQuery();
			
			//Database information
			
		DatabaseMetaData db	=con.getMetaData();
		System.out.println("Database major Version "+db.getDatabaseMajorVersion());
		System.out.println("Database Minor version "+db.getDatabaseMinorVersion());
		System.out.println("Driver Version."+db.getDriverVersion());
	    System.out.println("tsblrs."+db.getTableTypes());
		
			//Table Information
	    ResultSetMetaData rsm=rs.getMetaData();
	    System.out.println("Table Name "+rsm.getTableName(3));
	    System.out.println("Total Number Of Columns "+rsm.getColumnCount());
	    System.out.println("column laBELS "+rsm.getColumnLabel(1));
	    System.out.println(rsm.getColumnClassName(1)+" "+rsm.getColumnTypeName(1));
	    System.out.println(rsm.getColumnClassName(2)+" "+ rsm.getColumnTypeName(2));
	    System.out.println(rsm.getColumnClassName(3)+" "+ rsm.getColumnTypeName(3));
		
			
		} catch (ClassNotFoundException | SQLException e) {
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
