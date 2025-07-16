package program_algorithms_backend_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
�� N��(1~N)�� ������.A�� ������������ ���������� �տ������� K��°�� �ִ� ���� ���ϴ� ���α׷�

�Է�
5 2
4 1 2 3 5

5 4
4 1 2 3 5

���
2
*/

public class Sort_Quick {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] A = new int[N];
		for(int i=0;i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//������
		quickSort(A, 0, N-1, K-1);
		
		System.out.println(A[K-1]);
		
	}
	public static void quickSort(int[] A, int S, int E, int K) {
		//A:�Է¹��� �� �迭
		//S:�⺻��
		//E:N������
		//K:K��° ���Ҽ�

		System.out.println(S+"_"+E+"_"+K);
		
		if(S < E) {
			
			//�ǹ� ���ϱ�
			int pivot = partition(A, S, E);
			
			System.out.println(pivot+"___"+K+"_"+S+"_"+E);
			
			if(pivot == K) {	//�ǹ��� ���ϴ� �ڸ�������
				return;
			}else if(K < pivot) { //�ǹ��� ��ũ�� 
				quickSort(A, S, pivot -1, K);
			}else { //k>pivot, �ǹ��� ������
				quickSort(A, pivot +1, E, K);
			}
		}
	}
	
	public static int partition(int[] A, int S, int E) {
		if(S + 1 ==E) {
			if(A[S] > A[E]) swap(A, S, E);
			return E;
		}
		int M = (S+E) /2;
		swap(A, S, M);
		int pivot = A[S];
		int i = S+1, j=E;
		while(i <= j) {
			while(pivot < A[j] &&  j > 0) {
				j--;
			}
			while(pivot > A[i] && i < A.length-1) {
				i++;
			}
			if(i<=j) {
				swap(A, i++, j--);
			}
		}
		A[S] = A[j];
		A[j] = pivot;
		return j;
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
