package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


//����  1738�� ����  / �������� �˰���
//�ִܰŸ��� �ƴ϶� ���� ��θ� ã�� �ִ����� ����, ���� ������ ���� �Ǵ� ��θ� ã��. 
//�ִ� ���͹����� ã�� ����

public class graph_belman_1738 {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Egde>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static final int NINF = Integer.MIN_VALUE;
	static long[] dist; // �Ÿ����
	static int[] trace; // ��θ� �����ϱ� ���� �迭
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//��������, ���� ���� �Է¹���
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); //�������� ����
		M = Integer.parseInt(st.nextToken());  //���� ����
		
		// �Ÿ� �迭 �ʱ�ȭ
		visited= new boolean[N+1]; // [����ȣ][0:�ȸ���, 1:����]

		//������� arrayList map ����
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {	
			graph[i]= new ArrayList<Egde>();
		}
		
		//�Ÿ� - �ּҰ����� �ʱ�ȭ
		dist = new long[N + 1];
		
		// �ִ��� ã�� ���� NINF �� �ʱ�ȭ
		//NINF�� ���� ������ "������ ������"�̱� ������ ���̳ʽ��� �����ϰ�,
		//���� ������ �� ũ�� ������Ʈ�ؾ� �ϹǷ�
		//�� ó���� "���� �۰�" �����ϴ� ���� ����.		
		Arrays.fill(dist, NINF); 
        dist[1] = 0; //Ž���� 0���� ���۵ǹǷ�, 1������ 0���� �ʱ�ȭ
        
		
		//������� �Է¹���
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int u = Integer.parseInt(st.nextToken());  // ��� ���
			 int v = Integer.parseInt(st.nextToken()); // ���� ���
			 int w = Integer.parseInt(st.nextToken()); // ���� ���
			 
			// �ܹ��� �׷���
			 graph[u].add(new Egde(v, w));
		}
		
		//�׷��� �� ����ϱ�
		System.out.println("--------------------------");
		for(int i=1;i<graph.length;i++) {
			for(int j = 0;j<graph[i].size();j++) {
				System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
			}
		}
		System.out.println("--------------------------");
		

		//���� Ž��
		boolean positiveCycle = bellmanford();
		
		
		// ���� ����Ŭ�� �����ϰ�, ���� ���� ����� ��쿡�� -1
		// ���� ����Ŭ�� - �ٽõ��ƿü� �ִ� ��ȯ��� ����Ŭ, ����Ŭ���鼭 ������ ���Ѵ�� Ŀ��
		if (positiveCycle) {
			System.out.println(-1);
		} else {
			
			//dfs �湮���θ� ����ϱ� ���ؼ� �ٽ� �ʱ�ȭ
			visited = new boolean[N + 1];
			visited[1] = true;
			
			//dfs ������ �ٽ� ����ϱ� ���ؼ� �ʱ�ȭ
			trace = new int[N + 1];
			trace[0] = 1;
			
			//dfs Ž���ؼ� trace�� ��� �Է¹���(���� �����ϴ� ��θ� ���󰡸� DFS ����)
			dfs(1, 1);
					
			
		}

		
		
	}
	
    
/*
5 7
1 2 3
1 3 4
3 1 -7
2 3 2
3 4 1
4 2 -5
4 5 1 


5 7
1 2 3
1 3 4
3 1 -7
2 3 2
3 4 1
4 2 -7
4 5 1 

*/

	
	// ���� Ŭ����: ���� ������ ����(����ġ)
	//Comparable<Node> Ŭ������ �⺻ ���� ������ �����ϴ� �������̽�
	static class Egde implements Comparable<Egde>{
		int end, cost;
		// ���� ���� ������
		Egde(int end, int cost){
			this.end=end;
			this.cost=cost;
		}
		@Override
		public int compareTo(Egde o) { //��ü���� ������
			return this.cost-o.cost;
		}
	}
	

	// dfs�� �̿��� ��� ���
	// ���� ���� ���� ���� ����� ���� ��� ����
	// ���� ��ġ�� ���� ���(dist)�� ��ġ�� ���� ��� Ž��
	private static void dfs(int from, int order) {
		if (from == N) {
			for(int i = 0; i<order; i++) {
				System.out.print(trace[i] + " ");
			}
			System.exit(0);
		}

		for (Egde edge : graph[from]) {
			if (!visited[edge.end] && dist[edge.end] == (dist[from] + edge.cost)) {
				visited[edge.end] = true;
				trace[order] = edge.end;
				dfs(edge.end, order + 1);
			}
		}
	}


	private static boolean bellmanford() {
		// ���� ������ŭ �������� ���Ѵ�. / ������ ���� ����Ŭ ���� üũ  for
		for (int round = 0; round < N; round++) {
			// ��� ������ �� ���鼭 Ȯ���� ����.
			for (int i = 1; i <= N; i++) {
				for (Egde edge : graph[i]) {
					if (dist[edge.end] < dist[i] + edge.cost) {
						
						// dist[i] + edge.cost > dist[edge.end] �� �� ū �������� ����
						dist[edge.end] = dist[i] + edge.cost;

						// ���� ����Ŭ ���翩�� üũ
						// ���� N��° �ݺ������� � ������ ���� ���ŵȴٸ�,�Ÿ��� �����Ͽ� ���� ����Ŭ�� üũ
						if (round == N - 1 ) { //(������ N-1 �̹Ƿ�, ������ �������� �����̵Ǿ����� �� )
							visited = new boolean[N + 1]; // cycleConnected���� ����ϱ� ���ؼ� �ʱ�ȭ
							visited[i] = true;

							
							if (cycleConnected(i)) { // ���� ��Ŭ�� �����ϰ� ���� ���� ����Ǿ��ִ��� üũ
								return true;
							}
						}
						
						
					}
				}
			}
		}
		return false;
	}
	
	
	// DFS�� �̿��� from ��忡�� ���� ��� N���� ���� �������� Ȯ��
	private static boolean cycleConnected(int from) {
		
		// �������� ����Ǿ� ������
		if (from == N) {
			return true;
		}
		boolean flag = false;

		for (Egde edge : graph[from]) {
			if (!visited[edge.end]) {
				visited[edge.end] = true;
				flag = flag || cycleConnected(edge.end);
			}
		}
		return flag;
	}
	
	
	
	
	
}