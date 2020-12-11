package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.SkillController;
import model.Skill;
import java.awt.Font;


import javax.swing.UIManager;

public class ViewAllSkills extends JFrame
{
	private SkillController skController;
	private JFrame frame;
	private JTable table;

	public ViewAllSkills()throws ClassNotFoundException, SQLException {
		String[] columnNames = {"SKILL ID","SKILL NAME","SKILL DESCRIPTION","STATUS"};
		skController=new SkillController();
		frame = new JFrame("Employee Details");
		frame.setResizable(false);
		frame.setSize(1000, 800);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		DefaultTableModel model = new DefaultTableModel();
		
        model.setColumnIdentifiers(columnNames);
        
		table = new JTable();
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setLocation(12, 13);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(model);
		table.setSize(970, 727);
		frame.getContentPane().add(table,BorderLayout.CENTER);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);
       
		List<Skill> data= skController.getAllSkills();
		int s1;
		String s2,s3,s4;
		model.addRow(new Object[] {"SKILL ID","SKILL NAME","SKILL DESCRIPTION","STATUS"});
		for(Skill sk:data)
		{
			s1=sk.getSkillId();
			s2=sk.getSkillName();
			s3=sk.getSkillDescription();
			s4=sk.getActive();
			
			model.addRow(new Object[]{s1,s2,s3,s4});
		}
	}
}