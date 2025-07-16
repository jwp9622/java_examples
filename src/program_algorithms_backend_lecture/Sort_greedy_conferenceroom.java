package program_algorithms_backend_lecture;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 회의실 배정하기
/*
입력
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14


출력
4

*/
public class Sort_greedy_conferenceroom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N][2];
		
		for(int i =0;i<N;i++) {
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}
		//정렬
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] S, int[] E) {
				if(S[1] == E[1]) {
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});
		
		
		for(int i =0;i<N;i++) {
			System.out.println( A[i][0]+"___"+ A[i][1] );
		}
		
		int count = 0;
		int end = -1;
		for(int i =0;i<N;i++) {
			if(A[i][0] >= end) {
				end = A[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
