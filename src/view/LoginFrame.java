package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;

public class LoginFrame extends JFrame{
	Container container;
	JLabel lUserId, lPassword, lMessage;
	JTextField tUserId;
	JPasswordField tPassword;
	JButton bLogin, bRegister;
	JCheckBox cShowPassword;
	EmployeeController empController=null;
	public LoginFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lUserId=new JLabel("USERNAME");
		lPassword=new JLabel("PASSWORD");
		lMessage=new JLabel();
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		bLogin=new JButton("LOGIN");
		empController=new EmployeeController();
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId,password;
				userId=tUserId.getText();
				password=new String(tPassword.getPassword());
				//System.out.println(userId+" "+password);
				Employee emp=new Employee();
				emp=empController.checkLogin(userId, password);
				if(emp==null) {
					lMessage.setText("You are not authorized user! Retry or Register!");
				}
				else {
					if(emp.getActive().equals("Active")) {
						if(emp.getRole().equals("HRA")) {
							new HRWindow();
						}
						else if(emp.getRole().equals("PME")) {
							new PMWindow();
						}
						else {
							new EmpWindow(emp);
						}
					}
				}
				
			}
			
		});
		bRegister=new JButton("REGISTER");
		//Event handling for Register button
		bRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RegistrationFrame();
				
			}
			
		});
		cShowPassword=new JCheckBox("Show Password");
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Login Form");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lMessage.setBounds(50, 80, 300, 30);
		lUserId.setBounds(50, 150, 100, 30);
		lPassword.setBounds(50, 250, 100, 30);
		tUserId.setBounds(250, 150, 150, 30);
		tPassword.setBounds(250, 250, 150, 30);
		cShowPassword.setBounds(250, 300, 150, 30);
		bLogin.setBounds(100, 400, 100, 30);
		bRegister.setBounds(200, 400, 100, 30);
	}
	public void addComponentsToContainer() {
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(cShowPassword);
		container.add(bLogin);
		container.add(bRegister);
		container.add(lMessage);
	}
	
}