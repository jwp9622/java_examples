package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class hash_set {
	public static void main(String[] args) {
		String str1 = "ABCD efghi";
		String str2 = str1.substring(1);
		System.out.println(str2);
		
        System.out.println("2�� 10�� = " + Math.pow(2, 10));
        System.out.println("16�� 1/2�� = : " + Math.pow(16, 0.5));
        System.out.println("log200 = " + Math.log10(200));
        System.out.println("--------------------------");
        
        /*
        //�Ϲ�Ÿ��
        Box box = new Box();
        box.setObj(new Object());
        Object obj = box.getObj();
        
        box.setObj("hello");
        String str = (String)box.getObj();
        System.out.println(str);
        
        box.setObj(1);
        int value = (int)box.getObj();
        */
        
        
        //������Ʈ �޾Ƶ��Ӿ������Ʈ �޾Ƶ���
        Box<Object> box = new Box<>();
        box.setObj(new Object());
        Object obj = box.getObj();
        
        Box<String> box2 = new Box<>();
        box2.setObj("hello");
        String str = box2.getObj();

        Box<Integer> box3 = new Box<>();
        box3.setObj(4);
        int v2 = box3.getObj();
        
        
        //set �ߺ��ȵ�. ���� �������� false
        Set<String> set1 = new HashSet<>();
        boolean flag1 = set1.add("kang"); //add�� ���� ���� ���� flag1 �ǵ�������
        boolean flag2 = set1.add("kim");
        boolean flag3 = set1.add("kang");

        System.out.println("flag1="+flag1);
        System.out.println("flag2="+flag2);
        System.out.println("flag3="+flag3);
        
        System.out.println(set1.size());
        
        Iterator<String> iter = set1.iterator();
        while(iter.hasNext()) {
        	String iter_str = iter.next(); //�� ����
            System.out.println(iter_str);
        }
        System.out.println("--------------------------");
        
        //list ������ �ߺ� ����.
        List<String> list = new ArrayList<>();
        list.add("kim");
        list.add("kang");
        list.add("kim");
        System.out.println(list.size());
        for(int i=0;i<list.size();i++) {
        	String str_list = list.get(i);
        	System.out.println(str_list);
        }

        System.out.println("--------------------------");
        //map �������̽� Ű�� ����, Ű �ߺ� �ȵ�.
        Map<String, String> map = new HashMap<>();
        map.put("001","kim");
        map.put("002", "lee");
        map.put("003","choi");
        map.put("001", "kang");

        System.out.println(map.size());
        System.out.println(map.get("001"));
        System.out.println(map.get("002"));
        
        Set<String> keys = map.keySet();
        Iterator<String> iter_key = keys.iterator();
        while(iter_key.hasNext()) {
        	String key = iter_key.next();
        	String value = map.get(key);
            System.out.println(key+"___"+value);
        }
        
        Map<String, Integer> products = new HashMap<>();
        //��ǰ�� �̸��� ���� products�� �߰��� ������.
        products.put("���",10000);
        products.put("��",20000);
        products.put("����",15000);
        
        
        
        
        
        
	}
}


