package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UpdateProfile {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfile window = new UpdateProfile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(12, 138, 543, 302);
		frame.getContentPane().add(internalFrame);
		internalFrame.setResizable(true);
		internalFrame.getContentPane().setLayout(null);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(88, 50, 89, 16);
		internalFrame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(255, 47, 156, 22);
		internalFrame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("ROLE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(88, 122, 89, 16);
		internalFrame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(255, 119, 156, 22);
		internalFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(178, 179, 124, 25);
		internalFrame.getContentPane().add(btnNewButton);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmployeeId.setBounds(108, 27, 123, 16);
		frame.getContentPane().add(lblEmployeeId);
		lblEmployeeId.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(256, 24, 151, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setLayout(null);
		
		button = new JButton("SUBMIT");
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBounds(196, 84, 124, 25);
		frame.getContentPane().add(button);
		internalFrame.setVisible(true);
	}
}