package program_algorithms_backend_lecture;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 회의실 배정하기
/*
입력
3 16

출력
3
5
7
11
13
*/
public class Sort_Number_sosu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] A = new int[N+1];
		
		for(int i=2;i<=N;i++) {
			A[i] = i;
		}

		for(int i=2;i<=Math.sqrt(N);i++) { //제곱근까지 시작하기
			if(A[i] ==0) {
				continue;
			}
			
			for(int j=i+i;j<=N;j=j+i) { //배수 지우기
				A[j]=0;
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(A[i] !=0) {
				System.out.println(A[i]);
			}
		}
	}
}
