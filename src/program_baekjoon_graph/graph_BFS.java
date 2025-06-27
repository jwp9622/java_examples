package program_baekjoon_graph;

import java.io.*;
import java.util.*;


//각각의 경로마다 특징을 저장해둬야 할때는 DFS
//최단거리는 BFS

//그래프가 크다면 DFS를 고려
//그래프가 크지않고 원하는 대상이 별로 멀지 않으면 BFS


//백준   24444번 /알고리즘 수업 - 깊이 우선 탐색 1
public class graph_BFS {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
    static int[] visited; // 방문한 정점을 기록할 배열
    static int count; // 방문 순서

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

		// 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
        // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
        visited = new int[vertex+1];

		// graph의 index를 정점의 개수만큼 만들어줌
        for(int i =0; i < vertex+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

			// 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        

        // 오름차순을 위해 정렬
        for(int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        
        //System.out.println(Arrays.toString(visited));
        //for(int i=0;i<graph.size();i++) {
        //	System.out.println(graph.get(i));
        //}
        
        /*
        	[]
        	[2, 4]
        	[1, 3, 4]
        	[2, 4]
        	[1, 2, 3]
        	[]
        */				
             
        
		// 시작 정점도 순서에 포함이므로 count 초기값 1 할당
        count = 1;
        
        // 깊이 우선 탐색 재귀 시작
        bfs(startVertex);

		// 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
        for(int i = 1; i < visited.length; i++) {
            //sb.append(visited[i]).append("\n");
        	bw.write(visited[i]+"\n");
        }
        bw.flush();
        bw.close();
        //System.out.println(sb);
        
    }
/*
입력
5 5 1
1 4
1 2
2 3
2 4
3 4
 
출력
1
2
4
3
0
 
*/
	// 깊이 우선 탐색 메서드
    private static void bfs(int vertex) {
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.add(vertex);
    	visited[vertex] = count;
    	
    	while(!q.isEmpty()) {
    		int a = q.poll();
    		for(int i=0;i<graph.get(a).size();i++) {
    			int v = graph.get(a).get(i);
    			if(visited[v] ==0) {
    				q.offer(v);
    				count++;
    				visited[v] = count;
    			}
    		}
        }
       
    	/*
    	for(int j=1;j<graph.size();j++) {
    		int a = j;
    		
    		for(int i=0;i<graph.get(a).size();i++) {
    			int v = graph.get(a).get(i);
    			if(visited[v] ==0) {
    				count++;
    				visited[v] = count;
    			}
    		}
    	}
    	 */
    	
    	
    }
    
	
}
