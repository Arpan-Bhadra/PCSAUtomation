package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;

import model.Job;

public class JobDao implements IJobDao{

	Connection conn=null;
	public JobDao() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<Job> getAllJob() {
		List<Job> allEmpList=new ArrayList<Job>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job emp=null;
				while(rst.next()) {
					emp=new Job();
					emp.setJobID(rst.getInt(1));
					emp.setJobTitle(rst.getString(2));
					emp.setJobDescription(rst.getString(3));
					emp.setCompanyName(rst.getString(4));
					emp.setLocation(rst.getString(5));
					emp.setKeySkill(rst.getString(6));
					emp.setSalary(rst.getFloat(7));
					emp.setActive(rst.getString(8));
					allEmpList.add(emp); //2
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpList;
	}

	@Override
	public void AddJob(Job emp){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into job(jobTitle,jobDescription,companyName,location,keySkill,salary,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1, emp.getJobTitle());
			pst.setString(2, emp.getJobDescription());
			pst.setString(3, emp.getCompanyName());
			pst.setString(4, emp.getLocation());
			pst.setString(5, emp.getKeySkill());
			pst.setFloat(6, emp.getSalary());
			pst.setString(7, emp.getActive());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public Job getJobById(int id) {
		Job emp=new Job();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from job where JobId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setJobID(rst.getInt(1));
					emp.setJobTitle(rst.getString(2));
					emp.setJobDescription(rst.getString(3));
					emp.setCompanyName(rst.getString(4));
					emp.setLocation(rst.getString(5));
					emp.setKeySkill(rst.getString(6));
					emp.setSalary(rst.getFloat(7));
					emp.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

	@Override
	public void updateJob(Job emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Salary=? where JobId=?");
			pst.setFloat(1, emp.getSalary());
			pst.setInt(2, emp.getJobID());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	@Override
	public void deactivateJob(Job emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getJobID());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deactivated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	@Override
	public void deleteJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
		
	}


	
}
