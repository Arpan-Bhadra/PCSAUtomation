package view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import controller.EmployeeController;
import model.Employee;

public class ViewAllEmployees extends JFrame {
	private EmployeeController empController;
	JTextArea taEmployeeDetails;
	JFrame frame;
	public ViewAllEmployees() throws ClassNotFoundException, SQLException
	{
		empController=new EmployeeController();
		taEmployeeDetails=new JTextArea();
	    frame=new JFrame("Employee Details");
	    
	    frame.add(taEmployeeDetails);
		frame.setVisible(true);
		frame.setSize(1000,1000);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		taEmployeeDetails.setBounds(10,30,900,800);
	}
	
	public void showEmployeeData()
	{
		ArrayList<Employee> data= empController.getAllEmployees();
		String temp = "";
		int s1;
		String s2,s3,s4,s5,s6;
		temp +="Employee Id \t Name \t Gender \t Designation \t Status \t \n";
		for(Employee emp:data)
		{
			s1=emp.getEmployeeID();
			s2=emp.getFirstName();
			s3=emp.getLastName();
			s4=emp.getGender();
			s5=emp.getRole();
			s6=emp.getActive();
			temp +=s1+ " \t " +s2+" "+s3+" \t " +s4+" \t " +s5+ " \t "+s6 + "\n";	
		}
		taEmployeeDetails.setText(temp);
	}
	
}