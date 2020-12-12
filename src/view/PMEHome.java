package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class PMEHome extends JFrame{

	Container container=null;
	JLabel lTitle;
	JButton bViewSkEmp,bViewAllSkill,bAddJob,bViewAllJobs,bViewSkJobs,bViewEmpApJob,bSetDeactiveJob,bLogout;
	
	public PMEHome() {
		container=getContentPane();
		lTitle=new JLabel("Welcome to PME Portal");
		
		bViewSkEmp=new JButton("View Skill wise Employee");
		bViewSkEmp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				
			}	
		});
		
		bViewAllSkill=new JButton("View All Skills");
		bViewAllSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ViewAllSkills();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		bAddJob=new JButton("Add an Job");
		bAddJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new AddJobFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		bViewAllJobs=new JButton("View All Jobs");
		bViewAllJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewAllJobs();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}	
		});
		
		bViewSkJobs=new JButton("View Skill wise Jobs");
		bViewSkJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bViewEmpApJob=new JButton("View Employee who applied for Job");
		bViewEmpApJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bSetDeactiveJob=new JButton("Deactivate Job");
		bSetDeactiveJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					new DeactivateJob();
				} catch (ClassNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				
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
		this.setTitle("PME Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	private void setLocationAndSize() {
		lTitle.setBounds(185, 50, 300, 30);
		bViewSkEmp.setBounds(100,100,300,30);
		bViewAllSkill.setBounds(100,150,300,30);
		bAddJob.setBounds(100,200,300,30);
		bViewAllJobs.setBounds(100,250,300,30);
		bViewSkJobs.setBounds(100,300,300,30);
		bViewEmpApJob.setBounds(100,350,300,30);
		bSetDeactiveJob.setBounds(100,400,300,30);
		bLogout.setBounds(100,450,300,30);
		
	}

	private void setLayoutManager() {
		container.add(lTitle);
		container.add(bViewSkEmp);	
		container.add(bViewAllSkill);	
		container.add(bAddJob);	
		container.add(bViewAllJobs);
		container.add(bViewSkJobs);	
		container.add(bViewEmpApJob);	
		container.add(bSetDeactiveJob);	
		container.add(bLogout);
		
	}
	 private void bLogoutActionPerformed(ActionEvent evt) {
         System.exit(0);
     }
}