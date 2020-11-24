package controller;

import java.io.*;
import java.sql.*;
import java.util.List;

import dao.ISkillDao;
import daoImpl.SkillDao;
import model.Skill;

public class SkillController {

	ISkillDao empDao=null;
	public SkillController() throws ClassNotFoundException, SQLException{
		empDao=new SkillDao();
	}
	
	public void addSkill() {
		Skill emp=new Skill();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Skill Name:");
			emp.setSkillName(reader.readLine());
			System.out.println("Enter Skill Description:");
			emp.setSkillDescription(reader.readLine());
			System.out.println("If the Employee Active Write Yes Otherwise no:");
			String role=reader.readLine();
		
			if(role.equals("yes")||role.equals("Yes")) {
				emp.setActive("Active");
			}
			else {
				emp.setActive("Deactive");
			}
			//Calling dao method for insert record
			empDao.AddSkill(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllSkill() {
		
		List<Skill> allEmpList=empDao.getAllSkill();
		for(Skill emp:allEmpList) {
			System.out.println(emp);
		}
	}
	
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Skill emp=empDao.getSkillById(id);
			System.out.println(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String description, newdescription ;
			System.out.println("Enter SkillId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill emp=empDao.getSkillById(id);
			System.out.println("Enter your new Description:");
			description=reader.readLine();
			System.out.println("Re-enter same Description to confirm:");
			newdescription=reader.readLine();
			if(description.equals(newdescription)) {
				emp.setSkillDescription(description);
				empDao.updateSkill(emp);
			}
			else {
				System.out.println("Sorry! you have entered different Description!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill emp=empDao.getSkillById(id);
			empDao.deactivateSkill(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}