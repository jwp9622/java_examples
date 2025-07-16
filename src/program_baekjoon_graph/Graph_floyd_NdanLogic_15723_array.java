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


//	15723
public class Graph_floyd_NdanLogic_15723_array {

	static int N,M;
	static boolean[] visited;
	static int size = 26;
	static boolean map[][] = new boolean[size][size];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//정점, 간선
		N = Integer.parseInt(br.readLine()); // 정점
		
		//노드정보 입력받음
		int minus_ascii = 97; //아스키값 빼기
		for(int i=0;i<N;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // 출발 노드
			 int end = (int)str.charAt(5)-minus_ascii; // 도착 노드
	            
			 map[start][end] = true;
		}
		
		//그래프 값 출력하기
		//System.out.println("--------------------------");
		//for(int i=1;i<graph.length;i++) {
		//	for(int j = 0;j<graph[i].size();j++) {
		//		System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
		//	}
		//}
		//System.out.println("--------------------------");
		
		
		M = Integer.parseInt(br.readLine()); 
		
		//검색할 노드정보 입력받음
		for(int i=0;i<M;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // 출발 노드
			 int end = (int)str.charAt(5)-minus_ascii; // 도착 노드

			 
			 //값 들어올 때마다 풀로이드를 탐색
			boolean result_flag = floyd(start, end);
			char result = (result_flag == true) ?'T' :'F';
			System.out.println(result);
			
		}
		
/*

3
a is b
b is c
c is d

3
a is d
a is c
d is a
 
*/		
	}
	
	private static boolean floyd(int start, int end) {

    	Queue<Integer> pq = new LinkedList<>();
    	pq.add(start);

		visited = new boolean[size];
		visited[start] = true;
		
		//큐에서 가져오기
    	while(!pq.isEmpty()) {
    		int now = pq.poll();

			//마지막까지 탐색했으면 끝낸다.
			if(now == end) {
				return true;
			}
			
    		//노드 탐색
			for(int i=0;i<size;i++) { 
    			if(visited[i] == false && map[now][i]) {
    				visited[i]= true;
    				pq.add(i);   				
    			}
    		}
        }
    	
    	return false;
		
	}	
	
		
	
}
