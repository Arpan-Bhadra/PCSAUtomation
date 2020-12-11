package dao;

import model.Employee;
import java.util.*;
public interface IEmployeeDao {
	ArrayList<Employee> getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deleteEmployee(int id);
	void deactivateEmployee(int id);
	//void deactivateEmployee(Employee emp);
	Employee checkLogin(String userId,String password);
	void activateEmployee(int id);
	Employee checkUser(String userId);
	
	
}