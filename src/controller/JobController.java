package controller;

import java.io.*;
import java.sql.*;
import java.util.List;

import dao.IJobDao;
import daoImpl.JobDao;
import model.Job;

public class JobController {

	IJobDao empDao=null;
	public JobController() throws ClassNotFoundException, SQLException{
		empDao=new JobDao();
	}
	
	public void addJob() {
		Job emp=new Job();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Job Title:");
			emp.setJobTitle(reader.readLine());
			System.out.println("Enter Job Description:");
			emp.setJobDescription(reader.readLine());
			System.out.println("Enter Company Name:");
			emp.setCompanyName(reader.readLine());
			System.out.println("Enter Location:");
			emp.setLocation(reader.readLine());
			System.out.println("Enter Key Skill:");
			emp.setKeySkill(reader.readLine());
			System.out.println("Enter Salary:");
			float sal=reader.read();
			emp.setSalary(sal);
		
			if(sal!=0) {
				emp.setActive("Active");
			}
			else {
				emp.setActive("Deactive");
			}
			//Calling dao method for insert record
			empDao.AddJob(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllJob() {
		
		List<Job> allEmpList=empDao.getAllJob();
		for(Job emp:allEmpList) {
			System.out.println(emp);
		}
	}
	
	public void getJobById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Job emp=empDao.getJobById(id);
			System.out.println(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			float salary,confirmsalary;
			System.out.println("Enter JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job emp=empDao.getJobById(id);
			System.out.println("Enter your new Salary:");
			salary=reader.read();
			System.out.println("Re-enter same Salary to confirm:");
			confirmsalary=reader.read();
			if(salary==confirmsalary) {
				emp.setSalary(salary);
				empDao.updateJob(emp);
			}
			else {
				System.out.println("Sorry! you have entered different Salary!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Job emp=empDao.getJobById(id);
			empDao.deactivateJob(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empDao.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}
