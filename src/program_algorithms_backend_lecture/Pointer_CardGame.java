package program_algorithms_backend_lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
�Է�
6

���
5
*/
//ī����� ť
public class Pointer_CardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) { //ī�带 ť�� ����
			myQueue.add(i);
		}
		while(myQueue.size() > 1) { //ī�尡 1�� ���� ������
			myQueue.poll();
			myQueue.add(myQueue.poll()); //�� ���� ī�带 ����
		}
		System.out.println(myQueue.poll()); //���������� ���� ī�� ���
		
	}
}
