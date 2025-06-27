package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//1389 �ɺ� �������� 6�ܰ� ��Ģ
public class graph_floyd_KebinSix_1389 {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Egde>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static int result;
	
	static int min_val = INF;
	static int result_index = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//����, ����
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); //�������� ����
		M = Integer.parseInt(st.nextToken());  //���� ����
		
		
		//������� arrayList map ����
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {	
			graph[i]= new ArrayList<Egde>();
		}
		
		
		
		//������� �Է¹���
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int u = Integer.parseInt(st.nextToken());  // ��� ���
			 int v = Integer.parseInt(st.nextToken()); // ���� ���
			 
			// ����� �׷���
			 graph[u].add(new Egde(v,0));
			 graph[v].add(new Egde(u,0));
		}
		
		//�׷��� �� ����ϱ�
		//System.out.println("--------------------------");
		//for(int i=1;i<graph.length;i++) {
		//	for(int j = 0;j<graph[i].size();j++) {
		//		System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
		//	}
		//}
		//System.out.println("--------------------------");
		
		
		//bf�� Ž��
		bfs();
		
		//��� ���
		System.out.println( result_index );
		
		
	}
	
/*

5 5
1 3
1 4
4 5
4 3
3 2

 */
	
	// ���� Ŭ����: ���� ������ ����(����ġ)
	//Comparable<Node> Ŭ������ �⺻ ���� ������ �����ϴ� �������̽�
	static class Egde implements Comparable<Egde>{
		int end, cost;
		// ���� ���� ������
		Egde(int end, int cost){
			this.end=end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Egde o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	private static void bfs() {
		
		//��� ��� �˻�
		for (int round = 1; round <= N; round++) {
			
	    	Queue<Egde> pq = new LinkedList<>();
	    	pq.add(new Egde(round, 0));

	    	//System.out.println(round+"===");
	    	
			visited = new boolean[N + 1];
			visited[round] = true;
			result = 0; 
			
			//ť���� ��������
	    	while(!pq.isEmpty()) {
	    		Egde node = pq.poll();

	    		//��� Ž��
	    		//for(Egde next : graph[node.end]) {
				for(int i=0;i<graph[node.end].size();i++) { //�ڽĳ�岨��
					Egde temp = graph[node.end].get(i); 
					
	    			if(visited[temp.end] == false) {
	    				visited[temp.end]= true;
	    				result = result+(node.cost+1);
	    				pq.add(new Egde(temp.end, node.cost+1));   				
	    			}
	    		}
	        }
	    	
	    	//�ּҰ����� ���� ��
	    	if (result < min_val) {
	    		min_val = result;
	    		result_index = round;
	    	}
	    	
		}
		
	}	
	
	
	
}
