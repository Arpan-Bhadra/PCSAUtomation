package controller;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import dao.IEmpJobDao;
import dao.IEmpSkillDao;
import daoImpl.EmpJobDaoImpl;
import daoImpl.EmpSkillDaoImpl;
import model.EmpJob;
import model.EmpSkill;
import model.Employee;

public class EmployeeController extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static IEmployeeDao empDao=null;
	public EmployeeController() throws ClassNotFoundException, SQLException{
		empDao=new EmployeeDaoImpl();
	}
	public Employee checkLogin(String userId,String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
	}
	
	public void addEmployee(String s1, String s2, String s3, String s4,String s5, String s6)  {
		Employee emp=new Employee();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter First Name:");
		emp.setFirstName(s1);
		//System.out.println("Enter Last Name:");
		emp.setLastName(s2);
		//System.out.println("Enter UserId:");
		emp.setUserID(s3);
		//System.out.println("Enter Password:");
		emp.setPassword(s4);
		//System.out.println("Enter Gender:");
		emp.setGender(s5);
		//System.out.println("Enter Role:");
		String role=s6;
		emp.setRole(s6);
		if (role.equals("HRA") || role.equals("EMP") || role.equals("PME")) {
			emp.setActive("Active");
		}
		else {
			emp.setActive("Deactive");
		}
		//Calling dao method for insert record
		empDao.addEmployee(emp);
	
}

	
	public ArrayList<Employee> getAllEmployees() {
		
		ArrayList<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
		return allEmpList;
	
	}
	
	public Employee getEmployeeById(String EmployeeId) {
		int id;
		id=Integer.parseInt(EmployeeId);
		Employee emp=empDao.getEmployeeById(id);
		System.out.println(emp);
			return emp;
		
	
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
	public void deactiveEmployee(int id) {
		
			/*BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmployeeId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());*/
			
			empDao.deactivateEmployee(id);
		
	}
	/*
public void deactivateEmployee() {
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
	}*/
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
	public void activateEmployee(int id) {
		empDao.activateEmployee(id);
		
	}
	IEmpJobDao ejb=new EmpJobDaoImpl();
	public List<EmpJob> getAllEmpJob(){
		 List<EmpJob> allEmpJoblist=ejb.getAllEmpJob();
		 for(EmpJob ejb:allEmpJoblist) {
				System.out.println(ejb);
			}
		 return  allEmpJoblist;
		
	}
	public void addEmpJob(int s1, int s2, String s3)  {
		EmpJob emp=new EmpJob();
		//emp.setEjID(s1);
		emp.setEmployeeId(s1);
		emp.setRecruited(s3);
		emp.setJobId(s2);
		ejb.addEmpJob(emp);
	
}
	public EmpJob getEmpJobById(String ejId) {
		int id;
		id=Integer.parseInt(ejId);
		EmpJob emp=ejb.getEmpJobById(id);
		System.out.println(emp);
			return emp;
		
	
	}
	public void updateEmpJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String recruited, confirm;
			System.out.println("Enter EmpJobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			EmpJob emp=ejb.getEmpJobById(id);
			System.out.println("Enter yes if recruited:");
			recruited=reader.readLine();
			System.out.println("Re-enter yes if recruited:");
			confirm=reader.readLine();
			if(recruited.equals(confirm)) {
				emp.setRecruited(recruited);
				ejb.updateEmpJob(emp);
			}
			else {
				System.out.println("Sorry! you have entered different!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*
	public void deactiveEmpJob(int id) {
		
		/*BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmployeeId whose record you want to deactivate:");
		id=Integer.parseInt(reader.readLine());
		
		ejb.deactivateEmpJob(id);
	}*/
	public void deleteEmpJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmpJobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			ejb.deleteEmpJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	IEmpSkillDao ek=new EmpSkillDaoImpl();
	public List<EmpSkill> getAllSkills(){
		 List<EmpSkill> allEmpSkilllist=ek.getAllSkills();
		 for(EmpSkill ek:allEmpSkilllist) {
				System.out.println(ek);
			}
		 return  allEmpSkilllist;
	}
	public void addEmpSkill(int s1, int s2, int s3)  {
		EmpSkill emp=new EmpSkill();
		emp.setSkillId(s1);
		emp.setEmployeeId(s2);
		emp.setExpYear(s3);
		ek.addSkills(emp);
	}
	public EmpSkill getSkillById(String ejId) {
		int id;
		id=Integer.parseInt(ejId);
		EmpSkill emp=ek.getSkillById(id);
		System.out.println(emp);
			return emp;
		}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			int expdate, confirmexpdate;
			System.out.println("Enter EmpSkillID whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			EmpSkill emp=ek.getSkillById(id);
			System.out.println("Enter Exp Year:");
			expdate=Integer.parseInt(reader.readLine());
			System.out.println("Re-enter Exp Year:");
			confirmexpdate=Integer.parseInt(reader.readLine());
			if(expdate==confirmexpdate) {
				emp.setExpYear(expdate);
				ek.updateSkill(emp);
			}
			else {
				System.out.println("Sorry! you have entered different!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteSkill() throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmpSkillId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
		ek.deleteSkill(id);
	}
}
