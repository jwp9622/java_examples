package mission_intermediate.i09_company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
9. ���� Ŭ������ ������ Ŭ���� �ۼ��ϱ�
*/

//�׽�Ʈ �ڵ�
public class Main {

	 public static void main(String[] args) {
	 
		 String id = "12354";
		 String name = "ȫ�浿";
		 String phone = "010-235-1235";
		 String division = "�ѹ���";
		 String position = "����";
		 
		 //���� map
		 Map<String, String> map = new HashMap<>();
		 map.put("id",id);
		 map.put("name",name);
		 map.put("phone",phone);
		 map.put("division",division);
		 
		 Staff staff = new Staff(map); //���� Ŭ����
		 staff.print(); //���� ���� ���
		 
		 
		//���� map�� ������ ���� ���
		 map.put("position",position);
		 
		 Manage manage = new Manage(map); //������ Ŭ����
		 manage.print(); // ������ ���� ���
		 
	 
	 }
}
