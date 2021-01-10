package net.PharmacyStock.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;

import net.PharmacyStock.swing.Employee;
import net.PharmacyStock.swing.UserRegistration;
import javax.swing.JScrollPane;

public class EmployeeApp extends JFrame {

	private JPanel contentPane;
	private JTextField NameTextField;
	
	private UserRegistration userReg;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeApp frame = new EmployeeApp();
					frame.setVisible(true);
					frame.refreshEmployeesView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeApp() {
		
		try {
			userReg = new UserRegistration();
		} catch(Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error: ", JOptionPane.ERROR_MESSAGE );
		}
		
		
		setTitle("Employee App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterName = new JLabel("Enter Name: ");
		panel.add(lblEnterName);
		
		NameTextField = new JTextField();
		panel.add(NameTextField);
		NameTextField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String firstName = NameTextField.getText();
					
					List<Employee> employees = null;
					
					if(firstName != null && firstName.trim().length() > 0) {
						employees = userReg.searchEmployees(firstName);
					} else {
						employees = userReg.getAllEmployees();
					}
					
					EmployeeTableModel model = new EmployeeTableModel(employees);
					
					table.setModel(model);
					/*
					for(Employee temp : employees) {
						System.out.println(temp);
					}*/
				} catch(Exception exc) {
					JOptionPane.showMessageDialog(EmployeeApp.this, "Error: " + exc, "Error:", JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		panel.add(btnSearch);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEmployeeDialog dialog = new AddEmployeeDialog(EmployeeApp.this, userReg, null, false);
				
				dialog.setVisible(true);
			}
		});
		panel.add(btnAddEmployee);
		
		JButton btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				
				if(row < 0) {
					JOptionPane.showMessageDialog(EmployeeApp.this, "You must select an employee", "Error:", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Employee tempEmployee = (Employee) table.getValueAt(row, EmployeeTableModel.OBJECT_COL);
				
				AddEmployeeDialog dialog = new AddEmployeeDialog(EmployeeApp.this, userReg, tempEmployee, true);
				
				dialog.setVisible(true);
			}
		});
		panel.add(btnUpdateEmployee);
		
		JButton btnDeleteEmployee = new JButton("Delete");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = table.getSelectedRow();
					
					if(row < 0) {
						JOptionPane.showMessageDialog(EmployeeApp.this, "You must select an employee", "Error:", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					int response = JOptionPane.showConfirmDialog(EmployeeApp.this, "Delete this employee?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(response != JOptionPane.YES_OPTION) {
						return;
					}
					
					Employee tempEmployee = (Employee) table.getValueAt(row, EmployeeTableModel.OBJECT_COL);
					
					userReg.deleteEmployee(tempEmployee.getId());
					
					refreshEmployeesView();
					
					JOptionPane.showMessageDialog(EmployeeApp.this, "Employee deleted successfully", "Employee Deleted", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception exc){
					JOptionPane.showMessageDialog(EmployeeApp.this, "Error deleting employee: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnDeleteEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public void refreshEmployeesView() {
		try {
			List<Employee> employees = userReg.getAllEmployees();
			
			EmployeeTableModel model = new EmployeeTableModel(employees);
			
			table.setModel(model);
		}catch(Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
