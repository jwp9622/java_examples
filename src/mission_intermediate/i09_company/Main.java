package mission_intermediate.i09_company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
9. 직원 클래스와 관리자 클래스 작성하기
*/

//테스트 코드
public class Main {

	 public static void main(String[] args) {
	 
		 String id = "12354";
		 String name = "홍길동";
		 String phone = "010-235-1235";
		 String division = "총무부";
		 String position = "부장";
		 
		 //직원 map
		 Map<String, String> map = new HashMap<>();
		 map.put("id",id);
		 map.put("name",name);
		 map.put("phone",phone);
		 map.put("division",division);
		 
		 Staff staff = new Staff(map); //직원 클래스
		 staff.print(); //직원 정보 출력
		 
		 
		//직원 map에 관리자 정보 등록
		 map.put("position",position);
		 
		 Manage manage = new Manage(map); //관리자 클래스
		 manage.print(); // 관리자 정보 출력
		 
	 
	 }
}
