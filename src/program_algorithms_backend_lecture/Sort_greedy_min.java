package program_algorithms_backend_lecture;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 회의실 배정하기
/*
입력
100-40+50+74-30+29-45+43+11


출력
-222

*/
public class Sort_greedy_min {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.nextLine();
		String[] str = example.split("-");
		for(int i=0;i<str.length;i++) {
			int temp = mySum(str[i]);
			if(i==0) {
				answer = answer + temp;
			}else {
				answer = answer - temp;
			}
			System.out.println(answer);
		}
	}
	static int mySum(String a) {
		int sum =0;
		String temp[] = a.split("[+]");
		for(int i=0;i<temp.length;i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
