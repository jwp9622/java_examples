package program_algorithms_backend_lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
입력
6

출력
5
*/
//카드게임 큐
public class Pointer_CardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) { //카드를 큐에 저장
			myQueue.add(i);
		}
		while(myQueue.size() > 1) { //카드가 1장 남을 때까지
			myQueue.poll();
			myQueue.add(myQueue.poll()); //맨 위의 카드를 버림
		}
		System.out.println(myQueue.poll()); //마지막으로 남은 카드 출력
		
	}
}
