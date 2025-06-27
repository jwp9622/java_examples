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
�Է�
12 3
1 5 2 3 6 2 3 7 3 5 2 6

���
1 1 1 2 2 2 2 2 3 3 2 2 
*/

//�����̵� ������
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
			
			//3������ �־�ߵǹǷ�, ������ ��ġ���� now���� ū ���� ��ũ���� ����
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			
			//������ ��ġ�� �Է¹��� ��� �߰�
			mydeque.addLast(new Node(now, i));
			
			int idx = i-L;
			
			//��ũ�� ù���� ��ġ�������� L�� ������ ��� ���� ��ũ���� ����
			System.out.print(i+"_"+ idx+"");
			if(mydeque.getFirst().index <= idx) {
				mydeque.removeFirst();

				System.out.print("__"+i+"_"+ idx+" removeFirst ����");
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
