package com.thepjprogrammer.rest.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;


public class MySQLConnectionManager {
	
	public static Connection getDatabaseConnection(String databaseName) throws Exception {
		
		ResourceBundle dbResourceBundle = ResourceBundle.getBundle("com.thepjprogrammer.rest.db.config.dbConfig");
		
		String url = dbResourceBundle.getString("dev.mysql.jdbc.url");
		String dbName = databaseName;
		String driver = dbResourceBundle.getString("dev.mysql.jdbc.driver");
		String userName = dbResourceBundle.getString("dev.mysql.jdbc.username");
		String password = dbResourceBundle.getString("dev.mysql.jdbc.password");
		
		Class.forName(driver).newInstance();
		Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		
		return conn;
	}
	
	public static ResultSet runQuery(String sqlQuery, Connection dbConnection)
	{
		ResultSet dbResults = null;
		
		try {
			Statement statement = dbConnection.createStatement();
			dbResults = statement.executeQuery(sqlQuery);
		}
		catch(SQLException exception){
			System.out.println("An error occurred while executing sql query");
		}
		
		return dbResults;
	}
	
}
