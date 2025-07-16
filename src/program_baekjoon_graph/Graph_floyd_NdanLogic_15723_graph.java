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

public class Graph_floyd_NdanLogic_15723_graph {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Egde>[] graph;
	static int size = 26;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//정점, 간선
		N = Integer.parseInt(br.readLine()); // 정점
		
		//노드정보 arrayList map 선언
		graph = new ArrayList[size];
		for(int i=0;i<size;i++) {	
			graph[i]= new ArrayList<Egde>();
		}

		//노드정보 입력받음
		int minus_ascii = 97; //아스키값 빼기
		for(int i=0;i<N;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // 출발 노드
			 int end = (int)str.charAt(5)-minus_ascii; // 도착 노드
	            
			 // 단방향 그래프
			 graph[start].add(new Egde(end));
		}
		
		
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
	
	}
	
	// 간선 클래스: 도착 정점과 이익(가중치)
	//Comparable<Node> 클래스의 기본 정렬 기준을 설정하는 인터페이스
	static class Egde implements Comparable<Egde>{
		int end;
		// 간선 정보 생성자
		Egde(int end){
			this.end=end;
		}
		@Override
		public int compareTo(Egde o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	private static boolean floyd(int start, int end) {
		
    	Queue<Egde> pq = new LinkedList<>();
    	pq.add(new Egde(start));

		visited = new boolean[size];
		visited[start] = true;
		
		//큐에서 가져오기
    	while(!pq.isEmpty()) {
    		Egde node = pq.poll();

			//마지막까지 탐색했으면 끝낸다.
			if(node.end == end) {
				return true;
			}
			
    		//노드 탐색
			for(int i=0;i<graph[node.end].size();i++) { 
				Egde temp = graph[node.end].get(i); 
				
    			if(visited[temp.end] == false) { 
    				visited[temp.end]= true;
    				pq.add(new Egde(temp.end)); 
    			}
    		}
        }
    	
    	return false;
	}	
	
		
	
}
