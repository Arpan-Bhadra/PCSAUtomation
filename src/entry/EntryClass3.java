package entry;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import config.JDBCConnection;
import controller.EmployeeController;
import controller.SkillController;
import controller.JobController;
import java.lang.String;

public class EntryClass3 {
	public void testConnection() throws ClassNotFoundException, SQLException{
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//EntryClass enter=new EntryClass();
		//enter.testConnection();
		String TableName;
		Scanner s=new Scanner(System.in);
		int choice = 0;
		char c='y';
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(c=='y' || c=='Y') {
			System.out.println("Enter the table name for performing CRUD operation(Employee/Skill/Job/EmpSkill/EmpJob): ");
			TableName=reader.readLine();
			if(TableName.equals("Employee")) {
				EmployeeController empController=new EmployeeController();
				Scanner sc=new Scanner(System.in);
				int option;
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Employees records");
					System.out.println("2. View single Employee record");
					System.out.println("3. Add an Employee");
					System.out.println("4. Update an Employee record");
					System.out.println("5. Deactive an Employee record");
					System.out.println("6. Active an Employee record");
					System.out.println("7. Delete an Employees record");
					System.out.println("8. View all Employee Skill records");
					System.out.println("9. View single Employee Skill record");
					System.out.println("10. Add an Employee Skill");
					System.out.println("11. Update an Employee Skill record");
					System.out.println("12. Delete an Employee Skill record");
					System.out.println("13. View all Employee Job records");
					System.out.println("14. View single Employee Job record");
					System.out.println("15. Add an Employee Job");
					System.out.println("16. Update an Employee Job record");
					System.out.println("17. Delete an Employee Job record");
					System.out.println("18. Exit");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Employees Details:");
							empController.getAllEmployees();
							break;
						case 2:
							String id;
							System.out.println("Enter the Id:");
							id=s.next();
							empController.getEmployeeById(id);
							break;
						case 3:
							String s1,s2,s3,s4,s5,s6;
							System.out.println("Enter Employee Detail:");
							System.out.println("Enter First Name:");
							s1=s.next();
							System.out.println("Enter Last Name:");
							s2=s.next();
							System.out.println("Enter UserId:");
							s3=s.next();
							System.out.println("Enter Password:");
							s4=s.next();
							System.out.println("Enter Gender:");
							s5=s.next();
							System.out.println("Enter Role:");
							s6=s.next();
							empController.addEmployee(s1, s2, s3, s4, s5, s6);
							break;
						case 4:
							empController.updateEmployee();
							break;
						case 5:
							int ID;
							System.out.println("Enter EmployeeId whose record you want to deactivate:");
							ID=s.nextInt();
							empController.deactiveEmployee (ID);
							break;
						case 6:
							System.out.println("Enter EmployeeId whose record you want to activate:");
							ID=s.nextInt();
							empController.activateEmployee(ID);
							break;
						case 7:
							empController.deleteEmployee();
							break;
						case 8:
							System.out.println("Following are all Employee Skill Details:");
							empController.getAllSkills();
							break;
						case 9:
							System.out.println("Enter the Id:");
							id=s.next();
							empController.getSkillById(id);
							break;
						case 10:
							System.out.println("Enter Employee Skill Detail:");
							int i1,i2,i3;
							System.out.println("Enter Employee ID:");
							i1=s.nextInt();
							System.out.println("Enter Skill ID:");
							i2=s.nextInt();
							System.out.println("Enter ExpYear:");
							i3=s.nextInt();
							empController.addEmpSkill(i1, i2, i3);;
							break;
						case 11:
							empController.updateSkill();
							break;
						case 12:
							empController.deleteSkill();
							break;
						case 13:
							System.out.println("Following are all EmpJob Details:");
							empController.getAllEmpJob();
							break;
						case 14:
							empController.getEmpJobById(TableName);
							break;
						case 15:
							System.out.println("Enter EmpJob Detail:");
							empController.addEmpJob(choice,choice,TableName);
							break;
						case 16:
							empController.updateEmpJob();
							break;
						case 17:
							empController.deleteEmpJob();
							break;
						case 18:
							System.exit(0);
							break;
						default:
							System.out.println("Wrong input");
					}
					System.out.println("Do you want to continue?(y/n)");
					ch=sc.next().charAt(0);
				}
			}
			else if(TableName.equals("Skill")) {
				SkillController skillController=new SkillController();
				Scanner sc=new Scanner(System.in);
				int option;
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Skill records");
					System.out.println("2. View single Skill record");
					System.out.println("3. Add a Skill");
					System.out.println("4. Update a Skill record");
					System.out.println("5. Deactive a Skill record");
					System.out.println("6. Delete a Skill record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Skill Details:");
							skillController.getAllSkills();
							break;
						case 2:
							skillController.getSkillById(TableName);
							break;
						case 3:
							System.out.println("Enter Skill Detail:");
							skillController.addSkill(TableName, TableName);
							break;
						case 4:
							skillController.updateSkill();
							break;
						/*case 5:
							skillController.deactivateSkill();
							break;*/
						case 6:
							skillController.deleteSkill();
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
			else if(TableName.equals("Job")) {
				JobController jobController=new JobController();
				int option;
				Scanner sc=new Scanner(System.in);
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Job records");
					System.out.println("2. View single Job record");
					System.out.println("3. Add a Job");
					System.out.println("4. Update a Job record");
					System.out.println("5. Deactive a Job record");
					System.out.println("6. Delete a Job record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Job Details:");
							jobController.getAllJob();
							break;
						case 2:
							jobController.getJobById();
							break;
						case 3:
							System.out.println("Enter Job Detail:");
							jobController.addJob(TableName, TableName, TableName, TableName, TableName, TableName);
							break;
						case 4:
							jobController.updateJob();
							break;
						case 5:
							jobController.deactivateJob();
							break;
						case 6:
							jobController.deleteJob();
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
			System.out.println("Do you want perfom CRUD operation on other tables?(y/n)");
			c=s.next().charAt(0);
		}
	}	
}