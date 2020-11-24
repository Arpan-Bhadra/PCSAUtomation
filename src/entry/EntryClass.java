package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import controller.EmployeeController;

public class EntryClass {
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
		EmployeeController empController=new EmployeeController();
		Scanner sc=new Scanner(System.in);
		int option;
		char ch='y';
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
		System.out.println("Thank You!");
	}

}