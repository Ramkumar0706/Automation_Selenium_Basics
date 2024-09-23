package com.jdbc.DbTesting.automationEmployee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.jdbc.DbTesting.base.ConnectionBaseClass;

public class EmployeeDatabase extends ConnectionBaseClass{
	
	
	@Test(priority = 1)
	public void  test_DB_InsertData() throws SQLException {
		connection=super.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values (?,?,?,?);");
		preparedStatement.setInt(1, 105);
		preparedStatement.setString(2, "Gokul");
		preparedStatement.setInt(3, 2000);
		preparedStatement.setString(4, "Tester");
		preparedStatement.executeUpdate();
		System.out.println("The Value is inserted successfully");
		test_DB_SelectData();
	}
	@Test(priority = 2)
	public void test_DB_UpdateData() throws SQLException {
		connection=super.getConnection();
		PreparedStatement  preparedStatement = connection.prepareStatement("update employee set employeeName= ? where employeeId=?;");
		preparedStatement.setString(1, "ModiJi");
		preparedStatement.setInt(2, 105);
		preparedStatement.executeUpdate();
		System.out.println("Employee is updated successfully");
		test_DB_SelectData();
	}
	
	@Test(priority = 3)
	public void test_DB_DeleteData() throws SQLException {
		connection=super.getConnection();
		PreparedStatement  preparedStatement = connection.prepareStatement("delete from employee where employeeId=?;");
		preparedStatement.setInt(1, 105);
		preparedStatement.executeUpdate();
		System.out.println("deleted successfully");
		test_DB_SelectData();
	}
	
	@Test(priority = 4)
	public void test_DB_SelectData() throws SQLException {
		System.out.println("Displaying all data present in the database");
		connection=super.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee;");
		while(resultSet.next()) {
			System.out.println("Employee Id is : "+resultSet.getInt(1)+" And the name is : "+resultSet.getString(2)
			+" salary is : "+resultSet.getString(3)+" role is : "+resultSet.getString(4));
		}
		
		
	}

}
