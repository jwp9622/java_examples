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
		System.out.println("           ������ ����           ");
		System.out.println("------------------------------");
		System.out.println("���̵� : "+id);
		System.out.println("�̸� : "+name);
		System.out.println("��ȭ��ȣ : "+phone);
		System.out.println("�μ� : "+division);
		System.out.println("���� : "+position);
	}

	
}
