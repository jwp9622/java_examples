package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_floyd_NdanLogic_15723_graph {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Egde>[] graph;
	static int size = 26;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//����, ����
		N = Integer.parseInt(br.readLine()); // ����
		
		//������� arrayList map ����
		graph = new ArrayList[size];
		for(int i=0;i<size;i++) {	
			graph[i]= new ArrayList<Egde>();
		}

		//������� �Է¹���
		int minus_ascii = 97; //�ƽ�Ű�� ����
		for(int i=0;i<N;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // ��� ���
			 int end = (int)str.charAt(5)-minus_ascii; // ���� ���
	            
			 // �ܹ��� �׷���
			 graph[start].add(new Egde(end));
		}
		
		
		M = Integer.parseInt(br.readLine()); 
		
		//�˻��� ������� �Է¹���
		for(int i=0;i<M;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // ��� ���
			 int end = (int)str.charAt(5)-minus_ascii; // ���� ���

			 
			 //�� ���� ������ Ǯ���̵带 Ž��
			boolean result_flag = floyd(start, end);
			char result = (result_flag == true) ?'T' :'F';
			System.out.println(result);
			
		}
	
	}
	
	// ���� Ŭ����: ���� ������ ����(����ġ)
	//Comparable<Node> Ŭ������ �⺻ ���� ������ �����ϴ� �������̽�
	static class Egde implements Comparable<Egde>{
		int end;
		// ���� ���� ������
		Egde(int end){
			this.end=end;
		}
		@Override
		public int compareTo(Egde o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	private static boolean floyd(int start, int end) {
		
    	Queue<Egde> pq = new LinkedList<>();
    	pq.add(new Egde(start));

		visited = new boolean[size];
		visited[start] = true;
		
		//ť���� ��������
    	while(!pq.isEmpty()) {
    		Egde node = pq.poll();

			//���������� Ž�������� ������.
			if(node.end == end) {
				return true;
			}
			
    		//��� Ž��
			for(int i=0;i<graph[node.end].size();i++) { 
				Egde temp = graph[node.end].get(i); 
				
    			if(visited[temp.end] == false) { 
    				visited[temp.end]= true;
    				pq.add(new Egde(temp.end)); 
    			}
    		}
        }
    	
    	return false;
	}	
	
		
	
}
