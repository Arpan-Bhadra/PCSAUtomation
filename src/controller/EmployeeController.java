package controller;

import java.io.*;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

import dao.IEmployeeDao;
import daoImpl.EmployeeDao;
import model.Employee;

public class EmployeeController {

	IEmployeeDao empDao=null;
	public EmployeeController() throws ClassNotFoundException, SQLException{
		empDao=new EmployeeDao();
	}
	public Employee checkLogin(String userId,String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
	}
	
	public void addEmployee() {
		Employee emp=new Employee();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter First Name:");
			emp.setFirstName(reader.readLine());
			System.out.println("Enter Last Name:");
			emp.setLastName(reader.readLine());
			System.out.println("Enter UserId:");
			emp.setUserID(reader.readLine());
			System.out.println("Enter Password:");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Role:");
			String role=reader.readLine();
			emp.setRole(role);
			System.out.println("Enter Gender:");
			emp.setGender(reader.readLine());
			if(role.equals("HRA")) {
				emp.setActive("Active");
			}
			else {
				emp.setActive("Deactive");
			}
			//Calling dao method for insert record
			empDao.addEmployee(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllEmployees() {
		
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
	
	public void getEmployeeById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmployeeId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			System.out.println(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateEmployee() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String password, confirmpassword;
			System.out.println("Enter EmployeeId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			System.out.println("Enter your new password:");
			password=reader.readLine();
			System.out.println("Re-enter same password to confirm:");
			confirmpassword=reader.readLine();
			if(password.equals(confirmpassword)) {
				emp.setPassword(password);
				empDao.updateEmployee(emp);
			}
			else {
				System.out.println("Sorry! you have entered different password!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveEmployee() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmployeeId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			empDao.deactivateEmployee(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteEmployee() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmployeeId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empDao.deleteEmployee(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}