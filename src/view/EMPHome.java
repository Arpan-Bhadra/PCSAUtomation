package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.EmployeeController;
import model.Employee;
import java.sql.*;

public class EMPHome extends JFrame {
	Container container=null;
	JLabel lTitle;
	JButton bViewprofile,bUpdateProfile,bUpdateSkill,bApplyJob,bLogout;
	private EmployeeController empController;
	
	public EMPHome(Employee emp) {
		
		container=getContentPane();
		try {
			empController = new EmployeeController();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lTitle=new JLabel("Welcome to Employee Portal");
		bViewprofile=new JButton("View Profile");
		bViewprofile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ViewProfile();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		bUpdateProfile=new JButton("Update profile");
		bUpdateProfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		bUpdateSkill=new JButton("Update Skill");
		bUpdateSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		bApplyJob=new JButton("Apply Job");
		bApplyJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("EMP Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,450);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lTitle.setBounds(180,50,300,30);
		bViewprofile.setBounds(100, 100, 300, 30);
		bUpdateProfile.setBounds(100, 150, 300, 30);
		bUpdateSkill.setBounds(100, 200, 300, 30);
		bApplyJob.setBounds(100, 250, 300, 30);
		bLogout.setBounds(100, 300, 300, 30);
		
	}
	public void addComponentsToContainer() {
		container.add(lTitle);
		container.add(bViewprofile);
		container.add(bUpdateProfile);
		container.add(bUpdateSkill);
		container.add(bApplyJob);
		container.add(bLogout);
		
		
	}
	 private void bLogoutActionPerformed(ActionEvent evt) {
         System.exit(0);
     }
}