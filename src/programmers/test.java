package programmers;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class test {
    public static void main(String[] args){
    	/*
    	String[] strArr = {"dd2","dd3","cb4","DS5","B5"};
        String[] answer = new String[strArr.length];

        for(int i=0;i<strArr.length;i++){
        	System.out.println("----"+strArr[i]);
            if(i%2==0){
                answer[i] = strArr[i].toUpperCase();
            }else{
                answer[i] = strArr[i].toLowerCase();
            }
        }
       
    	
        int[] num_list = {1,2,3,4,5,6,7,8};
        int answer = 0;
        for(int i=0;i<num_list.length;i++){
            if(num_list.length>=11){
                answer+=num_list[i];
            }else{
                answer*=num_list[i];
            }
        }
        System.out.println(answer);
        //return answer;

        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);
        int b = (a>yy)?a-543:a;
        System.out.println(b);
       
    	//int num = 12345;
    	//int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    	//System.out.print(Arrays.toString(arrNum));
    	
 
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int arrNum[] = Stream.of(String.valueOf(b).split("")).mapToInt(Integer::parseInt).toArray();
        
        String strNum = Integer.toString(b);
        int intNum[] = new int[strNum.length()];
        for(int i=0;i<strNum.length();i++) {
        	intNum[i]= strNum.charAt(i)+'0';
        }

        System.out.println(Arrays.toString(intNum));
*/        
        /*
        int mul = 0;
        int sum = 0;
        int j = 1;
        for(int i=arrNum.length-1;i>=0;i--){
            mul = a * arrNum[i];
            System.out.println(mul);
            sum += mul*j;
            j *=10;
        }
        System.out.println(sum);
        */
        
        double aa = Math.pow(3, 3);
        System.out.println(aa);
        
        System.out.println(Math.sqrt(1024));
    	
    	
        
    }
}
