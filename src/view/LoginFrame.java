package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame extends JFrame{
	Container container;
	JLabel lUserId, lPassword;
	JTextField tUserId,tPassword;
	JButton bLogin, bRegister;
	JCheckBox cShowPassword;
	public LoginFrame() {
		container=getContentPane();
		lUserId=new JLabel("USERNAME");
		lPassword=new JLabel("PASSWORD");
		tUserId=new JTextField();
		tPassword=new JTextField();
		bLogin=new JButton("LOGIN");
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
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
	}
	
}
