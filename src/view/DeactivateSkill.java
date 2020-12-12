package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.SkillController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class DeactivateSkill {
	private JFrame frame;
	private JTextField textField;
	private SkillController skController;
	
	public DeactivateSkill()throws ClassNotFoundException, SQLException {
		skController=new SkillController();
		frame = new JFrame("DEACTIVATE SKILL");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSkillId = new JLabel("SKILL ID");
		lblSkillId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSkillId.setBounds(64, 54, 107, 35);
		frame.getContentPane().add(lblSkillId);
		
		textField = new JTextField();
		textField.setBounds(210, 60, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSubmit.setBounds(150, 120, 100, 25);
		frame.getContentPane().add(btnSubmit);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		btnSubmit.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DeactivateSkill obj = null;
				try {
					obj = new DeactivateSkill();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int id=0;
				id=Integer.parseInt(textField.getText());
				JOptionPane.showMessageDialog(frame,"Skill Deactivated");
				obj.setDeactivate(id);
			}
			});
	}
	public void setDeactivate(int id)
	{
		try {
			skController.deactivateSkill(id);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}