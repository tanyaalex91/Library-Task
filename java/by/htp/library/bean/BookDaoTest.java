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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.util.DataBaseConnectionHelper;

public class BookDaoTest {
	private Connection connection;
	private BookDao dao;
	private List<Book> expectedList;

	@BeforeClass
	public void m1() {

		connection = DataBaseConnectionHelper.connect();
		System.out.println("BeforeClass: connected to DB");

	}

	
	@BeforeMethod
	public void getExpectedList() throws SQLException {
		System.out.println("BeforeMethod");

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select *from book");
		expectedList = new ArrayList<>();
		while (rs.next()) {
			expectedList.add(new Book());
		}

		System.out.println("BeforeMethod: actualList was received");
	}

	@BeforeMethod
	public void InitDao() {
		dao = new BookDaoDBImpl();
		System.out.println("BeforeMethod: dao was inti");
	}

	@Test
	public void testReceivedCorrectBookCount() {

		List<Book> actualList = dao.readAll();
		Assert.assertEquals(actualList.size(), expectedList.size(), "The received count is not rel count in DB");
		System.out.println("TestReceivedBooksCount");
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