package program_baekjoon_graph;

import java.util.*;


import java.io.*;


// 6497 / 전력난
public class graph_min_spanning_elec_6497 {

/*
입력
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
0 0
 
출력
51

*/    

    static int[] parent;
    static List<Edge> edges;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
	        //정점, 간선 입력받음
	        st = new StringTokenizer(br.readLine());
	        int V = Integer.parseInt(st.nextToken()); // 정점 개수
	        int E = Integer.parseInt(st.nextToken()); // 간선 개수
	        
	        //마지막이면 종료
	        if (V == 0 && E == 0) break;
	
	        //가중치 리스트 선언
	        edges = new ArrayList<>();
    	
	        //시작점, 종점, 간선 입력받음.
	        int cost = 0;
	        for (int i = 0; i < E; i++) {
	            st = new StringTokenizer(br.readLine());
	            int A = Integer.parseInt(st.nextToken());
	            int B = Integer.parseInt(st.nextToken());
	            int C = Integer.parseInt(st.nextToken());
	            
	            cost += C;
	            
	            edges.add(new Edge(A,B, C));
	            //edges[B].add(new Edge(A, C));
	        }
	
	        // 가중치 기준으로 오름차순 정렬
	        Collections.sort(edges);  
	        
	        //parent 선언
	        parent = new int[V];
	        for (int i = 0; i < V; i++) {
	            parent[i] = i; // 
	        }
	
	        long weight = 0; //더하는 가중치 변수 선언
	        int count = 0; //발생횟수 변수 선언
	
	        for(Edge edge : edges) {
	            if (union(edge.from, edge.to)) {
	                weight += edge.weight;
	                count++;
	                if (count == V - 1) break; //총간선의 갯수를 충족하면 중단한다. 종점 -1 = 간선 총 갯수
	            }
	        }
	        bw.write((cost-weight)+"\n");
    	}
        bw.flush();
        bw.close();
        br.close();
    }
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            //System.out.println("Edge 생성자  ---");            
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight); // 가중치 오름차순
        }
    }
    
    public static int find(int x) {
    	//부모노드가 같지 않으면 이전 부모노드를 찾는다
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
    	
    	//같으값이면 이미 방문 한것으로 여기고 return 
        if (rootA == rootB) return false;
        
        //아니면 부모노드값을 넣어준다.
        parent[rootB] = rootA;
        
        return true;
    }

   
    
}