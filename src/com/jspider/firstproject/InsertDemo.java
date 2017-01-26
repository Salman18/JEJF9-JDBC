package com.jspider.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class InsertDemo {

	public static void main(String[] args) {

		System.out.println("Main started");
		String query = "insert into jejf9.student_table values(2,'salman','IS')";
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and Registered");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection Established...");

			stmt = con.createStatement();
			System.out.println("Statement or Platform Created..");

			int noOfrows = stmt.executeUpdate(query);

			System.out.println("Query executed Successfully");
			System.out.println("Number of records afected are "+noOfrows);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("main ended");
	}

}
