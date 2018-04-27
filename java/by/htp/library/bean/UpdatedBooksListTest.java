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

public class UpdatedBooksListTest {
	private Connection connection;
	private BookDao dao;
	private List<Book> oldList;
	private List<Book> newList;

	@BeforeClass
	public void method1() {

		connection = DataBaseConnectionHelper.connect();
		System.out.println("BeforeClass: connected to DB");

	}

	@BeforeMethod
	public void getExpectedList() throws SQLException {
		System.out.println("BeforeMethod");

		Statement st1 = connection.createStatement();
		ResultSet rs1 = st1.executeQuery("select *from book");
		oldList = new ArrayList<>();
		while (rs1.next()) {
			oldList.add(new Book());
			
		}
	}

	@BeforeMethod
	public void InitDao() {
		dao = new BookDaoDBImpl();
		System.out.println("BeforeMethod: dao was inti");
	}

	@BeforeMethod
	public void updateListofBooks() throws SQLException {
		java.sql.Statement st2 = connection.createStatement();
		int rs2 = st2.executeUpdate("update book SET title='Scarlet Letter' WHERE id=1");

		Statement st3 = connection.createStatement();
		ResultSet rs3 = st3.executeQuery("select *from book");
		ArrayList newList = new ArrayList<>();
		while (rs3.next()) {
			newList.add(new Book());
		}

	}
	// в тесте проверим, что наш newList не равен oldList

	@Test
	public void testUpdatedBooksListCheck() {

		Assert.assertNotEquals(oldList, newList);

	}

	@AfterMethod
	public void cleanExpectedValues() {
		oldList = null;
		System.out.println("AfterMethod: actual list null value");
	}

	@AfterClass
	public void m5() {
		System.out.println("AfterClass");
		DataBaseConnectionHelper.disconnect(connection);
		System.out.println("AfterClass: disconnected");
	}
}