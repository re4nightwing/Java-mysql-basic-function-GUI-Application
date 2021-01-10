package net.PharmacyStock.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import net.PharmacyStock.swing.Employee;

class EmployeeTableModel extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME = 0;
	private static final int LAST_NAME = 1;
	private static final int ADDRESS = 2;
	private static final int GENDER = 3;
	private static final int DESIGNATION = 4;
	private static final int DATE_OF_BIRTH = 5;
	private static final int SALARY = 6;
	private static final int EMAIL = 7;
	
	private String[] columnNames = {"First Name", "Last_name", "Address", "Gender", "Designation", "DOB", "Salary", "Email"};
	private List<Employee> employees;
	
	public EmployeeTableModel(List<Employee> theEmployees) {
		employees = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Employee tempEmployee = employees.get(row);
		
		switch(col) {
		case FIRST_NAME:
			return tempEmployee.getFirstName();
		case LAST_NAME:
			return tempEmployee.getLastName();
		case ADDRESS:
			return tempEmployee.getAddress();
		case GENDER:
			return tempEmployee.getGender();
		case DESIGNATION:
			return tempEmployee.getDesignation();
		case DATE_OF_BIRTH:
			return tempEmployee.getDob();
		case SALARY:
			return tempEmployee.getSalary();
		case EMAIL:
			return tempEmployee.getEmail();
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getFirstName();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
