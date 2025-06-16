package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class MyMember implements Comparable<MyMember>{
    String name;
    int age;

    public MyMember(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(MyMember o) {
        return this.age-o.age;
    }
}

public class test {
	
	static int[] array;
	static int[] array_cnt;
	static int equal_cnt;
	static int max_cnt;
    

    public static void main(String args[]) throws NumberFormatException,IOException{
        /*
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(a+b+c);
       
        
        PriorityQueue<MyMember> memberQueue = new PriorityQueue<>();
        memberQueue.offer(new MyMember("memA",20));
        memberQueue.offer(new MyMember("memB",10));
        memberQueue.offer(new MyMember("memC",30)); 
        
        while(!memberQueue.isEmpty()) {
        	MyMember member = memberQueue.poll();
        	System.out.println("name="+member.name+"_age="+member.age);
        }
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        

        LocalDateTime ori = LocalDateTime.now();
        System.out.println("ori date="+ori);
        
        LocalDateTime plus_time = LocalDateTime.now().withHour(a).withMinute(b).minusMinutes(45);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("YYYY-MM-dd  H m");
        
        String format = plus_time.format(dt);
        System.out.println(format);        
        
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(bf.readLine());
         
        LocalDateTime time = LocalDateTime.now().withHour(a).withMinute(b).plusMinutes(c);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("H m");
        System.out.println(time.format(dt));
        */
    	

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        
        //int a = Integer.parseInt(st.nextToken());
        //int b = Integer.parseInt(st.nextToken());
        //int c = Integer.parseInt(st.nextToken());
        
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
        	sum = 10000+equal_cnt*1000;
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

