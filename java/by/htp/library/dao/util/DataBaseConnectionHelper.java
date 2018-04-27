package by.htp.library.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.library.bean.Book;

public final class DataBaseConnectionHelper {

	private static final String DB_CONNECT_PROPERTY = "db_config";
	
	private DataBaseConnectionHelper() {
		
	}
	
	public static Connection connect() {
		
		Connection connection = null;
		
		try {
			ResourceBundle rb = ResourceBundle.getBundle(DB_CONNECT_PROPERTY);
			String url = rb.getString("db.url");
			String login = rb.getString("db.login");
			String pass = rb.getString("db.pass");
						
			try {
				Class.forName(rb.getString("db.driver"));
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
						
			connection = DriverManager.getConnection(url, login, pass);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
			
		
		return connection;
	}
	public static void disconnect (Connection connection) {
		
			if(connection != null) {
				try {
					connection.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
		
	}
}
}