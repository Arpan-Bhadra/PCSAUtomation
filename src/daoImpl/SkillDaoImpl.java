package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;
public class SkillDaoImpl implements ISkillDao {

	Connection conn=null;
	public SkillDaoImpl() throws ClassNotFoundException,SQLException
	{
		conn=JDBCConnection.getDBConnection();
	}
	
	@Override
	public List<Skill> getAllSkills() {
		List<Skill>allSkList =new ArrayList<Skill>();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from Skill");
			if(rst!=null)
			{
				Skill sk=null;
				while(rst.next())
				{
					sk=new Skill();
					sk.setSkillId(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
					allSkList.add(sk);
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return allSkList;	
		
	}
	@Override
	public void addSkill(Skill sk) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)");
			pst.setString(1,sk.getSkillName());
			pst.setString(2,sk.getSkillDescription());
			pst.setString(3,sk.getActive());
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
	public Skill getSkillById(int id) {
		Skill sk=new Skill();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from Skill where SkillId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					sk=new Skill();
					sk.setSkillId(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return sk;
	}
	@Override
	public void updateSkill(Skill sk) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Skill set SkillDescription=? where SkillId=?");
			pst.setString(1, sk.getSkillDescription());
			pst.setInt(2, sk.getSkillId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}
	@Override
	public void deactivateSkill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Skill set Active=? where SkillId=?");
			pst.setString(1,"Deactive");
			pst.setInt(2,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Skill Deactivated");
			}
			else
			{
				System.out.println("Updation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}
	@Override
	public void deleteSkill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Delete From Skill where SkillId=?");
			pst.setInt(1,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Skill Deleted");
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
		
	}
	
	
}