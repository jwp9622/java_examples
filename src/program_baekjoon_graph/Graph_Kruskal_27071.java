package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import program_baekjoon_graph.graph_min_spanning_tree_buffered_1197.Edge;

/*
입력
5 4
1 2 1
1 3 1
1 4 1
1 5 1

출력
24
---------------
입력
3 3
1 2 1
1 3 1
2 3 1

출력
6

---------------

*/
//크로스칼 알고리즘  / 27071
public class Graph_Kruskal_27071 {

	static int N,M;
	static int[] parent;
	static List<Edge> graph;
	static List<Edge> order = new ArrayList<>();
	static long total = 0;
	static int count = 0;

    static final int MOD = 998244353;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//정점, 간선
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 정점
		
		//노드정보 arrayList map 선언
		graph = new ArrayList<>();
		//for(int i=0;i<N+1;i++) {	
		//	graph[i]= new ArrayList<Egde>();
		//}
		
		parent = new int[N+1];
		for(int i=1;i<N+1;i++) {
			parent[i] = i;
		}

		//List<Edge> edges = new ArrayList<>();
		//노드정보 입력받음
		int minus_ascii = 97; //아스키값 빼기
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
	            
			 // 단방향 그래프
			 graph.add(new Edge(u,v,w));
		}
		
		//그래프 정렬
		Collections.sort(graph);

		//크로스칼 탐색
         kruskal();		
         
         // graph
         // 1__2__1
         // 1__3__1
         // 2__3__1
         
         // order
         // 1__2__1
         // 1__3__1

         System.out.println( "=================================");
         for(int i=0;i<graph.size();i++) {
         	System.out.println( graph.get(i).from+"__"+graph.get(i).to+"__"+graph.get(i).weight );
         }
         System.out.println( "=================================");
         for(int i=0;i<order.size();i++) {
         	System.out.println( order.get(i).from+"__"+order.get(i).to+"__"+order.get(i).weight );
         }
         System.out.println( "=================================");
         
         
        // MST 간선들을 가중치별로 그룹화
        Map<Integer, Integer> hash = new HashMap<>();
        
        // hash에서 가중치를 있는지 비교해서 없으면 가중치를 1씩 더해서 넣는다.
        int countWeight1 = 0;
        for (Edge e : order) {
        	hash.put(e.weight, hash.getOrDefault(e.weight, 0) + 1);
        	
        	if (e.weight == 1) countWeight1++;
        }
        // hash 
        // 1 : 2 

	        for (Entry<Integer, Integer> entrySet : hash.entrySet()) {	
	        	System.out.println(entrySet.getKey() + " : " + entrySet.getValue());	
	        }       
	        System.out.println( "=================================");
	        
	        
		//각 가중치의 순열합을 계산
	    long result = 1;
        for (int count : hash.values()) {
        	result = (result * factorial(count)) % MOD;
        }
        System.out.println(result);

        int need = N - 1;
        long result2 = permutation(countWeight1, need);
        System.out.println(result2);
        
	}
	
	
    //각 가중치의 순열합을 계산
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
        	System.out.println("result="+result+",i="+i+"==="+ (result * i) +"___"+MOD);
            result = (result * i) % MOD;

        	System.out.println("result="+result);
        	
        }
        return result;
    }

    // 순열 nPk = n! / (n-k)!
    static long permutation(int n, int k) {
        long result = 1;
        for (int i = n; i > n - k; i--) {
            result = (result * i) % MOD;
        }
        return result;
    }
    
    
    //크로스칼 알고리즘
	private static void kruskal() {
	
		for(Edge edge : graph) {
			System.out.println("from,to==="+edge.from+"__"+edge.to);
			
			if( union(edge.from, edge.to)) {
				//total += edge.weight;
                order.add(edge);	//$F를 공집합으로 초기화한다. (
				count++;
				if(count == (N-1)) break;
			}
			
		}

	}	
	

	// 간선 클래스: 도착 정점과 이익(가중치)
	//Comparable<Node> 클래스의 기본 정렬 기준을 설정하는 인터페이스
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		// 간선 정보 생성자
		Edge(int from, int to, int weight){
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		@Override
		public int compareTo(Edge o) {
            return this.weight - o.weight;
		}
	}
	
	public static int find(int val) {
		//부모노드가 같지 않으면 이전 부모노드를 찾는다
		//어자피 부모노느는 모두 1이다.
		if(parent[val] != val)
			parent[val] = find(parent[val]);
		return parent[val];
	}
	
	public static boolean union(int from, int to) {
		int root_a = find(from);
		int root_b = find(to);
		
		// 이미 방문했으면 return 
		if(root_a == root_b) return false;
		
		//아니면 부모노드값을 넣어준다.
		parent[root_b] = root_a;
		
		return true;
	}
	
		
	
}
