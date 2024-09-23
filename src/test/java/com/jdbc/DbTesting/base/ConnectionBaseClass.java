package com.jdbc.DbTesting.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.BeforeTest;


public class ConnectionBaseClass {

	public static Connection connection;
	String username="root";
	String password ="ramkumar";
	String url="jdbc:mysql://localhost:3306/db_testing";


	
	@BeforeTest
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void close() throws SQLException {
		connection.close();
	}

}
