package view;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;
import daoImpl.EmployeeDao;

public class RegistrationFrame extends JFrame{
	Container container;
	JLabel lFirstname,lLastname,lUserId,lPassword,lconfirmPassword,lGender,lRole;
	JTextField tFirstname,tLastname,tUserId,tPassword,tconfirmPassword,tGender,tRole;
	JButton bSubmit;
	JCheckBox cTerms;
	public RegistrationFrame() {
		container=getContentPane();
		lFirstname=new JLabel("First Name");
		lLastname=new JLabel("Last Name");
		lUserId=new JLabel("User Id");
		lPassword=new JLabel("Create Password");
		lconfirmPassword=new JLabel("Confirm Password");
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		
		
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tUserId=new JTextField();
		tPassword=new JTextField();
		tconfirmPassword=new JTextField();
		tGender=new JTextField();
		tRole=new JTextField();
		
		bSubmit=new JButton("SUBMIT");
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		cTerms=new JCheckBox("I agree to terms & conditions");
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lFirstname.setBounds(30, 150, 100, 30);
		lLastname.setBounds(30, 200, 100, 30);
		lUserId.setBounds(30, 250, 100, 30);
		lPassword.setBounds(30, 300, 100, 30);
		lconfirmPassword.setBounds(30,350,100,30);
		lGender.setBounds(30, 400, 100, 30);
		lRole.setBounds(30, 450, 150, 30);
		
		
		tFirstname.setBounds(250, 150, 150, 30);
		tLastname.setBounds(250,200,150,30);
		tUserId.setBounds(250, 250, 150, 30);
		tPassword.setBounds(250,300,150,30);
		tconfirmPassword.setBounds(250,350,150,30);
		tGender.setBounds(250, 400, 150, 30);
		tRole.setBounds(250, 450, 150, 30);
		cTerms.setBounds(150, 500, 250, 30);
		
		
		//bLogin.setBounds(100, 400, 100, 30);
		bSubmit.setBounds(100, 550, 150, 30);
	}
	public void addComponentsToContainer() {
		container.add(lFirstname);
		container.add(tFirstname);
		container.add(lLastname);
		container.add(tLastname);
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(lconfirmPassword);
		container.add(tconfirmPassword);
		container.add(lGender);
		container.add(tGender);
		container.add(lRole);
		container.add(tRole);
		container.add(cTerms);
		container.add(bSubmit);
	}
	

}