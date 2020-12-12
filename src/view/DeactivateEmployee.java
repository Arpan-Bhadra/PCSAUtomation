package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.EmployeeController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeactivateEmployee {
	private JFrame frame;
	private JTextField textField;
	private EmployeeController empController;
	
	public DeactivateEmployee()throws ClassNotFoundException, SQLException {
		empController=new EmployeeController();
		frame = new JFrame("DEACTIVATE EMPLOYEE");
		frame.setBounds(100, 100, 400, 250);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmployeeId.setBounds(64, 54, 107, 35);
		frame.getContentPane().add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(210, 60, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSubmit.setBounds(150, 150, 100, 25);
		frame.getContentPane().add(btnSubmit);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		btnSubmit.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DeactivateEmployee obj = null;
				try {
					obj = new DeactivateEmployee();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int id=0;
				id=Integer.parseInt(textField.getText());
				JOptionPane.showMessageDialog(frame,"User Deactivated");
				obj.setDeactivate(id);
			}
			});
	}
	public void setDeactivate(int id)
	{
		empController.deactiveEmployee(id);
	}
}