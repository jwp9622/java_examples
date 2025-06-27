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


//백준  1738번 골목길  / 벨만포드 알고리즘
//최단거리가 아니라 최적 경로를 찾는 최대이익 문제, 가장 이익이 많이 되는 경로를 찾음. 
//최대 이익문제를 찾는 문제

public class graph_belman_1738 {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Egde>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static final int NINF = Integer.MIN_VALUE;
	static long[] dist; // 거리계산
	static int[] trace; // 경로를 저장하기 위한 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//교차지점, 골목길 갯수 입력받음
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); //교차지점 갯수
		M = Integer.parseInt(st.nextToken());  //골목길 갯수
		
		// 거리 배열 초기화
		visited= new boolean[N+1]; // [노드번호][0:안먹음, 1:먹음]

		//노드정보 arrayList map 선언
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {	
			graph[i]= new ArrayList<Egde>();
		}
		
		//거리 - 최소값으로 초기화
		dist = new long[N + 1];
		
		// 최댓값을 찾기 위해 NINF 로 초기화
		//NINF를 쓰는 이유는 "이익의 누적합"이기 때문에 마이너스가 가능하고,
		//누적 이익이 더 크면 업데이트해야 하므로
		//→ 처음엔 "가장 작게" 세팅하는 것이 좋다.		
		Arrays.fill(dist, NINF); 
        dist[1] = 0; //탐색은 0부터 시작되므로, 1번노드는 0으로 초기화
        
		
		//노드정보 입력받음
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int u = Integer.parseInt(st.nextToken());  // 출발 노드
			 int v = Integer.parseInt(st.nextToken()); // 도착 노드
			 int w = Integer.parseInt(st.nextToken()); // 도로 비용
			 
			// 단방향 그래프
			 graph[u].add(new Egde(v, w));
		}
		
		//그래프 값 출력하기
		System.out.println("--------------------------");
		for(int i=1;i<graph.length;i++) {
			for(int j = 0;j<graph[i].size();j++) {
				System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
			}
		}
		System.out.println("--------------------------");
		

		//벨만 탐색
		boolean positiveCycle = bellmanford();
		
		
		// 양의 사이클이 존재하고, 도착 노드와 연결된 경우에는 -1
		// 양의 사이클이 - 다시돌아올수 있는 순환경로 사이클, 사이클돌면서 이익이 무한대로 커짐
		if (positiveCycle) {
			System.out.println(-1);
		} else {
			
			//dfs 방문여부를 사용하기 위해서 다시 초기화
			visited = new boolean[N + 1];
			visited[1] = true;
			
			//dfs 교차점 다시 사용하기 위해서 초기화
			trace = new int[N + 1];
			trace[0] = 1;
			
			//dfs 탐색해서 trace에 경로 입력받음(조건 만족하는 경로만 따라가며 DFS 수행)
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

	
	// 간선 클래스: 도착 정점과 이익(가중치)
	//Comparable<Node> 클래스의 기본 정렬 기준을 설정하는 인터페이스
	static class Egde implements Comparable<Egde>{
		int end, cost;
		// 간선 정보 생성자
		Egde(int end, int cost){
			this.end=end;
			this.cost=cost;
		}
		@Override
		public int compareTo(Egde o) { //객체간의 순서비교
			return this.cost-o.cost;
		}
	}
	

	// dfs를 이용한 경로 출력
	// 지금 가는 길이 최적 경로일 때만 재귀 돌림
	// 현재 위치가 최적 경로(dist)와 일치할 때만 재귀 탐색
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
		// 정점 개수만큼 누적이익 구한다. / 간선의 양의 사이클 여부 체크  for
		for (int round = 0; round < N; round++) {
			// 모든 간선을 다 돌면서 확인해 본다.
			for (int i = 1; i <= N; i++) {
				for (Egde edge : graph[i]) {
					if (dist[edge.end] < dist[i] + edge.cost) {
						
						// dist[i] + edge.cost > dist[edge.end] → 더 큰 이익으로 수정
						dist[edge.end] = dist[i] + edge.cost;

						// 양의 사이클 존재여부 체크
						// 만약 N번째 반복에서도 어떤 간선의 값이 갱신된다면,거리가 증가하여 양의 사이클로 체크
						if (round == N - 1 ) { //(간선은 N-1 이므로, 마지막 간선까지 갱신이되었는지 비교 )
							visited = new boolean[N + 1]; // cycleConnected에서 사용하기 위해서 초기화
							visited[i] = true;

							
							if (cycleConnected(i)) { // 양의 서클이 존재하고 도착 노드와 연결되어있는지 체크
								return true;
							}
						}
						
						
					}
				}
			}
		}
		return false;
	}
	
	
	// DFS를 이용해 from 노드에서 도착 노드 N까지 도달 가능한지 확인
	private static boolean cycleConnected(int from) {
		
		// 도착노드와 연결되어 있으면
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