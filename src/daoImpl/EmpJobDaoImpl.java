package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDaoImpl implements IEmpJobDao {
	Connection conn=null;
	public EmpJobDaoImpl() throws ClassNotFoundException,SQLException
	{
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<EmpJob> getAllEmpJob() {
		List<EmpJob>allEmpJobList =new ArrayList<EmpJob>();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from EmpJob");
			if(rst!=null)
			{
				EmpJob empj=null;
				while(rst.next())
				{empj=new EmpJob();
					empj.setEjID(rst.getInt(1));
					empj.setEmployeeId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
					allEmpJobList.add(empj);
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return allEmpJobList;	
		
	}

	@Override
	public void addEmpJob(EmpJob empj) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into EmpJob(EmployeeId,JobId,Recruited) values(?,?,?)");
			pst.setInt(1,empj.getEmployeeId());
			pst.setInt(2,empj.getJobId());
			pst.setString(3,empj.getRecruited());
		
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
	public EmpJob getEmpJobById(int id) {
		EmpJob empj=new EmpJob();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from EmpJob where EJId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					empj.setEjID(rst.getInt(1));
					empj.setEmployeeId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return empj;
	}

	@Override
	public void updateEmpJob(EmpJob emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EjId=?");
			pst.setString(1, emp.getRecruited());
			pst.setInt(2, emp.getEjID());
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
/*
	@Override
	public void deactivateEmpJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EjId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, id);
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
	}*/
	@Override
	public void deleteEmpJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Delete from EmpJob where EJId=?");
			pst.setInt(1,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("EmpJob Deleted");
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
