package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import program_baekjoon_graph.graph_floyd_KebinSix_1389.Egde;

public class Graph_NetworkConnect_1922 {

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
		
		//정점, 간선
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); //교차지점 갯수
		M = Integer.parseInt(st.nextToken());  //골목길 갯수
		
		
		//노드정보 arrayList map 선언
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {	
			graph[i]= new ArrayList<Egde>();
		}
		
		
		
		//노드정보 입력받음
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int a = Integer.parseInt(st.nextToken());  // 출발 노드
			 int b = Integer.parseInt(st.nextToken()); // 도착 노드
			 int c = Integer.parseInt(st.nextToken()); // 가중치
			 
			// 양방향 그래프
			 graph[a].add(new Egde(b,c));
			 //graph[v].add(new Egde(u,0));
		}
		
		//그래프 값 출력하기
		//System.out.println("--------------------------");
		//for(int i=1;i<graph.length;i++) {
		//	for(int j = 0;j<graph[i].size();j++) {
		//		System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
		//	}
		//}
		//System.out.println("--------------------------");
		
		
		//bf로 탐색
		search();
		
		//결과 출력
		System.out.println( result_index );
		
		
	}
	
	// 간선 클래스: 도착 정점과 이익(가중치)
	//Comparable<Node> 클래스의 기본 정렬 기준을 설정하는 인터페이스
	static class Egde implements Comparable<Egde>{
		int end, cost;
		// 간선 정보 생성자
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
	
	
	private static void search() {
		
		//모든 노드 검색
		for (int round = 1; round <= N; round++) {
			
	    	Queue<Egde> pq = new LinkedList<>();
	    	pq.add(new Egde(round, 0));

	    	//System.out.println(round+"===");
	    	
			visited = new boolean[N + 1];
			visited[round] = true;
			result = 0; 
			
			//큐에서 가져오기
	    	while(!pq.isEmpty()) {
	    		Egde node = pq.poll();

	    		//노드 탐색
	    		//for(Egde next : graph[node.end]) {
				for(int i=0;i<graph[node.end].size();i++) { //자식노드꺼냄
					Egde temp = graph[node.end].get(i); 
					
	    			if(visited[temp.end] == false) {
	    				visited[temp.end]= true;
	    				result = result+(node.cost+1);
	    				pq.add(new Egde(temp.end, node.cost+1));   				
	    			}
	    		}
	        }
	    	
	    	//최소값인지 여부 비교
	    	if (result < min_val) {
	    		min_val = result;
	    		result_index = round;
	    	}
	    	
		}
		
	}	
	
		
	
}
