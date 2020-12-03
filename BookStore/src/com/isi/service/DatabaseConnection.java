package com.isi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private final static String databaseName = "bookstore";
	private static String urlConnection = "jdbc:mysql://localhost:3306/"+databaseName;
	private final static String login = "root";
	private final static String pswd = "root";
	private static Connection dbConnection = null;
	
	
	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		if(dbConnection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection = DriverManager.getConnection(urlConnection, login, pswd);
		}
		return dbConnection;
	}
	
	public static Statement getStatementObject() {
		boolean  statusError = false;
		Statement stmt = null;
		try {
			 stmt = getDatabaseConnection().createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			statusError = true;
		}finally {
			if(dbConnection != null && statusError)
				DatabaseConnection.close();
		}
		return stmt;
	}
	
	public static PreparedStatement getPreparedStatement(String sqlQuery) {
		boolean  statusError = false;
		PreparedStatement ps = null;
		
		try {
			 ps = getDatabaseConnection().prepareStatement(sqlQuery);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			statusError = true;
		} finally {
			if(dbConnection != null && statusError)
				DatabaseConnection.close();
		}
		
		return ps;
	}
	
	
	public static void close() {
		try {
			getDatabaseConnection().close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


}
