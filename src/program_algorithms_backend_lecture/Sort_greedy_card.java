package program_algorithms_backend_lecture;

import java.util.PriorityQueue;
import java.util.Scanner;

//카드 정렬하기
/*
입력
3
10
20
40

출력
100

*/
public class Sort_greedy_card {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =0;i<N;i++) {
			int data = sc.nextInt();
			pq.add(data);
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while(pq.size() != 1) {
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1 + data2;
			pq.add(data1 + data2);
			
			System.out.println(data1 + "_"+data2 + "_"+sum);
		}
		System.out.println(sum);
				
	}
}
