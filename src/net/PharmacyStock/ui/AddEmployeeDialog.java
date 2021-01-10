package net.PharmacyStock.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.PharmacyStock.swing.Employee;
import net.PharmacyStock.swing.UserRegistration;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class AddEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField addressTextField;
	private JComboBox genderComboBox;
	private JComboBox designationComboBox;
	private JTextField dobTextField;
	private JTextField salaryTextField;
	private JTextField emailTextField;

	private UserRegistration userReg;
	private EmployeeApp employeeApp;
	
	private Employee previousEmployee = null;
	private boolean updateMode = false;
	
	public AddEmployeeDialog(EmployeeApp theEmployeeApp, UserRegistration theUserReg, Employee thePreviousEmployee, boolean theUpdateMode) {
		this();
		userReg = theUserReg;
		employeeApp = theEmployeeApp;
		
		previousEmployee = thePreviousEmployee;
		updateMode = theUpdateMode;
		
		if(updateMode) {
			setTitle("Update Employee");
			
			populateGui(previousEmployee);
		}
	}

	private void populateGui(Employee theEmployee) {
		firstNameTextField.setText(theEmployee.getFirstName());
		lastNameTextField.setText(theEmployee.getLastName());
		addressTextField.setText(theEmployee.getAddress());
		genderComboBox.setSelectedItem(theEmployee.getGender());
		designationComboBox.setSelectedItem(theEmployee.getDesignation());
		dobTextField.setText(theEmployee.getDob());
		salaryTextField.setText(theEmployee.getSalary().toString());
		emailTextField.setText(theEmployee.getEmail());
		
	}

	/**
	 * Create the dialog.
	 */
	public AddEmployeeDialog() {
		setTitle("Add New Employee");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblFirstName = new JLabel("First Name:");
			contentPanel.add(lblFirstName, "2, 2, right, default");
		}
		{
			firstNameTextField = new JTextField();
			contentPanel.add(firstNameTextField, "4, 2, fill, default");
			firstNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name:");
			contentPanel.add(lblLastName, "2, 4, right, default");
		}
		{
			lastNameTextField = new JTextField();
			contentPanel.add(lastNameTextField, "4, 4, fill, default");
			lastNameTextField.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address:");
			contentPanel.add(lblAddress, "2, 6, right, default");
		}
		{
			addressTextField = new JTextField();
			contentPanel.add(addressTextField, "4, 6, fill, default");
			addressTextField.setColumns(10);
		}
		{
			JLabel lblGender = new JLabel("Gender:");
			contentPanel.add(lblGender, "2, 8, right, default");
		}
		{
			genderComboBox = new JComboBox();
			genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female", "other"}));
			contentPanel.add(genderComboBox, "4, 8, fill, default");
		}
		{
			JLabel lblDesignation = new JLabel("Designation:");
			contentPanel.add(lblDesignation, "2, 10, right, default");
		}
		{
			designationComboBox = new JComboBox();
			designationComboBox.setModel(new DefaultComboBoxModel(new String[] {"worker", "pharmacist"}));
			contentPanel.add(designationComboBox, "4, 10, fill, default");
		}
		{
			JLabel lblDob = new JLabel("DOB(YYYY-MM-DD):");
			contentPanel.add(lblDob, "2, 12, right, center");
		}
		{
			dobTextField = new JTextField();
			contentPanel.add(dobTextField, "4, 12, fill, default");
			dobTextField.setColumns(10);
		}
		{
			JLabel lblSalary = new JLabel("Salary:");
			contentPanel.add(lblSalary, "2, 14, right, default");
		}
		{
			salaryTextField = new JTextField();
			contentPanel.add(salaryTextField, "4, 14, fill, default");
			salaryTextField.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			contentPanel.add(lblEmail, "2, 16, right, default");
		}
		{
			emailTextField = new JTextField();
			contentPanel.add(emailTextField, "4, 16, fill, default");
			emailTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveEmployee();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
						employeeApp.refreshEmployeesView();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void saveEmployee() {
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String address = addressTextField.getText();
		String gender = genderComboBox.getSelectedItem().toString();
		String designation = designationComboBox.getSelectedItem().toString();
		String dateOfBirth = dobTextField.getText();
		String salaryStr = salaryTextField.getText();
		BigDecimal salary = new BigDecimal(salaryStr);
		String email = emailTextField.getText();
		
		Employee tempEmployee = null;
		
		if(updateMode) {
			tempEmployee = previousEmployee;
			
			tempEmployee.setFirstName(firstName);
			tempEmployee.setLastName(lastName);
			tempEmployee.setAddress(address);
			tempEmployee.setGender(gender);
			tempEmployee.setDesignation(designation);
			tempEmployee.setDob(dateOfBirth);
			tempEmployee.setSalary(salary);
			tempEmployee.setEmail(email);
			
		} else {
			tempEmployee = new Employee(0, firstName, lastName, address, gender, designation, dateOfBirth, salary, email);
		}
		
		try {
			if(updateMode) {
				userReg.updateEmployee(tempEmployee);
			} else {
				userReg.addEmployee(tempEmployee);
			}
			
			setVisible(false);
			dispose();
			
			employeeApp.refreshEmployeesView();
			
			JOptionPane.showMessageDialog(employeeApp, "Employee added Successfully.", "Employee added", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception exc) {
			JOptionPane.showMessageDialog(employeeApp, "Error saving employee: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
