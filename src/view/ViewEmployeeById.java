package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EmployeeController;
import model.Employee;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewEmployeeById extends JFrame {
	private EmployeeController empController;
	private JPanel contentPane;
	 ViewEmployeeById obj;
	 JLabel lblEmployeeId;
	 JTextArea textArea,textArea_1,textArea_2;
	 JButton btnSubmit;

	
	public ViewEmployeeById()throws ClassNotFoundException, SQLException {
		empController=new EmployeeController();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmployeeId.setBounds(46, 21, 134, 37);
		contentPane.add(lblEmployeeId);
		
		textArea = new JTextArea();
		textArea.setBounds(219, 28, 117, 22);
		contentPane.add(textArea);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(142, 96, 117, 25);
		contentPane.add(btnSubmit);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(12, 134, 408, 106);
		textArea_1.setEditable(false);
		contentPane.add(textArea_1);
	
		btnSubmit.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int id=0;
				id=Integer.parseInt(textArea.getText());
				try {
					obj=new ViewEmployeeById();
					obj.showEmployeeData(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				
		});
	}
	public void showEmployeeData(int id)
	{
		ArrayList<Employee> data= empController.getAllEmployees();
		String temp = "";
		int s1=0;
		String s2,s3,s4,s5,s6;
		
		temp +="Employee Id \t Name \t Gender \t Designation \t Status \t \n";
		
		for(Employee emp:data)
		{
			s1=emp.getEmployeeID();
			s2=emp.getFirstName();
			s3=emp.getLastName();
			s4=emp.getGender();
			s5=emp.getRole();
			s6=emp.getActive();
			
			if(id==s1)
			temp +=s1+ " \t " +s2+" "+s3+" \t " +s4+" \t " +s5+ " \t "+s6 + "\n";	
		}
		
			textArea_1.setText(temp);
}
}