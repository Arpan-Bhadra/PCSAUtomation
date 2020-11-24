package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.SkillController;

public class EntryClass1 {
	public void testConnection() throws ClassNotFoundException, SQLException{
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//EntryClass entr=new EntryClass();
		//entr.testConnection();
		SkillController empController=new SkillController();
		Scanner sc=new Scanner(System.in);
		int option;
		char ch='y';
		while(ch=='y' || ch=='Y') {
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
			switch(option) {
				case 1: 
					System.out.println("Following are all Employees Detail:");
					empController.getAllSkill();
					break;
				case 2:
					empController.getSkillById();
					break;
				case 3: 
					System.out.println("Enter Employee Detail:");
					empController.addSkill();
					break;
				case 4:
					empController.updateSkill();
					break;
				case 5:
					empController.deactiveSkill();
					break;
				case 6:
					empController.deleteSkill();
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
		System.out.println("Thank You!");
	}

}