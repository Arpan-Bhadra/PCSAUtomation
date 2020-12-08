/*package entry;
import java.sql.*;
import java.util.Scanner;
import config.JDBCConnection;
import controller.EmployeeController;
import controller.JobController;
import controller.SkillController;
public class EntryClass1 {
	private static Scanner sc;
	public void testConnection()throws ClassNotFoundException,SQLException 
		 {
		if(JDBCConnection.getDBConnection().isClosed())
		{
			System.out.println("Connection is Closed");
		}
		else
		{
			System.out.println("Connection is Opened");
		}
		
} 
	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		sc = new Scanner(System.in);
		int option,menu;
		char ch='y';
		System.out.println("Controller Menu\n1.EmployeeController\n2.JobController\n3.SkillContoller\n4.Exit ");
		System.out.println("Choose Menu:");
		menu=sc.nextInt();
		switch(menu)
		{
		case 1:
		{
		EmployeeController empController =new EmployeeController();
		while(ch=='y' || ch=='Y') {
			System.out.println("CRUD Operation Menu:");
			System.out.println("1. View all Employees records");
			System.out.println("2. View single Employees record");
			System.out.println("3. Add an Employee");
			System.out.println("4. Update an Employee record");
			System.out.println("5. Deactive an Employee record");
			System.out.println("6. Delete an Employees record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1: 
					System.out.println("Following are all Employees Detail:");
					empController.getAllEmployees();
					break;
				case 2:
					empController.getEmployeeById();
					break;
				case 3: 
					System.out.println("Enter Employee Detail:");
					empController.addEmployee();
					break;
				case 4:
					empController.updateEmployee();
					break;
				case 5:
					empController.deactiveEmployee();
					break;
				case 6:
					empController.deleteEmployee();
					break;
				case 7:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input");
			}
			
			System.out.println("Do you want to continue?(y/n)");
			ch=sc.next().charAt(0);
		}
		}
		case 2:
		{
		JobController jController =new JobController();
		while(ch=='y' || ch=='Y') {
			System.out.println("CRUD Operation Menu:");
			System.out.println("1. View all Job records");
			System.out.println("2. View single Job record");
			System.out.println("3. Add an Job");
			System.out.println("4. Update an Job record");
			System.out.println("5. Deactive an Job record");
			System.out.println("6. Delete an Job record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1: 
					System.out.println("Following are all Job Detail:");
					jController.getAllJob();
					break;
				case 2:
					jController.getJobById();
					break;
				case 3: 
					System.out.println("Enter Job Detail:");
					jController.addJob();
					break;
				case 4:
					jController.updateJob();
					break;
				case 5:
					jController.deactiveJob();
					break;
				case 6:
					jController.deleteJob();
					break;
				case 7:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input");
			}
			
			System.out.println("Do you want to continue?(y/n)");
			ch=sc.next().charAt(0);
		}
		}
		case 3:
		{
			SkillController skController =new SkillController();
			while(ch=='y' || ch=='Y')
			{
				System.out.println("CRUD Operation Menu:");
				System.out.println("1. View all Skill records");
				System.out.println("2. View single Skill record");
				System.out.println("3. Add an Skill");
				System.out.println("4. Update an Skill record");
				System.out.println("5. Deactive an Skill record");
				System.out.println("6. Delete an Skill record");
				System.out.println("7. Exit");
				System.out.println("Enter your choice:");
				option=sc.nextInt();
				switch(option) 
				{
				case 1: 
				System.out.println("Following are all Skill Detail:");
				skController.getAllSkill();
				break;
				case 2:
				skController.getSkillById();
				break;
				case 3: 
				System.out.println("Enter Skill Detail:");
				skController.addSkill();
				break;
				case 4:
				skController.updateSkill();
				break;
				case 5:
				skController.deactiveSkill();
				break;
				case 6:
				skController.deleteSkill();
				break;
				case 7:
				System.exit(0);
				break;
				default:
				System.out.println("Wrong input");
				}
		
				System.out.println("Do you want to continue?(y/n)");
				ch=sc.next().charAt(0);
			}
			break;
		}
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong input");
		}
	
	System.out.println("Do you want to continue?(y/n)");
	ch=sc.next().charAt(0);
}
}
*/