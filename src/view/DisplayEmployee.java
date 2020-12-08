package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import controller.EmployeeController;
import model.Employee;

public class DisplayEmployee extends JFrame {
	private EmployeeController empController;
	JTextArea taEmployeeDetails;
	JFrame frame;
	JLabel lID;
	JTextField tID;
	JButton bSubmit;
	 DisplayEmployee obj;
	public  DisplayEmployee () throws ClassNotFoundException, SQLException
	{  
		Container container = getContentPane();
		empController=new EmployeeController();
		taEmployeeDetails=new JTextArea();
		frame=new JFrame("Employee Details");
		lID=new JLabel("Employee Id");
		tID=new JTextField();
		bSubmit=new JButton("SUBMIT");
	    frame.add(lID);
	    frame.add(tID);
	    frame.add(taEmployeeDetails);
	    frame.add(bSubmit,BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setBounds(10,10,1000,1000);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		taEmployeeDetails.setBounds(100,100,900,800);
		lID.setBounds(50, 100, 100, 30);
		tID.setBounds(200, 100, 150, 30);
		bSubmit.setBounds(100,300,100, 30);
	
		
		bSubmit.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int id=0;
				id=Integer.parseInt(tID.getText());
				
				try {
					 obj=new  DisplayEmployee ();
					obj.showEmployeeData(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
				
		});
		
	}
	public void showEmployeeData(int id)
	{
		ArrayList<Employee> data= empController.getAllEmployees();
		String temp = "";
		int s1=0;
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
			if(id==s1)
			{
			temp +=s1+ " \t " +s2+" "+s3+" \t " +s4+" \t " +s5+ " \t "+s6 + "\n";	
		}
		
			taEmployeeDetails.setText(temp);
		}
	}	
			
	}