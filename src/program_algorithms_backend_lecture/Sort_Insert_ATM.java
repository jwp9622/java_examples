package program_algorithms_backend_lecture;

import java.util.Arrays;
import java.util.Scanner;

/*
�Է�
5
3 1 4 3 2

���
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
			
			//for (i-1)���� 0���� �������� ���ϸ鼭 ����, i������ �������� index�� ã�´�.
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
			// i���� insert_point���� �������� ���鼭 �ش� ���� �ٲ۴�.
			for(int j = i; j>insert_point; j--) {
				A[j] = A[j-1];
				//System.out.println("change="+ j+"__"+(j-1));
			}
			//i�� insert_value ���� A[insert_point] �迭�� �ٲ۴�.
			A[insert_point] = insert_value;
			//System.out.println("insert_point="+ insert_point+"__"+insert_value);
		}
		
		S[0] = A[0]; //�� �迭 �����
		System.out.println("N="+ Arrays.toString(A));
		System.out.println("S="+ Arrays.toString(S));
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + A[i];
		}

		System.out.println("S2="+ Arrays.toString(S));
		int sum = 0; //�� �迭 ���� �����
		for(int i=0; i<N; i++) {
			sum = sum +S[i];
		}
		System.out.println(sum);
		
	}
}
