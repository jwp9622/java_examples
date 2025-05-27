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

		//db 삭제
		dba.DropTable();
		
		//db 생성
		dba.CreateTable();
		
		//데이터 등록
		dba.InsertData();
		
		//데이터 수정
		st.setId("20250825");
		st.setName("홍기수");
		dba.ModifyNameData(st.getId(),st.getName());
		
		//데이터 삭제
		st.setId("20240721");
		dba.DeleteData(st.getId());
		
		//데이터 상세
		st.setId("20250825");
		dba.DetailData(st.getId());
		
		//데이터 목록
		dba.ListData();
		
		//db 연결 해제
		dba.DBClose();
		
	
	}
	
}
