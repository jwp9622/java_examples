package java_backend_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main (String[] args) throws SQLException {
		
		Student st = new Student();
		DBAccess dba = new DBAccess();

		//db ����
		dba.DropTable();
		
		//db ����
		dba.CreateTable();
		
		//������ ���
		dba.InsertData();
		
		//������ ����
		st.setId("20250825");
		st.setName("ȫ���");
		dba.ModifyNameData(st.getId(),st.getName());
		
		//������ ����
		st.setId("20240721");
		dba.DeleteData(st.getId());
		
		//������ ��
		st.setId("20250825");
		dba.DetailData(st.getId());
		
		//������ ���
		dba.ListData();
		
		//db ���� ����
		dba.DBClose();
		
	
	}
	
}
