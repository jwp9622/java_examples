package program_algorithms_backend_lecture;

import java.util.Scanner;

//���� ������ �ּҰ� ���ϱ�
/*
�Է�
10 4200
1
5
10
50
100
500
1000
5000
10000
50000

���
6

*/
public class Sort_greedy_coin_min {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A= new int[N];
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		int count = 0;
		for(int i = N-1; i>=0;i--) {
			if(A[i] <= K) {
				count += (K / A[i]);
				K = K % A[i];
			}
		}
		System.out.println(count);
				
	}
}
