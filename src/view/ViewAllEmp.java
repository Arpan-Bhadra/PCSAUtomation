package view;

import java.awt.Container;
import java.sql.SQLException;

import javax.swing.JFrame;
import controller.EmployeeController;

public class ViewAllEmp extends JFrame{
	private EmployeeController empController;
	Container container=null;
	public ViewAllEmp() {
		container=getContentPane();
		try {
			empController = new EmployeeController();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	
		empController.getAllEmployees();
		
		this.setTitle("Employee Details");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
