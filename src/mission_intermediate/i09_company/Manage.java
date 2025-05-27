package mission_intermediate.i09_company;

import java.util.Map;

public class Manage extends Staff {

	String position;

	public Manage(Map<String, String> map) {
		super(map);
		
		setId(map.get("id"));
		setName(map.get("name"));
		setPhone(map.get("phone"));
		setDivision(map.get("division"));
		setPosition(map.get("position"));
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	public void print() {
		System.out.println("------------------------------");
		System.out.println("           관리자 정보           ");
		System.out.println("------------------------------");
		System.out.println("아이디 : "+id);
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phone);
		System.out.println("부서 : "+division);
		System.out.println("직급 : "+position);
	}

	
}
