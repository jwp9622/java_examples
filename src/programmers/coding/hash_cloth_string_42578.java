package programmers.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class hash_cloth_string_42578 {
	public static void main(String[] args) {
		String clothes[][] = {
				{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}};
		
		

		// 출력 내용 list		
		LinkedHashMap<Integer, String> list_last = new LinkedHashMap<>();
		
		//분류 hash 만들기
		LinkedHashMap<String, Object> hash = new LinkedHashMap<>();
		
		int count = 0;
		//분류별 해시 만들기
		for(int i=0;i<clothes.length;i++) {
			String[] cloth = clothes[i];
			hash.put(cloth[1], new ArrayList<String>());
			list_last.put(count++, cloth[0]);
		}

		//hash 분류별 아이템 정리하기
		for(String key : hash.keySet()) {
			List<String> list = new ArrayList<>();
			for(String[] cloth2 : clothes) {
				
				if(key == cloth2[1]) {
					list.add(cloth2[0]);
				}
			}
			hash.put(key, list);
		}
		
		//분류별 아이템 고른후 결과 리스트에 넣기
		for(String key : hash.keySet()) {
			List<String> list = (List<String>) hash.get(key);
			for(int i=0;i<list.size();i++) {
				String list_str = list.get(i).toString();

				for(String key2 : hash.keySet()) {
					if (key != key2) {
						List<String> list2 = (List<String>) hash.get(key2);
						for(int j=0;j<list2.size();j++) {
							String input_str = list_str+" + "+list2.get(j).toString();
							String input_str2 = list2.get(j).toString()+" + "+ list_str;
							
							if (!list_last.containsValue(input_str) && !list_last.containsValue(input_str2)) {
								list_last.put(count++,input_str);
							}
						}
					}
					
				}
				
			}
			
		}
		
		
		//내용 출력
		for(int i=0;i<list_last.size();i++) {
			System.out.println( (i+1)+"."+ list_last.get(i) );
		}

		
		
		/*
		
		//해시에 넣기
		LinkedHashMap<String, String> hash2 = new LinkedHashMap<>();
		for(int i=0;i<clothes.length;i++) {
			String[] cloth = clothes[i];
			hash2.put(cloth[0], cloth[1]);
			
			hash_last.put(i+1, cloth[0]);
		}
		
		for(Integer key : hash_last.keySet()) {
			//String[] cloth = clothes[i];
			System.out.println(key+"."+hash_last.get(key));
		}
		
		//for(String[] cloth : clothes) {
		//	//String[] cloth = clothes[i];
		//	hash2.put(cloth[0], cloth[1]);
		//	hash_last.put(cloth[0], cloth[1]);
		//}		
		

		for(String key : hash.keySet()) {
			
			String str_key = key;
			int str_val = hash.get(key);
			
			for(String key2 : hash2.keySet()) {
				
				String str_key2 = key2;
				String str_val2 = hash2.get(key2);
				
				
				if(str_key != str_val2) {
					System.out.println(str_key+"__"+str_key2);
				}
			}
			
			System.out.println(key +"__"+ hash.get(key));
		}
		
		
		
		//종류, 아이템별로 다시 만들기
		LinkedHashMap<String, List<String>> hash3 = new LinkedHashMap<>();
		for(String key : hash.keySet()) {
			
			hash.get(key);
			LinkedList<String> list = new LinkedList<>();
			for(String[] cloth : clothes) {
				if(cloth[1] == key) {
					list.add(cloth[0]);
				}
			}
			hash3.put(key, list);
			
		}
		


		*/
		
			
		
		/*
		LinkedHashMap<String, String> hash2 = new LinkedHashMap<>();

		for(String[] cloth : clothes) {
			hash.put(cloth[1], );
		}
		
		for(String[] cloth : clothes) {
			String type = cloth[1];
			hash.put(cloth[1], cloth[0]);
		}
		
		for(String key : hash.keySet()) {
			System.out.println(key+"__"+hash.get(key));
		}

		
		for(String key : hash.keySet()) {
			String str_val = hash.get(key);
			for(String key2 : hash.keySet()) {
				if(str_val != hash.get(key2)) {
					System.out.println(key+" + "+key2);
				}
			}
			
			//System.out.println(key+"__"+hash.get(key));
		}
		*/
        //System.out.println(answer - 1 );
		
				
	}
}
