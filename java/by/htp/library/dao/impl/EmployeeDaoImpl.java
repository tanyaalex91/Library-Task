package by.htp.library.dao.impl;

import static by.htp.library.dao.util.DataBaseConnectionHelper.connect;
import static by.htp.library.dao.util.DataBaseConnectionHelper.disconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.bean.Entity;
import by.htp.library.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String SQL_SELECT_EMPLOYEES = "select * from employee";
	private static final String SQL_UPDATE_EMPLOYEES = "UPDATE employee SET Name='Anna Kozlova' WHERE id =1";
	private static final String SQL_DELETE_EMPLOYEES = "DELETE FROM employee WHERE id=2";
	private static final String SQL_CREATE_SUPER_EMPLOYEES_TABLE = "CREATE TABLE SuperEmployees (PersonID int, LastName varchar(255))";

	public void create() {

		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = connect();

		try {
			java.sql.Statement st = connection.createStatement();
			int rs = st.executeUpdate(SQL_CREATE_SUPER_EMPLOYEES_TABLE);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

	}

	public Employee read(int id) {

		return null;
	}

	public List<Employee> readAll() {
		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = connect();

		try {

			java.sql.Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEES);

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("e-mail"));
				employee.setDate_of_birth(rs.getDate("date_of_birth"));

				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		disconnect(connection);

		return employees;
	}

	public void update() {

		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = connect();

		try {
			java.sql.Statement st = connection.createStatement();
			int rs = st.executeUpdate(SQL_UPDATE_EMPLOYEES);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

	}

	public void delete(int id) {

		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = connect();

		try {
			java.sql.Statement st = connection.createStatement();
			int rs = st.executeUpdate(SQL_DELETE_EMPLOYEES);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

	}

//	@Override
//	public void create(Entity entity) {
//		// TODO Auto-generated method stub
//
//	}

	public void delete() {

	}

}
