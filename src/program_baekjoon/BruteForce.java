package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BruteForce {
	public static void main(String[] args) throws IOException {
		long first_time = System.currentTimeMillis();
		
		/* 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
 
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		int result = search(arr, N, M);
		System.out.println(result);
		*/
		
		StringBuffer bf = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		
		int[] arr = new int[N];
		 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = search(arr, N, M);
		System.out.println(result);
		
		
		long last_time = System.currentTimeMillis();
		
		System.out.println(last_time-first_time);
		
		
		
	}
	
	// Ž��
	static int search(int[] arr, int N, int M) {
		int result = 0;
 
		// 3���� ���� ������ ù��° ī��� N - 2 ������ ��ȸ
		for (int i = 0; i < N - 2; i++) {
 
			// �� ��° ī��� ù ��° ī�� �������� N - 1 ������ ��ȸ
			for (int j = i + 1; j < N - 1; j++) {
 
				// �� ��° ī��� �� ��° ī�� �������� N ���� ��ȸ
				for (int k = j + 1; k < N; k++) {
					
					// 3�� ī���� �� ���� temp
					int temp = arr[i] + arr[j] + arr[k];
					
					// M�� �� ī���� ���� ���ٸ� temp return �� ���� 
					if (M == temp) {	
						return temp;
					}
					
					// �� ī���� ���� ���� �պ��� ũ�鼭 M ���� ���� ��� result ���� 
					if(result < temp && temp < M) {
						result = temp;
					}
				}

			}
		}
		
		
		// ��� ��ȸ�� ��ġ�� result ���� 
		return result;
	}
	
}
