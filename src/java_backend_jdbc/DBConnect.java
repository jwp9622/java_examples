package java_backend_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/new_schemadb?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "5086";
	
	Connection conn;
	Statement stmt = null;
	
	public Connection getConnection() {
		try {
			//���� ����
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schemadb", "root","5086"); 
			
			//jdbc 8���� ����
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println("DB ���� ����");
	
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����222"); 
			System.out.println(e); 
		} catch (SQLException e) {
			System.out.println("SQL ���� ����"); 
		}
		return conn;
	}
	
	
	public void connectionClose() {
		if (conn != null) {
			try {
				System.out.println("DB ���� ����");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
