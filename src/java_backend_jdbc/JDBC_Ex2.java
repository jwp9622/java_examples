package java_backend_jdbc;

//import java.beans.Statement;
import java.sql.Statement;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Ex2 {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/new_schemadb?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "5086";
	
	public static void main (String[] args) {
		/*
		Connection conn;
		Statement stmt = null;
		try {
			//���� ����
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schemadb", "root","5086"); 
			
			//jdbc 8���� ����
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println("DB ���� �Ϸ�");

			stmt = conn.createStatement();
			ResultSet srs = stmt.executeQuery("select * from student");
			
			PrintData data = new PrintData();
			data.getList(srs, "name", "id", "dept");
			
			srs = stmt.executeQuery("select name, id, dept from student where name='�̱���'"); 
			data.getList(srs, "name", "id", "dept");			

			conn = null;
			stmt = null;
			srs = null;
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����"); 
			System.out.println(e); 
		} catch (SQLException e) {
			System.out.println("SQL ���� ����"); 
		}
		*/
		
	}

}
