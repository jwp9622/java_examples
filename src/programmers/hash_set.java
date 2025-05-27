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
		
        System.out.println("2의 10승 = " + Math.pow(2, 10));
        System.out.println("16의 1/2승 = : " + Math.pow(16, 0.5));
        System.out.println("log200 = " + Math.log10(200));
        System.out.println("--------------------------");
        
        /*
        //일반타입
        Box box = new Box();
        box.setObj(new Object());
        Object obj = box.getObj();
        
        box.setObj("hello");
        String str = (String)box.getObj();
        System.out.println(str);
        
        box.setObj(1);
        int value = (int)box.getObj();
        */
        
        
        //오브젝트 받아들임어떤오브젝트 받아들임
        Box<Object> box = new Box<>();
        box.setObj(new Object());
        Object obj = box.getObj();
        
        Box<String> box2 = new Box<>();
        box2.setObj("hello");
        String str = box2.getObj();

        Box<Integer> box3 = new Box<>();
        box3.setObj(4);
        int v2 = box3.getObj();
        
        
        //set 중복안됨. 같은 값있으면 false
        Set<String> set1 = new HashSet<>();
        boolean flag1 = set1.add("kang"); //add에 값을 넣은 여부 flag1 되돌려받음
        boolean flag2 = set1.add("kim");
        boolean flag3 = set1.add("kang");

        System.out.println("flag1="+flag1);
        System.out.println("flag2="+flag2);
        System.out.println("flag3="+flag3);
        
        System.out.println(set1.size());
        
        Iterator<String> iter = set1.iterator();
        while(iter.hasNext()) {
        	String iter_str = iter.next(); //값 추출
            System.out.println(iter_str);
        }
        System.out.println("--------------------------");
        
        //list 데이터 중복 가능.
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
        //map 인터페이스 키로 생성, 키 중복 안됨.
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
        //상품의 이름과 값을 products에 추가해 보세요.
        products.put("사과",10000);
        products.put("배",20000);
        products.put("포도",15000);
        
        
        
        
        
        
	}
}


