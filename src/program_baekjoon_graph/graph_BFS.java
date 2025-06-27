package program_baekjoon_graph;

import java.io.*;
import java.util.*;


//������ ��θ��� Ư¡�� �����ص־� �Ҷ��� DFS
//�ִܰŸ��� BFS

//�׷����� ũ�ٸ� DFS�� ���
//�׷����� ũ���ʰ� ���ϴ� ����� ���� ���� ������ BFS


//����   24444�� /�˰��� ���� - ���� �켱 Ž�� 1
public class graph_BFS {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // �������� ������ ����� �׷���
    static int[] visited; // �湮�� ������ ����� �迭
    static int count; // �湮 ����

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

		// �湮�� ������ �ִ� ������ ������ŭ �ֱ� ������, ������ ������ŭ�� ũ��� �迭 ����
        // index ȥ���� �����ϰ��� 0�� �ε����� ���� �����ͷ� Ȱ��
        visited = new int[vertex+1];

		// graph�� index�� ������ ������ŭ �������
        for(int i =0; i < vertex+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

			// �������̱� ������ �������� ������ �߰�
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        

        // ���������� ���� ����
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
             
        
		// ���� ������ ������ �����̹Ƿ� count �ʱⰪ 1 �Ҵ�
        count = 1;
        
        // ���� �켱 Ž�� ��� ����
        bfs(startVertex);

		// �� �ε������� �湮 ������ ��ϵ� �迭�� ��ȸ�ϸ�, ���� StringBuilder�� ����
        for(int i = 1; i < visited.length; i++) {
            //sb.append(visited[i]).append("\n");
        	bw.write(visited[i]+"\n");
        }
        bw.flush();
        bw.close();
        //System.out.println(sb);
        
    }
/*
�Է�
5 5 1
1 4
1 2
2 3
2 4
3 4
 
���
1
2
4
3
0
 
*/
	// ���� �켱 Ž�� �޼���
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
