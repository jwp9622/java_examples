package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_1738_back2 {
	static long[] Dist;
	static int N, M;
	static final int NINF = Integer.MIN_VALUE;
	static ArrayList<Data>[] adjList;
	static boolean[] visited;
	static int[] trace;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//������, ���� �Է�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//�׷��� �ʱ�ȭ
		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Data>();
		}

		//������, ����, ��ǰ�� �� �Է¹���
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Data(to, weight));
		}
		
		System.out.println("--------------------------");
		System.out.println(adjList.length);
		for(int i=1;i<adjList.length;i++) {
			for(int j = 0;j<adjList[i].size();j++) {
				System.out.println("__"+i+"__"+adjList[i].get(j).to+"__"+adjList[i].get(j).weight );
			}
		}
		System.out.println("--------------------------");
		
		//���� Ž��
		boolean positiveCycle = bellmanford();

		if (positiveCycle) {
			System.out.println(-1);
		} else {
			visited = new boolean[N + 1];
			visited[1] = true;
			trace = new int[N + 1];
			trace[0] = 1;
			findTrace(1, 0, 1);
		}

	}

	private static class Data {
		int to;
		int weight;

		public Data(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	
	// dfs�� ã�ƺ���
	// ���� ���� ���� ���� ����� ���� ��� ����
	private static void findTrace(int from, long dist, int order) {
		if (from == N) {
			for(int i = 0; i<order; i++) {
				System.out.print(trace[i] + " ");
			}
			System.exit(0);
		}

		for (Data edge : adjList[from]) {
			if (!visited[edge.to] && Dist[edge.to] == (Dist[from] + edge.weight)) {
				visited[edge.to] = true;
				trace[order] = edge.to;
				findTrace(edge.to, Dist[from] + edge.weight, order + 1);
			}
		}
	}

	private static boolean bellmanford() {
		Dist = new long[N + 1];

		// Dist[1] = 0; // ������
		for (int i = 2; i <= N; i++) {
			Dist[i] = NINF;
			
			System.out.println(i+"__"+NINF);
		}

		// ���� ������ŭ round
		for (int round = 0; round < N; round++) { // 0~ 4
			// ��� ������ �� ���鼭 Ȯ���� ����.
			for (int i = 1; i <= N; i++) { // 1 ~ 5
				
				for (Data edge : adjList[i]) {
					if (Dist[edge.to] < Dist[i] + edge.weight) {
						Dist[edge.to] = Dist[i] + edge.weight;

						if (round == N - 1) {
							visited = new boolean[N + 1];
							visited[i] = true;

							System.out.println("visited["+i+"]===");
							if (cycleConnected(i)) { // ���� ��Ŭ�� �����ϴµ� �װ� ���� ���� ����Ǿ������� �ȵ�!
								return true;
							}
						}
					}
				}
				
			}
		}
		return false;
	}

	private static boolean cycleConnected(int from) {
		// �������� ����Ǿ� ������
		if (from == N) {
			return true;
		}
		boolean flag = false;

		for (Data edge : adjList[from]) {
			if (!visited[edge.to]) {
				visited[edge.to] = true;
				flag |= cycleConnected(edge.to);
			}
		}
		return flag;
	}

	
	
}
