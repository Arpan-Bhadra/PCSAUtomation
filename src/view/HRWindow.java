package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HRWindow extends JFrame{

	Container container=null;
	JButton bSetActive,bSetDeactive,bViewAllEmp, bViewSelectiveEmp, bAddSkill, bViewSkill, bSetDeactiveSkill, bLogout;
	public HRWindow() {
		container=getContentPane();
		bSetActive=new JButton("Activate Users");
		bSetActive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetActivateFrame();
				
			}
		});
		bSetDeactive=new JButton("Deactivate Users");
		bSetDeactive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		bSetActive.setBounds(50, 150, 300, 30);
		bSetDeactive.setBounds(50, 180, 300, 30);
		bViewAllEmp.setBounds(50, 210, 300, 30);
		
	}
	public void addComponentsToContainer() {
		container.add(bSetActive);
		container.add(bSetDeactive);
		container.add(bViewAllEmp);
		
	}
}