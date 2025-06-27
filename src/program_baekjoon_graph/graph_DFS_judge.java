package program_baekjoon_graph;

import java.io.*;
import java.util.*;

//����   24479�� /�˰��� ���� - ���� �켱 Ž�� 1
public class graph_DFS_judge {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // �������� ������ ����� �׷���
    static boolean[] visited; // �湮�� ������ ����� �迭
    static int count = 1; // ī����
    static int order[];
    static int vertex;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        vertex = Integer.parseInt(br.readLine());
        
		// ������ ������ŭ�� ũ��� �迭 ����, ȥ������ ���� +1
        visited = new boolean[vertex+1];

		// graph�� index�� ������ ������ŭ �������
        for(int i =0; i < vertex+1; i++) {
            graph.add(new ArrayList<>());
        }

        //����, ���� �Է¹���
        for(int i = 0; i < vertex-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
        	
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
			// �������̱� ������ �������� ������ �߰�
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
        
        				
        //�湮 ���� ����
        order = new int[vertex];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<vertex;i++) {
        	order[i] = Integer.parseInt(st.nextToken());
        }

		for(int i=0;i<graph.size();i++) {
			System.out.println(graph.get(i));
		}
        
        // ���� �켱 Ž�� ����
        dfs(1);

        //���� �湮���� ǥ��
		if(flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}       
    }
    
	// ���� �켱 Ž�� �޼���
    private static void dfs(int x) {
		if(visited[x]) return;
		
		// x���� �湮
		visited[x] = true;

		HashSet<Integer> set = new HashSet<>();
		for(int next : graph.get(x)) {
			if(visited[next]) continue;
			set.add(next);
		}
		
		//hash�� 0�̸� ���������� �� �����Ȱ��̹Ƿ� ��������
		if(set.size() == 0) return;
		
		if(set.contains(order[count])) {
			int a = count++;
			dfs(order[a]);
		} else {
			flag = false;
		}
            
    }
    
    
	
}
