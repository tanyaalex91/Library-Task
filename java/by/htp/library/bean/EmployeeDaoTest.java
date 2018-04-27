package by.htp.library.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.EmployeeDaoImpl;
import by.htp.library.dao.util.DataBaseConnectionHelper;

public class EmployeeDaoTest {

	private Connection connection;
	private EmployeeDao dao;
	private List<Employee> expectedList;
	
	@BeforeClass
	public void m1 (){
		connection = DataBaseConnectionHelper.connect();
		System.out.println("Before class: connected to the database");
	}
	
	@BeforeMethod
	public void getExpectedList() throws SQLException{
		
	System.out.println("BeforeMethod");
	Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery("select name from employee");
	expectedList = new ArrayList<>();
	
	while(rs.next()) {
		expectedList.add(new Employee());
	}
	System.out.println("Actual list was received");
	
		
	}
	@BeforeMethod
	public void InitDao() {
		dao = new EmployeeDaoImpl();
		System.out.println("BeforeMethod: dao was initialized");
	}

	@Test
	public void testReceivedCorrectEmployeeCount() {

		List<Employee> actualList = dao.readAll();
		Assert.assertEquals(actualList.size(), expectedList.size(), "The received count is not rel count in DB");
		System.out.println("TestReceivedEmployeesCount");
	}

	@AfterMethod
	public void cleanExpectedValues() {
		expectedList = null;
		System.out.println("AfterMethod: actual list null value");
	}

	@AfterClass
	public void m5() {
		System.out.println("AfterClass");
		DataBaseConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: disconnected");
	
	
}
}