package programmers.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class programmers_hash_noending_person {
	public static void main(String[] args) {
		int start_num = 3;
		int end_num = 10;
		int count = (end_num-start_num)+1;
        int[] answer = new int[count];
        for(int i=start_num;i<= end_num;i++){
        	System.out.println( i-start_num );
            answer[i-start_num] = i;
        }
       System.out.println(answer);
       
	}

}
