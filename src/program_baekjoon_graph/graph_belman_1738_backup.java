package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


//����  1738�� ����  / �������� �˰���
//�ִܰŸ��� �ƴ϶� ���� ��θ� ã�� �Ŷ� ���� ���� ���� ���� ��θ� ã��. ���� ����Ŭ�� ������
public class graph_belman_1738_backup {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Node>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static final int NINF = Integer.MIN_VALUE;
	static String result;
	static long[] dist;
	static int[] trace;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//��������, ���� ���� �Է¹���
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); //�������� ����
		M = Integer.parseInt(st.nextToken());  //���� ����
		
		// �Ÿ� �迭 �ʱ�ȭ
		visited= new boolean[N+1]; // [����ȣ][0:�ȸ���, 1:����]

		//������� arrayList map ����
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {	
			graph[i]= new ArrayList<Node>();
		}
		
		
		//�ʱ⿡ ���� ������ �����ϰ� ��ΰ� �ٲ𶧸��� ���� ū�� ����
		// Dist[1] = 0; // �������̹Ƿ� 2���� �������ش�.
		//for (int i = 2; i <= N; i++) {
		//	dist[i] = NINF;
		//}
		
		//�Ÿ� - �ּҰ����� �ʱ�ȭ
		dist = new long[N + 1];
		Arrays.fill(dist, NINF);
        dist[1] = 0; //Ž���� 0���� ���۵ǹǷ� 0���� �ʱ�ȭ
		
        
        // ������ �⺻ �ʱ�ȭ
        trace = new int[N + 1];
		trace[0] = 1;
		
		//������� �Է¹���
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int u = Integer.parseInt(st.nextToken());  // ��� ���
			 int v = Integer.parseInt(st.nextToken()); // ���� ���
			 int w = Integer.parseInt(st.nextToken()); // ���� ���
			 
			// �ܹ��� �׷���
			 graph[u].add(new Node(v, w));
		}
		
		//�׷��� �� ����ϱ�
		System.out.println("--------------------------");
		for(int i=1;i<graph.length;i++) {
			for(int j = 0;j<graph[i].size();j++) {
				System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
			}
		}
		System.out.println("--------------------------");
		
		//Ž�� ������ 0�����Ѵ�.
		int start = 0;
		
		//���� Ž��
		boolean positiveCycle = bellmanford();

		// ���� ���
		if (positiveCycle) {
			System.out.println(-1);
		} else {
			//visited = new boolean[N + 1];
			//visited[1] = true;
			//trace = new int[N + 1];
			//trace[0] = 1;
			dfs(1, 0, 1);
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
*/
	

	// dfs�� ã�ƺ���
	// ���� ���� ���� ���� ����� ���� ��� ����
	private static void dfs(int from, long ds, int order) {
		if (from == N) {
			for(int i = 0; i<order; i++) {
				System.out.print(trace[i] + " _");
			}
			System.exit(0);
		}

		for (Node edge : graph[from]) {
			if (!visited[edge.end] && dist[edge.end] == (dist[from] + edge.cost)) {
				visited[edge.end] = true;
				trace[order] = edge.end;
				dfs(edge.end, dist[from] + edge.cost, order + 1);
			}
		}
	}

	
	
	//Comparable<Node> Ŭ������ �⺻ ���� ������ �����ϴ� �������̽�
	static class Node implements Comparable<Node>{
		int end, cost;
		// ���� ���� ������
		Node(int end, int cost){
			this.end=end;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) { //��ü���� ������
			return this.cost-o.cost;
		}
	}
	
	private static boolean bellmanford() {
		//dist = new long[N + 1];

		// Dist[1] = 0; // ������
		//for (int i = 2; i <= N; i++) {
		//	dist[i] = NINF;
		//}

		// ���� ������ŭ �������� ���Ѵ�.
		for (int round = 0; round < N; round++) {
			// ��� ������ �� ���鼭 Ȯ���� ����.
			for (int i = 1; i <= N; i++) {
				for (Node edge : graph[i]) {
					if (dist[edge.end] < dist[i] + edge.cost) {
						dist[edge.end] = dist[i] + edge.cost;

						if (round == N - 1) {
							//visited = new boolean[N + 1];
							visited[i] = true;
							if (cycleConnected(i)) { // ���� ��Ŭ�� �����ϴµ� �װ� ���� ���� ����Ǿ������� �ȵ�!
								return true;
							}
						}
					}
				}
			}
		}
		
		
		System.out.println("dist ��������==>");
		System.out.println( Arrays.toString(dist) );
		System.out.println("--------------------------");
		
		return false;
	}
	

	private static boolean cycleConnected(int from) {
		// �������� ����Ǿ� ������
		if (from == N) {
			return true;
		}
		boolean flag = false;

		for (Node edge : graph[from]) {
			if (!visited[edge.end]) {
				visited[edge.end] = true;
				flag |= cycleConnected(edge.end);
			}
		}
		return flag;
	}
	
	
/*	
	// ���� �켱 Ž�� �޼���
    private static void bfs(int start) {
    	
    	Queue<Node> pq = new LinkedList<>();
    	pq.add(new Node(start,0));
    	visited[start] = true;

		System.out.println("start="+start);
    	while(!pq.isEmpty()) {
    		Node node = pq.poll(); //�ڽĳ�岨��

			System.out.println("node.end="+node.end+",node.cost="+node.cost);
			
			
			// ������ ������ Ž��
			for(int i=0;i<graph[node.start].size();i++) {
				Node temp = map[node.idx].get(i); //�ڽĳ�岨��
			}
			
            for (Node neighbor : graph.get(0)) {
            	
                if (!visited[neighbor.end]) {
                    visited[neighbor.end] = true;
                    pq.add(new Node(neighbor.end, 0, 0));
        			System.out.println("       "+neighbor.end+"_"+(node.cost + 1));
                }
            }

            System.out.println("-------");
            
        }
    	//count = -1;
    }
    

    
    
	public static void bellmanFord2(int start) {
		
        dist[start] = 0;

        // V-1�� �ݺ�
        for (int i = 1; i < N; i++) {
            for (Node e : graph) {
                if (dist[e.from] != INF && dist[e.from] + e.cost < dist[e.to]) {
                	dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        // ���� ����Ŭ Ȯ��
        for (Node e : graph) {
            if (dist[e.from] != INF && dist[e.from] + e.cost < dist[e.to]) {
                System.out.println("���� ����Ŭ�� �����մϴ�.");
                return;
            }
        }

    }
*/
	
	
	
	
	
}