package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void main(String args[]) throws NumberFormatException,IOException{
        /*
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(a+b+c);
        */
        
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
        
    }

}
