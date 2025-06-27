package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


//����   24479�� /�˰��� ���� - ���� �켱 Ž�� 1
public class graph_DFS {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // �������� ������ ����� �׷���
    static int[] check; // �湮�� ������ ����� �迭
    static int count; // �湮 ����

    public static void main(String[] args) throws IOException {
    	
    	long first = System.currentTimeMillis();
    	
        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

		// �湮�� ������ �ִ� ������ ������ŭ �ֱ� ������, ������ ������ŭ�� ũ��� �迭 ����
        // index ȥ���� �����ϰ��� 0�� �ε����� ���� �����ͷ� Ȱ��
        check = new int[vertex+1];

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
        //System.out.println("-----------");
        
        System.out.println(Arrays.toString(check));
        for(int i=0;i<graph.size();i++) {
        	System.out.println(graph.get(i));
        }
             
        
		// ���� ������ ������ �����̹Ƿ� count �ʱⰪ 1 �Ҵ�
        count = startVertex;
        
        // ���� �켱 Ž�� ��� ����
        dfs(startVertex);

		// �� �ε������� �湮 ������ ��ϵ� �迭�� ��ȸ�ϸ�, ���� StringBuilder�� ����
        for(int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
        
        long last = System.currentTimeMillis();
        long time = last-first;
        
        System.out.println(time);
        
    }
    
	// ���� �켱 Ž�� �޼���
    private static void dfs(int vertex) {
        check[vertex] = count; // ���� �湮�ϰ��ִ� ������ ���� ����
        
        //System.out.println(Arrays.toString(check));
        //System.out.println("count="+count+",vertex="+vertex);
        //System.out.println("-----------111");
        
		// ���� ��ġ�� ������ �� �� �ִ� ���� ����Ʈ�� ��ȸ
        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            
            //���� �� ������ �湮�߾����� üũ(0�� ��� �湮 X)
            if(check[newVertex] == 0){
                count++;
                //System.out.println("ȣ�� count="+count +",newVertex="+newVertex);
                
                dfs(newVertex);
            }
        }
            
    }
    
    
    
    
	
}
