package program_algorithms_backend_lecture;

import java.util.Arrays;
import java.util.Scanner;

/*
입력
5
3 1 4 3 2

출력
32

*/
public class Sort_Insert_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] S = new int[N];
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=1;i<N;i++) {
			int insert_point = i;
			int insert_value = A[i];
			
			//for (i-1)에서 0까지 역순으로 비교하면서 돌고, i값보다 작은값의 index를 찾는다.
			for(int j=i-1;j>=0;j--) {
				if(A[j] < A[i]) {
					insert_point = j+1;
					break;
				}
				if(j == 0) {
					insert_point = 0;
				}
				//System.out.println("insert_point="+insert_point);
			}
			// i부터 insert_point까지 역순으로 돌면서 해당 값을 바꾼다.
			for(int j = i; j>insert_point; j--) {
				A[j] = A[j-1];
				//System.out.println("change="+ j+"__"+(j-1));
			}
			//i의 insert_value 값을 A[insert_point] 배열로 바꾼다.
			A[insert_point] = insert_value;
			//System.out.println("insert_point="+ insert_point+"__"+insert_value);
		}
		
		S[0] = A[0]; //합 배열 만들기
		System.out.println("N="+ Arrays.toString(A));
		System.out.println("S="+ Arrays.toString(S));
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + A[i];
		}

		System.out.println("S2="+ Arrays.toString(S));
		int sum = 0; //합 배열 총합 만들기
		for(int i=0; i<N; i++) {
			sum = sum +S[i];
		}
		System.out.println(sum);
		
	}
}
