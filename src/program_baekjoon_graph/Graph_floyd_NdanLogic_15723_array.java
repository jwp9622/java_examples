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


public class Graph_floyd_NdanLogic_15723_array {

	static int N,M;
	static boolean[] visited;
	//static ArrayList<Egde>[] graph;
	static int size = 26;
	static boolean map[][] = new boolean[size][size];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//����, ����
		//st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(br.readLine()); // ����
		
		//������� arrayList map ����
		//graph = new ArrayList[size];
		//for(int i=0;i<size;i++) {	
		//	graph[i]= new ArrayList<Egde>();
		//}

		//������� �Է¹���
		int minus_ascii = 97; //�ƽ�Ű�� ����
		for(int i=0;i<N;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // ��� ���
			 int end = (int)str.charAt(5)-minus_ascii; // ���� ���
	            
	            
			 // �ܹ��� �׷���
			 //System.out.println(	"___"+(start)+"___"+(end));
			 //graph[start].add(new Egde(end));
			 
			 map[start][end] = true;
		}
		
		//�׷��� �� ����ϱ�
		//System.out.println("--------------------------");
		//for(int i=1;i<graph.length;i++) {
		//	for(int j = 0;j<graph[i].size();j++) {
		//		System.out.println("__"+i+"__"+graph[i].get(j).end+"__"+graph[i].get(j).cost );
		//	}
		//}
		//System.out.println("--------------------------");
		
		
		M = Integer.parseInt(br.readLine()); 
		
		//�˻��� ������� �Է¹���
		for(int i=0;i<M;i++) {
			 String str = br.readLine(); 
			 int start = (int)str.charAt(0)-minus_ascii; // ��� ���
			 int end = (int)str.charAt(5)-minus_ascii; // ���� ���

            //String command = br.readLine();
            //int start = command.charAt(0)-'a';
            //int end = command.charAt(5)-'a';
            

			//System.out.println(	"___"+(start)+"___"+(end));
			 
			 //�� ���� ������ Ǯ���̵带 Ž��
			boolean result_flag = floyd(start, end);
			char result = (result_flag == true) ?'T' :'F';
			System.out.println(result);
			//sb.append(result+"\n");
			
			 
            //if(result_flag){
            //    System.out.println('T');
            //}else{
            //    System.out.println('F');
            //}			
			
		}
		
		
/*

3
a is b
b is c
c is d

3
a is d
a is c
d is a
 
*/		
		
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

    	Queue<Integer> pq = new LinkedList<>();
    	pq.add(start);

		visited = new boolean[size];
		visited[start] = true;
		
		//ť���� ��������
    	while(!pq.isEmpty()) {
    		int now = pq.poll();

			//���������� Ž�������� ������.
			//System.out.println("	temp.end="+temp.end+",end="+end);
			if(now == end) {
				return true;
			}
			
    		//��� Ž��
			for(int i=0;i<size;i++) { 
				//Egde temp = graph[node.end].get(i); 
				//System.out.println("	temp.end="+temp.end);
				
    			if(visited[i] == false && map[now][i]) {
    				visited[i]= true;
    				pq.add(i);   				
    			}
    		}
        }
    	
    	return false;
		
	}	
	
		
	
}
