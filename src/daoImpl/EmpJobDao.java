package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDao implements IEmpJobDao{

	Connection conn=null;
	public EmpJobDao() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<EmpJob> getAllEmpJob() {
		List<EmpJob> allEmpList=new ArrayList<EmpJob>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from empJob");
			if(rst!=null) {
				EmpJob emp=null;
				while(rst.next()) {
					emp=new EmpJob();
					emp.setEjID(rst.getInt(1));
					emp.setEmployeeId(rst.getInt(2));
					emp.setJobId(rst.getInt(3));
					emp.setRecruited(rst.getString(4));
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
	public void AddEmpJob(EmpJob emp){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Employee(ejId,employeeId,jobId,recruited) values(?,?,?,?)");
			pst.setLong(1, emp.getEmployeeId());
			pst.setLong(2, emp.getJobId());
			pst.setString(3, emp.getRecruited());
		
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
	public EmpJob getEmpJobById(int id) {
		EmpJob emp=new EmpJob();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpJob where empId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEjID(rst.getInt(1));
					emp.setEmployeeId(rst.getInt(2));
					emp.setJobId(rst.getInt(3));
					emp.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
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

	@Override
	public void deactivateEmpJob(EmpJob emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EjId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getEjID());
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
	public void deleteEmpJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EjId=?");
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