package program_algorithms_course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

/*
입력
12 3
1 5 2 3 6 2 3 7 3 5 2 6

출력
1 1 1 2 2 2 2 2 3 3 2 2 
*/

//슬라이딩 윈도우
public class Pointer_slidingWindow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node> mydeque = new LinkedList<>();

		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			
			//3개까지 넣어야되므로, 마지막 위치에서 now보다 큰 값을 데크에서 제거
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			
			//마지막 위치에 입력받은 노드 추가
			mydeque.addLast(new Node(now, i));
			
			int idx = i-L;
			
			//데크의 첫번재 위치에서부터 L의 범위를 벗어난 값을 데크에서 삭제
			System.out.print(i+"_"+ idx+"");
			if(mydeque.getFirst().index <= idx) {
				mydeque.removeFirst();

				System.out.print("__"+i+"_"+ idx+" removeFirst 삭제");
			}
			System.out.println("");
			
			bw.write(mydeque.getFirst().value +" ");
		}
		bw.flush();
		bw.close();
		
		System.out.println(mydeque);
		
	}
	static class Node{
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
