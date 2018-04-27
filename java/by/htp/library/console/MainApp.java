package by.htp.library.console;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.EmployeeDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		BookDao dao = new BookDaoDBImpl();
		dao.update();

		EmployeeDao dao1 = new EmployeeDaoImpl();
		dao1.update();
		System.out.println(dao1);

		EmployeeDao dao2 = new EmployeeDaoImpl();
		List<Employee> employees = dao2.readAll();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		BookDao dao3 = new BookDaoDBImpl();
		List<Book> books = dao3.readAll();

		for (Book book : books) {
			System.out.println(book);

		}

		EmployeeDao dao4 = new EmployeeDaoImpl();
		dao4.delete(3);
		System.out.println(dao4);

		EmployeeDao dao21 = new EmployeeDaoImpl();
		List<Employee> employees1 = dao21.readAll();
		for (Employee employee : employees1) {
			System.out.println(employee);
		}

		
		EmployeeDao dao5 = new EmployeeDaoImpl();
		dao5.create();
		System.out.println(dao5);
		
	}
}