package net.PharmacyStock.swing;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;

public class UserRegistration {
	
	private Connection myConn;
	
	public UserRegistration() throws Exception{
		
		Properties props = new Properties();
		props.load(new FileInputStream("sql/PhStock.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connected successfully to: " + dburl);
		
	}
	
	public void addEmployee(Employee theEmployee) throws Exception {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("insert into employee"
					+ "(F_Name, L_Name, address, gender, designation, DOB, salary, email)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getAddress());
			myStmt.setString(4, theEmployee.getGender());
			myStmt.setString(5, theEmployee.getDesignation());
			myStmt.setString(6, theEmployee.getDob());
			myStmt.setBigDecimal(7, theEmployee.getSalary());
			myStmt.setString(8, theEmployee.getEmail());
			
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Employee> getAllEmployees() throws Exception{
		List<Employee> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from employee");
			
			while(myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	public List<Employee> searchEmployees(String firstName) throws Exception{
		List<Employee> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			firstName += "%";
			myStmt = myConn.prepareStatement("select * from employee where F_Name like ?");
			
			myStmt.setString(1, firstName);
			
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close( myStmt, myRs);
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException{
		
		int id = myRs.getInt("Emp_ID");
		String firstName = myRs.getString("F_Name");
		String lastName = myRs.getString("L_Name");
		String address = myRs.getString("address");
		String gender = myRs.getString("gender");
		String designation = myRs.getString("designation");
		String dob = myRs.getString("DOB");
		BigDecimal salary = myRs.getBigDecimal("salary");
		String email = myRs.getString("email");
		
		Employee tempEmployee = new Employee(id, firstName, lastName, address, gender, designation, dob, salary, email);
		
		return tempEmployee;
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		if(myRs != null) {
			myRs.close();
		}
		if(myStmt != null) {
			
		}
		if(myConn != null) {
			myConn.close();
		}
	}
	
	private void close(Statement myStmt, ResultSet myRs) throws SQLException{
		close(null, myStmt, myRs);
	}
	
	
	
	public void updateEmployee(Employee theEmployee) throws SQLException {
		
		PreparedStatement myStmt = null;
		
		try {
			myStmt = myConn.prepareStatement("update employee " + "set F_Name=?, L_Name=?, address=?, "
					+ "gender=?, designation=?, DOB=?, salary=?, email=? where Emp_ID=?");
			
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getAddress());
			myStmt.setString(4, theEmployee.getGender());
			myStmt.setString(5, theEmployee.getDesignation());
			myStmt.setString(6, theEmployee.getDob());
			myStmt.setBigDecimal(7, theEmployee.getSalary());
			myStmt.setString(8, theEmployee.getEmail());
			
			myStmt.setInt(9, theEmployee.getId());
			
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
	}
	
	public void deleteEmployee(int employeeId) throws SQLException{
		PreparedStatement myStmt = null;
		
		try {
			myStmt = myConn.prepareStatement("delete from employee where Emp_ID=?");
			
			myStmt.setInt(1, employeeId);
			
			myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
	}
}
