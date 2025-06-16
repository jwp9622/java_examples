package misssion_algorithms;

import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] array;
	static int equal_cnt;
	static int max_cnt;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        
        int array_cnt = st.countTokens();
	    int[] array = new int[array_cnt];
	    for(int i=0;i<array_cnt;i++) {
	    	array[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int count = compareCnt(array);
	    int sum = 0;
	    if(count == 3) {
	    	sum = 10000+equal_cnt*1000;
	    }else if(count == 2){
	    	sum = 1000+equal_cnt*100;
	    }else {
	    	sum = max_cnt *100;
	    	
	    }
	    System.out.println(sum);
	       
	}
	static int compareCnt(int array[]) {
		
		int count = 0;
		int temp_equalcnt=0;
		int temp_maxcnt = 0;
		
		//같은지 비교
		for(int i=0;i<array.length;i++) {
			
			int recnt = 0;
			for(int j = 0;j<array.length;j++) {
				// 동일한 숫자가 가장 많은수 구하기
				if(array[i]==array[j]) recnt++;
				
				//최대값구하기
				if(array[i] < array[j]) temp_maxcnt = array[j];	
			}
			//반복횟수가 가장 많은 숫자
			if(recnt>1) {
				temp_equalcnt = array[i];
				count = recnt;
			}
		}
		
		equal_cnt = temp_equalcnt;
		max_cnt = temp_maxcnt;
		return count;
	}
    
}

