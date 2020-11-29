package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PMWindow extends JFrame{

	Container container=null;
	JLabel lTitle;
	JButton bViewSkEmp,bViewAllSkill,bAddJob,bViewAllJobs,bViewSkJobs,bViewEmpApJob,bSetDeactiveJob,bLogout;
	
	public PMWindow() {
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
				
				
			}	
		});
		
		bAddJob=new JButton("Add an Job");
		bAddJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bViewAllJobs=new JButton("View All Jobs");
		bViewAllJobs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
				new SetActivateFrame();
				
			}	
		});
		
		
		
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PME Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	private void setLocationAndSize() {
		lTitle.setBounds(100, 100, 300, 30);
		bViewSkEmp.setBounds(50,150,300,30);
		bViewAllSkill.setBounds(50,200,300,30);
		bAddJob.setBounds(50,250,300,30);
		bViewAllJobs.setBounds(50,300,300,30);
		bViewSkJobs.setBounds(50,350,300,30);
		bViewEmpApJob.setBounds(50,400,300,30);
		bSetDeactiveJob.setBounds(50,450,300,30);
		bLogout.setBounds(50,500,300,30);
		
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
}