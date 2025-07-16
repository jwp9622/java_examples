package program_baekjoon_graph;

import java.util.*;
import java.io.*;


// 1922 / 네트워크 연결
public class graph_min_spanning_network_1922 {

/*
입력
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
 
출력
23
*/    

    static int[] parent;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //정점, 간선 입력받음
        int V = Integer.parseInt(br.readLine()); // 정점 개수
        int E = Integer.parseInt(br.readLine()); // 간선 개수

        //가중치 리스트 선언
        List<Edge> edges = new ArrayList<>();

        //시작점, 종점, 간선 입력받음.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(A, B, C));
            // 1 2 1
            // 2 3 2 
            // 1 3 3
        }

        // 가중치 기준으로 오름차순 정렬
        Collections.sort(edges);  //리스트(List)를 정렬할 때 사용하는 정적
        // 1 2 1
        // 2 3 2 
        // 1 3 3       

        //System.out.println("--------------------------"); 
        //for (Edge edge : edges) {
        //	System.out.println(edge.from+"====="+edge.to+"===="+edge.weight);
        //}  
        
        //부모노드의 번호를 1,2,3번으로 사용하기 위해서 +1한다.[0, 1, 2, 3]
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i; // 
        }

        long totalWeight = 0; //더하는 가중치 변수 선언
        int count = 0; //발생횟수 변수 선언

        for (Edge edge : edges) {
        	
            if (union(edge.from, edge.to)) {
                totalWeight += edge.weight;
                count++;
                if (count == V - 1) break; //총간선의 갯수를 충족하면 중단한다. 종점 -1 = 간선 총 갯수
            }
        }
        System.out.println(totalWeight);
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
        
        parent[rootB] = rootA;

        return true;
    }

   
    
}