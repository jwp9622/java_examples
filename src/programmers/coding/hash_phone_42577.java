package programmers.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class hash_phone_42577 {
	public static void main(String[] args) {
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123","456","789"};
		//String[] phone_book = {"12","123","1235","567","88"};
		
        boolean answer = true;
        
        HashSet<String> hash = new HashSet<>();

        //hash에 내용 넣기
        for(String name : phone_book) {
            hash.add(name);
        }
        
        String str;
        //배열 다시 돌면서
        for(String name : phone_book) {
        	//문자 한개씩 나누어서
        	for(int j=0; j< name.length(); j++) {
        		str = name.substring(0, j);
        		
        		//System.out.println(str+"__"+hash.contains(str) +"__"+answer);
        		//존재여부 비교
        		if(hash.contains(str)) {
        			answer = false; 
        		}
        	}
        }
        
        System.out.println("answer="+answer);
        
		
	}
}
