package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;


public class EmpSkillDao implements IEmpSkillDao{

	Connection conn=null;
	public EmpSkillDao() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<EmpSkill> getAllEmpSkill() {
		List<EmpSkill> allEmpList=new ArrayList<EmpSkill>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from empSkill");
			if(rst!=null) {
				EmpSkill emp=null;
				while(rst.next()) {
					emp=new EmpSkill();
					emp.setEsID(rst.getInt(1));
					emp.setEmployeeId(rst.getInt(2));
					emp.setSkillId(rst.getInt(3));
					emp.setExpDate(rst.getString(4));
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
	public void AddEmpSkill(EmpSkill emp){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Employee(esId,employeeId,skillId,expDate) values(?,?,?,?)");
			pst.setInt(1, emp.getEmployeeId());
			pst.setInt(2, emp.getSkillId());
			pst.setString(3, emp.getExpDate());
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
	public EmpSkill getEmpSkillById(int id) {
		EmpSkill emp=new EmpSkill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpSkill where esId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEsID(rst.getInt(1));
					emp.setEmployeeId(rst.getInt(2));
					emp.setSkillId(rst.getInt(3));
					emp.setExpDate(rst.getString(4));
					
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;

	}

	@Override
	public void updateEmpSkill(EmpSkill emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set ExpDate=? where EsId=?");
			pst.setString(1, emp.getExpDate());
			pst.setInt(2, emp.getEsID());
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
	public void deactivateEmpSkill(EmpSkill emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EmpId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getEsID());
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
	public void deleteEmpSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where EmpId=?");
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