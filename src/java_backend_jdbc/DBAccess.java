package java_backend_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBAccess {

	//DB 연결
	DBConnect con = new DBConnect();
	Connection conn = con.getConnection();
	String sql ="";
	Statement stmt;
	Student st = new Student();
	
	DBAccess() throws SQLException{
		//Statement 연결
        stmt = conn.createStatement();
		
	}
	
	public void DropTable() throws SQLException {
		
        //테스트를 위해서 기존 테이블 삭제
		sql = "drop table if exists student ";
		stmt.executeUpdate(sql);
	}
	
	public void CreateTable() throws SQLException {
        //테스트를 위해서 테이블 생성
		sql = "CREATE TABLE student (";
		sql += "id CHAR(8) NOT NULL,";
		sql += "name VARCHAR(45) NULL,";
		sql += "dept VARCHAR(45) NULL,";
		sql += "date DATE NULL,";
		sql += "PRIMARY KEY (id));";
		stmt.executeUpdate(sql);
	}
	
	public void InsertData() throws SQLException {
		
   		//임시로 5개 등록
		sql =  "insert into student(id,name,dept,date)values ('20210320','박필순','무용과',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);

		sql = "insert into student(id,name,dept,date)values ('20220412','오나라','회계과',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
		
		sql = "insert into student(id,name,dept,date)values ('20230506','김철수','화학과',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
		
		sql = "insert into student(id,name,dept,date)values ('20240721','이재순','물리과',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
		
		sql = "insert into student(id,name,dept,date)values ('20250825','청명수','수학과',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
	}
	
	public void ModifyNameData(String id, String name) throws SQLException{
		
		//아이디값 넣기
		st.setId(id);
		st.setName(name);
		
   		//수정
		sql = "update student set name='"+st.getName()+"' where id='"+st.getId()+"'";
		stmt.executeUpdate(sql);
		
		
	}
	public void DeleteData(String id) throws SQLException{
		
		//아이디값 넣기
		st.setId(id);
		
 		//삭제
		sql = "delete from student where id='"+st.getId()+"'";
		stmt.executeUpdate(sql);
	}	

	
	public void DetailData(String id) throws SQLException{
		
		//아이디값 넣기
		st.setId(id);
		
		//상세내용 출력
		sql = "select * from student where id='"+st.getId()+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			st.setId(rs.getString("id"));
			st.setName(rs.getString("name"));
			st.setDept(rs.getString("dept"));
			
			System.out.println("<DB LIST>");
		    System.out.println("아이디="+rs.getString("id"));
		    System.out.println("이름="+rs.getString("name"));
		    System.out.println("부서="+rs.getString("dept"));
		    System.out.println("");
		}
	}	


	public void ListData() throws SQLException{
			
         //목록 
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		//data.getList(rs, "id", "name", "dept", "date");
		List<Map<String, Object>> results = new ArrayList<>();
		
		System.out.println("<DB LIST>");
		System.out.println("------------------------------------------");
		System.out.println("   이름   |   학과   |   학번   |   등록일   ");
		System.out.println("------------------------------------------");

		while (rs.next()) {
			st.setId(rs.getString("id"));
			st.setName(rs.getString("name"));
			st.setDept(rs.getString("dept"));
			st.setDate(rs.getString("date"));
			
		    System.out.println(st.getId()+"   |   "+st.getName()+"   |   "+st.getDept()+"   |   "+st.getDate());
		}

	}
	
	public void DBClose() throws SQLException{
		con.connectionClose();
		Statement stmt = null;
	}

}
