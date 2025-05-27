package java_backend_ex1;

import java.util.HashMap;
import java.util.Scanner;

//�ؽøʿ��� �̸��˻�
class Student22 { // �л��� ǥ���ϴ� Ŭ���� 
	int id;
	String tel;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Student22(int id, String tel) { 
		this.id = id; 
		this.tel = tel;
	} 
}

public class HashMapStudentEx {
	public static void main(String[] args) {

		// �л� �̸��� Student ��ü�� ������ �����ϴ� HashMap �÷��� ���� 
		HashMap<String, Student22> map = new HashMap<String, Student22>();
		// 3 ���� �л� ����
		map.put("Ȳ����", new Student22(1, "010-111-1111")); 
		map.put("���繮", new Student22(2, "010-222-2222"));
		map.put("�賲��", new Student22(3, "010-333-3333"));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("�˻��� �̸�?");
			String name = scanner.nextLine(); // ����ڷκ��� �̸� �Է�
			if(name.equals("exit"))
				break; // while ���� ��� ���α׷� ����
			
			Student22 student2 = map.get(name); // �̸��� �ش��ϴ� Student ��ü �˻� 
			
			if(student2 == null)
				System.out.println(name + "�� ���� ����Դϴ�.");
			else
				System.out.println("id:" + student2.getId() + ", ��ȭ:" + student2.getTel()); 
		}
		scanner.close();		
		

	}
}
