package view;

import java.awt.Container;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.EmployeeController;
import model.Employee;

public class ViewAllEmp extends JFrame{
	private EmployeeController empController;
	JLabel lEmpId,lName,lUserId,lRole,lGender,lStatus;
	Container container=null;
	public ViewAllEmp(Employee userId) {
		container=getContentPane();
		lEmpId=new JLabel("Employee Id      "+userId.getEmployeeID());
		lName=new JLabel("Name              "+userId.getFirstName()+""+userId.getLastName());
		lUserId=new JLabel("User Id         "+userId.getUserID());
		lRole=new JLabel("Designation       "+userId.getRole());
		lGender=new JLabel("Gender          "+userId.getGender());
		lStatus=new JLabel("Status          "+userId.getActive());
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Profile view Of "+userId.getFirstName()+userId.getLastName());
		this.setVisible(true);
		this.setBounds(10,10,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	
	}
	private void addComponentsToContainer() {
		container.add(lEmpId);
		container.add(lName);
		container.add(lUserId);
		container.add(lRole);
		container.add(lGender);
		container.add(lStatus);
		
	}
	private void setLocationAndSize() {
		lEmpId.setBounds(30, 150, 100, 30);
		lName.setBounds(30, 200, 100, 30);
		lUserId.setBounds(30, 250, 100, 30);
		lRole.setBounds(30, 300, 100, 30);
		lGender.setBounds(30,350,100,30);
		lStatus.setBounds(30,400,100,30);
		
	}
	private void setLayoutManager() {
		container.setLayout(null);
		
	}
}
