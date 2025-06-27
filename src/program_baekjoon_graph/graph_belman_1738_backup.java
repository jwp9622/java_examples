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


//백준  1738번 골목길  / 벨만포드 알고리즘
//최단거리가 아니라 최적 경로를 찾는 거라 가장 돈을 많이 버는 경로를 찾음. 양의 사이클이 존재함
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

		//교차지점, 골목길 갯수 입력받음
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); //교차지점 갯수
		M = Integer.parseInt(st.nextToken());  //골목길 갯수
		
		// 거리 배열 초기화
		visited= new boolean[N+1]; // [노드번호][0:안먹음, 1:먹음]

		//노드정보 arrayList map 선언
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {	
			graph[i]= new ArrayList<Node>();
		}
		
		
		//초기에 가장 작은값 설정하고 경로가 바뀔때마다 가장 큰값 갱신
		// Dist[1] = 0; // 시작점이므로 2부터 세팅해준다.
		//for (int i = 2; i <= N; i++) {
		//	dist[i] = NINF;
		//}
		
		//거리 - 최소값으로 초기화
		dist = new long[N + 1];
		Arrays.fill(dist, NINF);
        dist[1] = 0; //탐색은 0부터 시작되므로 0으로 초기화
		
        
        // 교차점 기본 초기화
        trace = new int[N + 1];
		trace[0] = 1;
		
		//노드정보 입력받음
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int u = Integer.parseInt(st.nextToken());  // 출발 노드
			 int v = Integer.parseInt(st.nextToken()); // 도착 노드
			 int w = Integer.parseInt(st.nextToken()); // 도로 비용
			 
			// 단방향 그래프
			 graph[u].add(new Node(v, w));
		}
		
		//그래프 값 출력하기
		System.out.println("--------------------------");
		for(int i=1;i<graph.length;i++) {
			for(int j = 0;j<graph[i].size();j++) {
				System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
			}
		}
		System.out.println("--------------------------");
		
		//탐색 시작은 0부터한다.
		int start = 0;
		
		//벨만 탐색
		boolean positiveCycle = bellmanford();

		// 내용 출력
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
	

	// dfs로 찾아본다
	// 지금 가는 길이 최적 경로일 때만 재귀 돌림
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

	
	
	//Comparable<Node> 클래스의 기본 정렬 기준을 설정하는 인터페이스
	static class Node implements Comparable<Node>{
		int end, cost;
		// 간선 정보 생성자
		Node(int end, int cost){
			this.end=end;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) { //객체간의 순서비교
			return this.cost-o.cost;
		}
	}
	
	private static boolean bellmanford() {
		//dist = new long[N + 1];

		// Dist[1] = 0; // 시작점
		//for (int i = 2; i <= N; i++) {
		//	dist[i] = NINF;
		//}

		// 정점 개수만큼 누적이익 구한다.
		for (int round = 0; round < N; round++) {
			// 모든 간선을 다 돌면서 확인해 본다.
			for (int i = 1; i <= N; i++) {
				for (Node edge : graph[i]) {
					if (dist[edge.end] < dist[i] + edge.cost) {
						dist[edge.end] = dist[i] + edge.cost;

						if (round == N - 1) {
							//visited = new boolean[N + 1];
							visited[i] = true;
							if (cycleConnected(i)) { // 양의 서클이 존재하는데 그게 도착 노드와 연결되어있으면 안됨!
								return true;
							}
						}
					}
				}
			}
		}
		
		
		System.out.println("dist 누적이익==>");
		System.out.println( Arrays.toString(dist) );
		System.out.println("--------------------------");
		
		return false;
	}
	

	private static boolean cycleConnected(int from) {
		// 도착노드와 연결되어 있으면
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
	// 깊이 우선 탐색 메서드
    private static void bfs(int start) {
    	
    	Queue<Node> pq = new LinkedList<>();
    	pq.add(new Node(start,0));
    	visited[start] = true;

		System.out.println("start="+start);
    	while(!pq.isEmpty()) {
    		Node node = pq.poll(); //자식노드꺼냄

			System.out.println("node.end="+node.end+",node.cost="+node.cost);
			
			
			// 인접한 노드들을 탐색
			for(int i=0;i<graph[node.start].size();i++) {
				Node temp = map[node.idx].get(i); //자식노드꺼냄
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

        // V-1번 반복
        for (int i = 1; i < N; i++) {
            for (Node e : graph) {
                if (dist[e.from] != INF && dist[e.from] + e.cost < dist[e.to]) {
                	dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        // 음수 사이클 확인
        for (Node e : graph) {
            if (dist[e.from] != INF && dist[e.from] + e.cost < dist[e.to]) {
                System.out.println("음수 사이클이 존재합니다.");
                return;
            }
        }

    }
*/
	
	
	
	
	
}