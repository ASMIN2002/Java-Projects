package com.asmin.main.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ControllerImpl {
	Scanner scanner = new Scanner(System.in);

	public void add() {
		System.out.println();
		System.out.println("ADD MODULE");
		System.out.println("==============");
		System.out.print("ENTER EMPLOYEE ID       : ");
		int eid = scanner.nextInt();
		System.out.print("ENTER EMPLOYEE NAME     : ");
		String ename = scanner.next();
		System.out.print("ENTER EMLOYEE SALARY    : ");
		float esal = scanner.nextFloat();
		System.out.print("ENTER EMPLOYEE ADDRESS  : ");
		String eaddr = scanner.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root",
					"Asmin@2002");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into emp1 values(?,?,?,?)");
			preparedStatement.setInt(1, eid);
			preparedStatement.setString(2, ename);
			preparedStatement.setFloat(3, esal);
			preparedStatement.setString(4, eaddr);

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("Employee Inserted Successfully");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			System.out.println("Can not Inserted Id Already Exist");
		}

	}

	public void search() {
		System.out.println("SEARCH MODULE");
		System.out.println("==================");
		System.out.print("ENTER EMPLOYEE ID       : ");
		int eid = scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root",
					"Asmin@2002");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from emp1 where eno =?");
			preparedStatement.setInt(1, eid);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Employee Details");
				System.out.println("===================");
				System.out.println("Employee Id      : " + resultSet.getInt(1));
				System.out.println("Employee NAME    : " + resultSet.getString(2));
				System.out.println("Employee SALARY  : " + resultSet.getFloat(3));
				System.out.println("Employee ADDRESS : " + resultSet.getString(4));

			} else {
				System.out.println("Employee Does Not exist");
			}

		} catch (Exception e) {

		}
	}

	public void update() {
		PreparedStatement preparedStatement;
		System.out.println("UPDATE MODULE");
		System.out.println("==================");
		System.out.print("ENTER EMPLOYEE ID       : ");
		int eid = scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root",
					"Asmin@2002");
			preparedStatement = connection.prepareStatement("select * from emp1 where eno =?");
			preparedStatement.setInt(1, eid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				System.out.print("Your Old Name is "+resultSet.getString(2)+" Enter New Name       : ");
				String name = scanner.next();
				System.out.print("Your Old Salary is "+resultSet.getFloat(3)+" Enter new Salary     : ");
				float sal = scanner.nextFloat();
				System.out.print("Youe Old Address is "+resultSet.getString(4)+" Enter New Address  : ");
				String addr = scanner.next();
				
				preparedStatement = connection.prepareStatement("update emp1 set ename=?,esal=?,eaddr=? where eno = ?");
				preparedStatement.setString(1, name);
				preparedStatement.setFloat(2, sal);
				preparedStatement.setString(3, addr);
				preparedStatement.setInt(4, eid);
				
				int count = preparedStatement.executeUpdate();
				if(count > 0) {
					System.out.println("Your data updation successfully");
				}else {
					System.out.println("Failed");
				}
				
			}else {
				System.out.println("Employee Does Not exist");
			}

		} catch (Exception e) {

		}
	}
	public void delete() {
		System.out.println("UPDATE MODULE");
		System.out.println("==================");
		System.out.print("ENTER EMPLOYEE ID       : ");
		int eid = scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root",
					"Asmin@2002");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from emp1 where eno = ?");
			preparedStatement.setInt(1, eid);
			try {
				int count = preparedStatement.executeUpdate();
				if(count > 0) {
					System.out.println("DELETION SUCCESS");
				}else {
					System.out.println("EMPLOYEE DOESNOT EXIST");
				}
			}catch(Exception e) {
				System.out.println("Employee Does not Exist");
			}
		}catch(Exception e) {
			
		}
	}
}
