package java_backend_ex1;

import java.util.HashMap;
import java.util.Scanner;

//해시맵에서 이름검색
class Student22 { // 학생을 표현하는 클래스 
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

		// 학생 이름과 Student 객체를 쌍으로 저장하는 HashMap 컬렉션 생성 
		HashMap<String, Student22> map = new HashMap<String, Student22>();
		// 3 명의 학생 저장
		map.put("황기태", new Student22(1, "010-111-1111")); 
		map.put("이재문", new Student22(2, "010-222-2222"));
		map.put("김남윤", new Student22(3, "010-333-3333"));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("검색할 이름?");
			String name = scanner.nextLine(); // 사용자로부터 이름 입력
			if(name.equals("exit"))
				break; // while 문을 벗어나 프로그램 종료
			
			Student22 student2 = map.get(name); // 이름에 해당하는 Student 객체 검색 
			
			if(student2 == null)
				System.out.println(name + "은 없는 사람입니다.");
			else
				System.out.println("id:" + student2.getId() + ", 전화:" + student2.getTel()); 
		}
		scanner.close();		
		

	}
}
