package program_baekjoon_graph;

import java.io.*;
import java.util.*;

//백준   24479번 /알고리즘 수업 - 깊이 우선 탐색 1
public class graph_DFS_judge {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
    static boolean[] visited; // 방문한 정점을 기록할 배열
    static int count = 1; // 카운터
    static int order[];
    static int vertex;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        vertex = Integer.parseInt(br.readLine());
        
		// 정점의 개수만큼의 크기로 배열 생성, 혼란방지 위해 +1
        visited = new boolean[vertex+1];

		// graph의 index를 정점의 개수만큼 만들어줌
        for(int i =0; i < vertex+1; i++) {
            graph.add(new ArrayList<>());
        }

        //정점, 간선 입력받음
        for(int i = 0; i < vertex-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
        	
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
			// 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        /*
        []
        [2, 3]
        [1, 4]
        [1]
        [2]
        */
        
        				
        //방문 순서 저장
        order = new int[vertex];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<vertex;i++) {
        	order[i] = Integer.parseInt(st.nextToken());
        }

		for(int i=0;i<graph.size();i++) {
			System.out.println(graph.get(i));
		}
        
        // 깊이 우선 탐색 시작
        dfs(1);

        //정상 방문여부 표시
		if(flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}       
    }
    
	// 깊이 우선 탐색 메서드
    private static void dfs(int x) {
		if(visited[x]) return;
		
		// x정점 방문
		visited[x] = true;

		HashSet<Integer> set = new HashSet<>();
		for(int next : graph.get(x)) {
			if(visited[next]) continue;
			set.add(next);
		}
		
		//hash가 0이면 정상적으로 다 검증된것이므로 빠져나감
		if(set.size() == 0) return;
		
		if(set.contains(order[count])) {
			int a = count++;
			dfs(order[a]);
		} else {
			flag = false;
		}
            
    }
    
    
	
}
