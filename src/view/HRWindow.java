package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.EmployeeController;
import controller.JobController;
import controller.SkillController;
import model.Employee;
public class HRWindow extends JFrame {
	Container container;
	JLabel lTitle,lEmpId;
	JTextField tEmpId,tdata;
	JButton bSetActive,bSetDeactive,bViewAllEmp,bViewSelectiveEmp,bAddSkill,bViewSkill,bSetDeactiveSkill,bLogout;
	JFrame f;
	EmployeeController empController=null;
	JobController jobController=null;
	SkillController skillController=null;
	
	public HRWindow() throws ClassNotFoundException, SQLException {
		
		container=getContentPane();
		empController=new EmployeeController();
		jobController=new JobController();
		skillController=new SkillController();
		lTitle=new JLabel("Welcome to HRA Portal");
		
		
		
		
		
		Employee emp=new Employee();
		bSetActive=new JButton("Activate Users");
		bSetActive.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container=getContentPane();
				f=new JFrame();
				emp.setActive("Active");
				
				JOptionPane.showMessageDialog(f,"User Activated");
			}

		});
		
		bSetDeactive=new JButton("Deactivate Users");
		bSetDeactive.addActionListener(new ActionListener(){

			private int id;

			@Override
			public void actionPerformed(ActionEvent e) {
				container=getContentPane();
				f=new JFrame();
				lEmpId=new JLabel("Employee Id");
				tEmpId=new JTextField();
				f.add(lEmpId);
				f.add(tEmpId);
				lEmpId.setBounds(50, 80, 300, 30);
				tEmpId.setBounds(200, 150, 150, 30);
				id = 0;
				String ID;
				id=emp.getEmployeeID();
				ID=tEmpId.getText();
				
				if(ID.equals(id));
				empController.deactiveEmployee(id);
				
				JOptionPane.showMessageDialog(f,"User Deactivated");
	
				
			}	
		});
		
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener(){

			private ViewAllEmployees x;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					x = new ViewAllEmployees();
					x.showEmployeeData();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		bViewSelectiveEmp=new JButton("View selective Employees");
		bViewSelectiveEmp.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewEmployeeById();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}	
		});
		
		bAddSkill=new JButton("Add Skill");
		bAddSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					try {
						 new AddSkillFrame();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			
			
			}	
		});
		
		bViewSkill=new JButton("View all Skills");
		bViewSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bSetDeactiveSkill=new JButton("Deactivate Skill");
		bSetDeactiveSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	public void setLocationAndSize() {
		lTitle.setBounds(150, 100, 300, 30);
		bSetActive.setBounds(50,150,300,30);
		bSetDeactive.setBounds(50,200,300,30);
		bViewAllEmp.setBounds(50,250,300,30);
		bViewSelectiveEmp.setBounds(50,300,300,30);
		bAddSkill.setBounds(50,350,300,30);
		bViewSkill.setBounds(50,400,300,30);
		bSetDeactiveSkill.setBounds(50,450,300,30);
		bLogout.setBounds(50,500,300,30);
		
		//list.setBounds(10,10,400,700);
		
	}

	public void setLayoutManager() {
		container.add(lTitle);
		container.add(bSetActive);	
		container.add(bSetDeactive);	
		container.add(bViewAllEmp);	
		container.add(bViewSelectiveEmp);
		container.add(bAddSkill);	
		container.add(bViewSkill);	
		container.add(bSetDeactiveSkill);	
		container.add(bLogout);	

		//container.add(tEmpId);
		//container.add(list);
		
	}

}