package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;


public class EmpSkillDaoImpl implements IEmpSkillDao {

	Connection conn=null;
	public EmpSkillDaoImpl() throws ClassNotFoundException,SQLException
	{
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<EmpSkill> getAllSkills() {
		List<EmpSkill>allEmpSkList =new ArrayList<EmpSkill>();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from EmpSkill");
			if(rst!=null)
			{
				EmpSkill emps=null;
				while(rst.next())
				{emps=new EmpSkill();
					emps.setESId(rst.getInt(1));
					emps.setEmployeeId(rst.getInt(2));
					emps.setSkillId(rst.getInt(3));
					emps.setExpYear(rst.getInt(4));
				
					allEmpSkList.add(emps);
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return allEmpSkList;	
		
	}
	@Override
	public void addSkills(EmpSkill emps) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into EmpSkill(EmployeeId,SkillId,ExpYear) values(?,?,?)");
			pst.setInt(1,emps.getEmployeeId());
			pst.setInt(2,emps.getSkillId());
			pst.setFloat(3,emps.getExpYear());
		
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("1 record inserted");
			}
			else
			{
				System.out.println("Insertion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}
	@Override
	public EmpSkill getSkillById(int id) {
		EmpSkill emps=new EmpSkill();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from EmpSkill where ESId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					emps.setESId(rst.getInt(1));
					emps.setEmployeeId(rst.getInt(2));
					emps.setSkillId(rst.getInt(3));
					emps.setExpYear(rst.getInt(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return emps;
	}
	@Override
	public void updateSkill(EmpSkill emp) {
		// TODO Auto-generated method stub
		
	}
	//public void deactivateSkill(int id) {
		// TODO Auto-generated method stub
		
	//}
	@Override
	public int deleteSkill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Delete EmpSkill where ESId=?");
			pst.setInt(1,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("EmpSkill Deleted");
			}
			else
			{
				System.out.println("Deletion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		return id;
		
	}
}
