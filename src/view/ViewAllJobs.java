package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.JobController;
import model.Job;
import java.awt.Font;


import javax.swing.UIManager;

public class ViewAllJobs extends JFrame
{
	private JobController jobController;
	private JFrame frame;
	private JTable table;

	public ViewAllJobs()throws ClassNotFoundException, SQLException {
		String[] columnNames = {"JOB ID","JOB TITLE","JOB DESCRIPTION","COMPANY NAME","LOCATION","KEY SKILL","SALARY","STATUS"};
		jobController=new JobController();
		frame = new JFrame("Job Details");
		frame.setResizable(true);
		frame.setSize(1000, 800);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		DefaultTableModel model = new DefaultTableModel();
		
        model.setColumnIdentifiers(columnNames);
        
		table = new JTable();
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setLocation(15, 13);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(model);
		table.setSize(1200, 800);
		frame.getContentPane().add(table,BorderLayout.CENTER);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		List<Job> data= jobController.getAllJob();
		int s1;
		String s2,s3,s4,s5,s6,s7,s8;
		model.addRow(new Object[] {"JOB ID","JOB TITLE","JOB DESCRIPTION","COMPANY NAME","LOCATION","KEY SKILL","SALARY","STATUS"});
		for(Job job:data)
		{
			s1=job.getJobId();
			s2=job.getJobTitle();
			s3=job.getJobDescription();
			s4=job.getCompanyName();
			s5=job.getLocation();
			s6=job.getKeySkill();
			s7=job.getSalary();
			s8=job.getActive();
			model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,s8});
		}
	}
}