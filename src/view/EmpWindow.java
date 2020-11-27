package view;

import java.awt.*;

import javax.swing.*;

import model.Employee;

public class EmpWindow extends JFrame{

	Container container=null;
	JLabel lTitle;
	public EmpWindow(Employee emp) {
		container=getContentPane();
		lTitle=new JLabel(emp.getFirstName());
		
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("EMP Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lTitle.setBounds(50, 80, 300, 30);
		
	}
	public void addComponentsToContainer() {
		container.add(lTitle);
		
	}
}

