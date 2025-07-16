package program_algorithms_backend_lecture;

import java.util.Scanner;
/*
입력
9 3
1 2 3 4 5 6 7 8 9 

출력
17
 
*/
public class Sort_binary_blueray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt(0);
			if(start < A[i]) start = A[i];
			end = end + A[i];
		}
		while(start <= end) {
			int middle = (start + end )/ 2;
			int sum = 0;
			int count = 0;
			
			for(int i=0;i<N;i++) {
				if(sum + A[i] > middle) {
					count++;
					sum = 0;
				}
				sum = sum + A[i];
			}
			if(sum != 0)
				count++;
			if(count > M)
				start = middle + 1;
			else
				start = middle -1;
		}
		System.out.println(start);
		
	}
}
