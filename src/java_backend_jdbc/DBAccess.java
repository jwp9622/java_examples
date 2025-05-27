package java_backend_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBAccess {

	//DB ����
	DBConnect con = new DBConnect();
	Connection conn = con.getConnection();
	String sql ="";
	Statement stmt;
	Student st = new Student();
	
	DBAccess() throws SQLException{
		//Statement ����
        stmt = conn.createStatement();
		
	}
	
	public void DropTable() throws SQLException {
		
        //�׽�Ʈ�� ���ؼ� ���� ���̺� ����
		sql = "drop table if exists student ";
		stmt.executeUpdate(sql);
	}
	
	public void CreateTable() throws SQLException {
        //�׽�Ʈ�� ���ؼ� ���̺� ����
		sql = "CREATE TABLE student (";
		sql += "id CHAR(8) NOT NULL,";
		sql += "name VARCHAR(45) NULL,";
		sql += "dept VARCHAR(45) NULL,";
		sql += "date DATE NULL,";
		sql += "PRIMARY KEY (id));";
		stmt.executeUpdate(sql);
	}
	
	public void InsertData() throws SQLException {
		
   		//�ӽ÷� 5�� ���
		sql =  "insert into student(id,name,dept,date)values ('20210320','���ʼ�','�����',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);

		sql = "insert into student(id,name,dept,date)values ('20220412','������','ȸ���',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
		
		sql = "insert into student(id,name,dept,date)values ('20230506','��ö��','ȭ�а�',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
		
		sql = "insert into student(id,name,dept,date)values ('20240721','�����','������',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
		
		sql = "insert into student(id,name,dept,date)values ('20250825','û���','���а�',date_format(now(), '%Y-%m-%d'));";
		stmt.executeUpdate(sql);
	}
	
	public void ModifyNameData(String id, String name) throws SQLException{
		
		//���̵� �ֱ�
		st.setId(id);
		st.setName(name);
		
   		//����
		sql = "update student set name='"+st.getName()+"' where id='"+st.getId()+"'";
		stmt.executeUpdate(sql);
		
		
	}
	public void DeleteData(String id) throws SQLException{
		
		//���̵� �ֱ�
		st.setId(id);
		
 		//����
		sql = "delete from student where id='"+st.getId()+"'";
		stmt.executeUpdate(sql);
	}	

	
	public void DetailData(String id) throws SQLException{
		
		//���̵� �ֱ�
		st.setId(id);
		
		//�󼼳��� ���
		sql = "select * from student where id='"+st.getId()+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			st.setId(rs.getString("id"));
			st.setName(rs.getString("name"));
			st.setDept(rs.getString("dept"));
			
			System.out.println("<DB LIST>");
		    System.out.println("���̵�="+rs.getString("id"));
		    System.out.println("�̸�="+rs.getString("name"));
		    System.out.println("�μ�="+rs.getString("dept"));
		    System.out.println("");
		}
	}	


	public void ListData() throws SQLException{
			
         //��� 
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		//data.getList(rs, "id", "name", "dept", "date");
		List<Map<String, Object>> results = new ArrayList<>();
		
		System.out.println("<DB LIST>");
		System.out.println("------------------------------------------");
		System.out.println("   �̸�   |   �а�   |   �й�   |   �����   ");
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
