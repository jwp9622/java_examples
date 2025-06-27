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


//백준  19701번 문제 /다이스트라 알고리즘
public class graph_dijkstra_19701 {

	static int v,e;
	static int[][] dist;
	static ArrayList<Node>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//휴게소정보 입력받음
		v = Integer.parseInt(st.nextToken());
		
		//고속도로 입력받음
		e = Integer.parseInt(st.nextToken());
		
		// 거리 배열 초기화
		dist= new int[v+1][2]; // [노드번호][0:안먹음, 1:먹음]
		
		//노드정보 arrayList map 선언
		map= new ArrayList[v+1];
		
		//각 노드별 배열 선언
		for(int i=0;i<v+1;i++) {	
			map[i]= new ArrayList<>();
			dist[i][0]=Integer.MAX_VALUE; // 매우 큰 수로 초기화
			dist[i][1]=Integer.MAX_VALUE; // 매우 큰 수로 초기화
		}
		
		//for(int i=0;i<dist.length;i++) {
		//	for(int j=0;j<dist[i].length;j++) {
		//		System.out.println(i+"__"+j+"__"+dist[i][j]);
		//	}
		//}
		
		//노드정보 입력받음
		for(int i=0;i<e;i++) {
			 st = new StringTokenizer(br.readLine()); 
			 int x = Integer.parseInt(st.nextToken());  // 출발 노드
			 int y = Integer.parseInt(st.nextToken()); // 도착 노드
			 int w = Integer.parseInt(st.nextToken()); // 도로 비용
			 int f = Integer.parseInt(st.nextToken()); // 돈가스 맛
			 
			// 양방향 그래프
			 map[x].add(new Node(y,w,f));
			 map[y].add(new Node(x,w,f));
			 
		}

		
		System.out.println("--------------------------");
		
		for(int i=0;i<map.length;i++) {
			System.out.println(i);
			for(int j=0;j<map[i].size();j++) {
				System.out.println("__"+j+"__"+map[i].get(j).idx+"_"+map[i].get(j).weight+"_"+map[i].get(j).food+"_"+map[i].get(j).eat);
			}
			System.out.println("  ");
		}
		
		for(int i=0;i<v+1;i++) {
			System.out.println(i+"_0_"+dist[i][0]);
			System.out.println(i+"_1_"+dist[i][1]);
		}

		System.out.println("--------------------------");
		
		
		
		//탐색 시작
		dij(1);
		
		//결과 내용 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<v+1;i++) {
			// 돈가스를 먹었을 때와 안 먹었을 때 중 최소값 출력
			sb.append(Math.min(dist[i][0], dist[i][1])).append("\n");
		}
		System.out.println(sb.toString());
	}
	//Comparable<Node> 클래스의 기본 정렬 기준을 설정하는 인터페이스
	static class Node implements Comparable<Node>{
		int idx,weight,food;
		int eat; // 돈가스를 먹었는지 여부 (0:안먹음, 1:먹음)
		// 간선 정보 생성자
		Node(int idx, int weight,int food){
			this.idx=idx; 
			this.weight=weight;	
			this.food=food;
		}
		// 우선순위 큐용 생성자
		Node(int idx, int weight,int food,int eat){
			this.idx=idx;
			this.weight=weight;
			this.food=food;
			this.eat=eat;
		}
		@Override
		public int compareTo(Node o) { //객체간의 순서비교
			return this.weight-o.weight;
		}
	}
	
	
	//
	static void dij(int idx) {

		//System.out.println("idx="+idx);
		
		PriorityQueue<Node> p = new PriorityQueue<>(); //우선순위 기준(숫자 크기 등)으로 정렬된 순서로 처리하고 싶을 때 사용
		//Queue<Integer> q = new LinkedList<>(); //입력 순서를 그대로 처리하고 싶을 때 사용
		
		p.add(new Node(idx,0,0));
		dist[idx][0]=0; // 시작 노드는 돈까스를 안 먹은 상태로 0
		dist[idx][1]=0;
		
		while(!p.isEmpty()) {
			Node node = p.poll(); //현재까지의 최단 거리 노드를 꺼냅니다.
			
			// 현재 노드까지의 거리보다 비용이 크면 무시
			if(dist[node.idx][node.eat]<node.weight) continue; //59퍼 시간초과 해결,,
			
			// 인접한 노드들을 탐색
			for(int i=0;i<map[node.idx].size();i++) {
				Node temp = map[node.idx].get(i); //자식노드꺼냄

				//돈까스를 먹는 경우, 지금까지 안먹었으면
				if(node.eat==0) { 
					// 돈까스를 먹지 않았다면 돈까스를 사용해서 할인받을 수 있음.
					int costWithFood = node.weight + temp.weight - temp.food;
					if(dist[temp.idx][1]> costWithFood) { //돈까스 먹었을때 더 작은지 비교
						dist[temp.idx][1] = costWithFood;  //돈까스 먹음 표시로 eat 1
						p.add(new Node(temp.idx,dist[temp.idx][1],0,1));
					}
				}
				
				//돈까스를 안먹거나 이미 먹은 경우
				// dist[temp.idx][0] 처리하면 이미먹었을수도 있으니 또 안 먹은 상태로 생신하면 논리 오류남.
				int costWithoutFood = node.weight + temp.weight;
				if(dist[temp.idx][node.eat]>costWithoutFood) {
					dist[temp.idx][node.eat] = costWithoutFood;
					p.add(new Node(temp.idx,dist[temp.idx][node.eat],0,node.eat));
				}
				
			}
			
			
		}
	}
	
}