package test;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;

public class TestClass {
	IEmployeeDao empDao=null;
	@Before
	public void setup() {
		try {
			empDao=new EmployeeDaoImpl();
		}
		catch(SQLException ex) {
		
		}
		catch(ClassNotFoundException ex) {
			
		}
	}
	@Test
	public void testGetEmployeeById() {
		Employee empActual=new Employee();
		Employee empExpected=new Employee(1,"Lopamudra","Bera","lopa123","pass@123","HRA","Female","Active");
		empActual=(Employee)empDao.getEmployeeById(2);
		//System.out.println(empActual);
		assertEquals(empExpected.getFirstName(),empActual.getFirstName());
		
	}
}
