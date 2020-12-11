package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

import config.JDBCConnection;
import controller.EmployeeController;
import model.Employee;

public class ViewProfile extends JFrame{

	private JFrame frame,frame1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JTextField textField_5;
	//private JTextField textField_6;
	private EmployeeController empController;
	java.sql.Connection conn=null;
	private ViewProfile obj;
	private JComboBox comboBox;
public ViewProfile() throws SQLException,ClassNotFoundException
{	 empController=new EmployeeController();
	conn=JDBCConnection.getDBConnection();
		frame = new JFrame("PROFILE");
		frame.setSize(500, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame1 = new JFrame("PROFILE SELECTION");
		frame1.setSize(450,200);
		//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		
		JLabel lblUserId=new JLabel("USER ID");
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserId.setBounds(60, 40, 130, 30);
		frame1.getContentPane().add(lblUserId);
		
		/*textField_6 = new JTextField();
		textField_6.setBounds(200, 40, 150, 30);
		frame1.getContentPane().add(textField_6);
		textField_6.setColumns(10);*/
	
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmployeeId.setBounds(50, 35, 130, 30);
		frame.getContentPane().add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(210, 40, 205, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 85, 110, 30);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 90, 205, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("USER ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 135, 130, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 140, 205, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("GENDER");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(50, 185, 130, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(210, 190, 205, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		lblNewLabel_3 = new JLabel("ROLE");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(50, 235, 130, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(210, 240, 205, 30);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		lblNewLabel_4 = new JLabel("STATUS");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(50, 285, 130, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(210, 290, 205, 30);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		try{
			
			 Statement st = (Statement) conn.createStatement();

	         ResultSet   rs = ((java.sql.Statement) st).executeQuery("select userId from Employee");

	            Vector v = new Vector();

	            while (rs.next()) {

	               String  ids = rs.getString(1);

	                v.add(ids);
			}
	        	
	    		comboBox =new JComboBox(v);
	    		comboBox.setBounds(200, 40, 150, 30);
	    		frame1.getContentPane().add(comboBox);		
		}
		
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(150, 90, 120, 25);
		frame1.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Employee emp=new Employee();
				String userId="";
				userId=(String) comboBox.getSelectedItem();
				emp=empController.checkUser(userId);
					int s1;
					String s2,s3,s4,s5,s6,s7,s8;
							s1=emp.getEmployeeID();
							s2=emp.getFirstName();
							s3=emp.getLastName();
							s4=emp.getUserID();
							s5=emp.getGender();
							s6=emp.getRole();
							s7=emp.getActive();
							s8=String.valueOf(s1);
							System.out.println(s2);
							textField.setText(s8);
							textField_1.setText(s2);
							textField_2.setText(s4);
							textField_3.setText(s5);
							textField_4.setText(s6);
							textField_5.setText(s7);
							frame.setVisible(true);
				
			}
				
		});
	
}
		
}		