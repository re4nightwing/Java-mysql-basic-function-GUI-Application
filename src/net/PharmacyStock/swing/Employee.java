package net.PharmacyStock.swing;
import java.math.BigDecimal;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	private String designation;
	private String dob;
	private BigDecimal salary;
	private String email;
	
	public Employee(int id, String firstName, String lastName, String address, String gender, String designation, String dob, BigDecimal salary, String email) {
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.gender=gender;
		this.designation=designation;
		this.dob=dob;
		this.salary=salary;
		this.email=email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary=salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", gender=" + gender + ", designation=" + designation + ", dob=" + dob + ", salary=" + salary
				+ ", email=" + email + "]";
	}

}
