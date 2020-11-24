package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDao implements ISkillDao{

	Connection conn=null;
	public SkillDao() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<Skill> getAllSkill() {
		List<Skill> allEmpList=new ArrayList<Skill>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from skill");
			if(rst!=null) {
				Skill emp=null;
				while(rst.next()) {
					emp=new Skill();
					emp.setSkillID(rst.getInt(1));
					emp.setSkillName(rst.getString(2));
					emp.setSkillDescription(rst.getString(3));
					emp.setActive(rst.getString(4));
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
	public void AddSkill(Skill emp){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Skill(skillName,skillDescription,active) values(?,?,?)");
			pst.setString(1, emp.getSkillName());
			pst.setString(2, emp.getSkillDescription());
			pst.setString(3, emp.getActive());
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
	public Skill getSkillById(int id) {
		Skill emp=new Skill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setSkillID(rst.getInt(1));
					emp.setSkillName(rst.getString(2));
					emp.setSkillDescription(rst.getString(3));
					emp.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

	@Override
	public void updateSkill(Skill emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set SkillDescription=? where SkillId=?");
			pst.setString(1, emp.getSkillDescription());
			pst.setInt(2, emp.getSkillID());
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
	public void deactivateSkill(Skill emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update skill set Active=? where SkillId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getSkillID());
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
	public void deleteSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from skill where SkillId=?");
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