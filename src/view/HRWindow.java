package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HRWindow extends JFrame {
	Container container=null;
	JLabel lTitle;
	JButton bSetActive,bSetDeactive,bViewAllEmp,bViewSelectiveEmp,bAddSkill,bViewSkill,bSetDeactiveSkill,bLogout;
	
	public HRWindow() {
		container=getContentPane();
		lTitle=new JLabel("Welcome to HRA Portal");
		
		bSetActive=new JButton("Activate Users");
		bSetActive.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new SetActivateFrame();
				
			}	
		});
		
		bSetDeactive=new JButton("Deactivate Users");
		bSetDeactive.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllEmp();
				
			}	
		});
		
		bViewSelectiveEmp=new JButton("View selective Employees");
		bViewSelectiveEmp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bAddSkill=new JButton("Add Skill");
		bAddSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bViewSkill=new JButton("View all Skills");
		bViewSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bSetDeactiveSkill=new JButton("Deactivate Skill");
		bSetDeactiveSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
		this.setTitle("HRA Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	private void setLocationAndSize() {
		lTitle.setBounds(150, 100, 300, 30);
		bSetActive.setBounds(50,150,300,30);
		bSetDeactive.setBounds(50,200,300,30);
		bViewAllEmp.setBounds(50,250,300,30);
		bViewSelectiveEmp.setBounds(50,300,300,30);
		bAddSkill.setBounds(50,350,300,30);
		bViewSkill.setBounds(50,400,300,30);
		bSetDeactiveSkill.setBounds(50,450,300,30);
		bLogout.setBounds(50,500,300,30);
		
	}

	private void setLayoutManager() {
		container.add(lTitle);
		container.add(bSetActive);	
		container.add(bSetDeactive);	
		container.add(bViewAllEmp);	
		container.add(bViewSelectiveEmp);
		container.add(bAddSkill);	
		container.add(bViewSkill);	
		container.add(bSetDeactiveSkill);	
		container.add(bLogout);	
	}

}