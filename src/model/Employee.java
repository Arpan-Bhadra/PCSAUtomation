package model;

public class Employee {
	private int employeeID;
	private String firstName;
	private  String lastName;
	private  String userID;
	private  String password;
	private  String role;
	private  String gender;
	private  String active;
	public Employee() {
		
	}
	public Employee(String firstName, String lastName, String userID, String password, String role, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userID = userID;
		this.password = password;
		this.role = role;
		this.gender = gender;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userID=" + userID + ", password=" + password + ", role=" + role + ", gender=" + gender
				+ ", active=" + active + "]";
	}
	
}
