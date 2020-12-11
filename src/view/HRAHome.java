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
import java.awt.Dialog;
public class HRAHome extends JFrame {
	 
	Container container;
	JLabel lTitle;
	JButton bSetActive,bSetDeactive,bViewAllEmp,bViewSelectiveEmp,bAddSkill,bViewAllSkill,bSetDeactiveSkill,bLogout;
	
	JFrame f;
	
	EmployeeController empController=null;
	JobController jobController=null;
	SkillController skillController=null;
	
	public HRAHome() throws ClassNotFoundException, SQLException {
		Employee emp=new Employee();
		container=getContentPane();
		empController=new EmployeeController();
		jobController=new JobController();
		skillController=new SkillController();
		lTitle=new JLabel("Welcome to HRA Portal");
		
		
		bSetActive=new JButton("Activate Users");
		bSetActive.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ActivateEmployee();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}

		});
		
		bSetDeactive=new JButton("Deactivate Users");
		bSetDeactive.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new DeactivateEmployee();
				} catch (ClassNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}	
		});
		
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener(){

			private ViewAllEmployees x;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					//x = new ViewAllEmployees();
					//x.showEmployeeData();
					new EmployeeDetails();
				} catch (ClassNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (SQLException e1) {
					
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
		
		bViewAllSkill=new JButton("View all Skills");
		bViewAllSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ViewAllSkills();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		bSetDeactiveSkill=new JButton("Deactivate Skill");
		bSetDeactiveSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new DeactivateSkill();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}	
		});
		
		bLogout=new JButton("Logout");
		
        bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	public void setLocationAndSize() {
		lTitle.setBounds(185, 50, 300, 30);
		bSetActive.setBounds(100,100,300,30);
		bSetDeactive.setBounds(100,150,300,30);
		bViewAllEmp.setBounds(100,200,300,30);
		bViewSelectiveEmp.setBounds(100,250,300,30);
		bAddSkill.setBounds(100,300,300,30);
		bViewAllSkill.setBounds(100,350,300,30);
		bSetDeactiveSkill.setBounds(100,400,300,30);
		bLogout.setBounds(100,450,300,30);
		
	}

	public void setLayoutManager() {
		container.add(lTitle);
		container.add(bSetActive);	
		container.add(bSetDeactive);	
		container.add(bViewAllEmp);	
		container.add(bViewSelectiveEmp);
		container.add(bAddSkill);	
		container.add(bViewAllSkill);	
		container.add(bSetDeactiveSkill);	
		container.add(bLogout);
	}
	 private void bLogoutActionPerformed(ActionEvent evt) {
         System.exit(0);
     }
}