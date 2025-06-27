package program_baekjoon_graph;

import java.io.*;
import java.util.*;


//각각의 경로마다 특징을 저장해둬야 할때는 DFS
//최단거리는 BFS

//그래프가 크다면 DFS를 고려
//그래프가 크지않고 원하는 대상이 별로 멀지 않으면 BFS

// 14496 문제
public class graph_dijstra_14496 {
	
	static ArrayList<Node>[] graph; // 정점들의 정보를 기록할 그래프
    static boolean[] visited; // 방문한 정점을 기록할 배열
    static int count; // 방문 순서
    
    static int A, B;
    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        //바꾸려는 문자 a,b 입력 받음
        st = new StringTokenizer(br.readLine()," ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        //N과, M 입력받음
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 조회여부 배열 기본값 세팅
        visited = new boolean[N+1];

        //그래프 기본값 세팅
        graph= new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {	
			graph[i]= new ArrayList<>();
		}
		
        for(int i=1;i<M+1;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
        	graph[n].add(new Node(m,1));
        	graph[m].add(new Node(n,1));
        }
        

        
        //////////////////////////////////
        
		System.out.println("--------------------------");
		
		for(int i=0;i<graph.length;i++) {
			System.out.println(i);
			for(int j=0;j<graph[i].size();j++) {
				System.out.println("__"+j+"="+graph[i].get(j).end+","+graph[i].get(j).cost);
			}
			System.out.println("  ");
		}
		System.out.println("--------------------------");
		
		
        	
        // 깊이 우선 탐색 재귀 시작
        dijkstra(A, B);

        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
/*
1 2
4 4
1 3
1 4
3 2
4 2

2
----------------------
2 3
3 3
1 2
1 3
3 2

1
*/
    
	static class Node implements Comparable<Node>{
		int end;
		int cost; // 돈가스를 먹었는지 여부 (0:안먹음, 1:먹음)
		// 간선 정보 생성자
		Node(int end,int cost){
			this.end=end; 
			this.cost=cost;	
		}
		@Override
		public int compareTo(Node o) { //객체간의 순서비교
			return this.cost-o.cost;
		}
	}
	
	
	// 깊이 우선 탐색 메서드
    private static void dijkstra(int start, int last) {
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start,0));
    	visited[start] = true;

		System.out.println("start="+start);
    	while(!pq.isEmpty()) {
    		Node node = pq.poll(); //자식노드꺼냄

			System.out.println("node.end="+node.end+",node.cost="+node.cost);
			
			//목적지면 끝낸다.
    		if(node.end==last) {
    			count =node.cost; 
    			return;
    		}
    		
            for (Node neighbor : graph[node.end]) {
            	
                if (!visited[neighbor.end]) {
                    visited[neighbor.end] = true;
                    pq.add(new Node(neighbor.end, node.cost + 1));
        			System.out.println("       "+neighbor.end+"_"+(node.cost + 1));
                }
            }

    		/*
    		for(int i=0;i< graph[node.end].size();i++) {
    			//int v = graph.get(poll).get(i);
    			//if(count == end) continue;
    			Node temp = graph[node.end].get(i); //자식노드꺼냄
    	    	
    			//System.out.println(i+"___"+ temp.end+"_"+temp.cost);
	    		//System.out.println("====="+ temp.end +"__"+temp.cost);
    	    	if(visited[temp.end] == falㄹse) {
    	    		//System.out.println("___=="+ temp.end);
    				visited[temp.end] = true;
    				p.add(new Node(temp.end, node.cost+1));
    				//System.out.println("       "+temp.end +"__"+(int)(node.cost+1));
    	    	}
    		}	
    		*/

            System.out.println("-------");
            
        }
    	count = -1;
    }
    
	
}
