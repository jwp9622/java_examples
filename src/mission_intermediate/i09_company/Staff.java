package mission_intermediate.i09_company;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Staff {
	String id;
	String name;
	String phone;
	String division;
	
	public Staff(Map<String, String> map) {
		setId(map.get("id"));
		setName(map.get("name"));
		setPhone(map.get("phone"));
		setDivision(map.get("division"));
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	public void print() {
		System.out.println("------------------------------");
		System.out.println("            직원 정보            ");
		System.out.println("------------------------------");
		System.out.println("아이디 : "+id);
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phone);
		System.out.println("부서 : "+division);
	}


}
