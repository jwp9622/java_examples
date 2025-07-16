package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import program_baekjoon_graph.graph_min_spanning_tree_buffered_1197.Edge;

/*
�Է�
5 4
1 2 1
1 3 1
1 4 1
1 5 1

���
24
---------------
�Է�
3 3
1 2 1
1 3 1
2 3 1

���
6

---------------

*/
//ũ�ν�Į �˰���  / 27071
public class Graph_Kruskal_27071 {

	static int N,M;
	static int[] parent;
	static List<Edge> graph;
	static List<Edge> order = new ArrayList<>();
	static long total = 0;
	static int count = 0;

    static final int MOD = 998244353;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//����, ����
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
		
		//������� arrayList map ����
		graph = new ArrayList<>();
		//for(int i=0;i<N+1;i++) {	
		//	graph[i]= new ArrayList<Egde>();
		//}
		
		parent = new int[N+1];
		for(int i=1;i<N+1;i++) {
			parent[i] = i;
		}

		//List<Edge> edges = new ArrayList<>();
		//������� �Է¹���
		int minus_ascii = 97; //�ƽ�Ű�� ����
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
	            
			 // �ܹ��� �׷���
			 graph.add(new Edge(u,v,w));
		}
		
		//�׷��� ����
		Collections.sort(graph);

		//ũ�ν�Į Ž��
         kruskal();		
         
         // graph
         // 1__2__1
         // 1__3__1
         // 2__3__1
         
         // order
         // 1__2__1
         // 1__3__1

         System.out.println( "=================================");
         for(int i=0;i<graph.size();i++) {
         	System.out.println( graph.get(i).from+"__"+graph.get(i).to+"__"+graph.get(i).weight );
         }
         System.out.println( "=================================");
         for(int i=0;i<order.size();i++) {
         	System.out.println( order.get(i).from+"__"+order.get(i).to+"__"+order.get(i).weight );
         }
         System.out.println( "=================================");
         
         
        // MST �������� ����ġ���� �׷�ȭ
        Map<Integer, Integer> hash = new HashMap<>();
        
        // hash���� ����ġ�� �ִ��� ���ؼ� ������ ����ġ�� 1�� ���ؼ� �ִ´�.
        int countWeight1 = 0;
        for (Edge e : order) {
        	hash.put(e.weight, hash.getOrDefault(e.weight, 0) + 1);
        	
        	if (e.weight == 1) countWeight1++;
        }
        // hash 
        // 1 : 2 

	        for (Entry<Integer, Integer> entrySet : hash.entrySet()) {	
	        	System.out.println(entrySet.getKey() + " : " + entrySet.getValue());	
	        }       
	        System.out.println( "=================================");
	        
	        
		//�� ����ġ�� �������� ���
	    long result = 1;
        for (int count : hash.values()) {
        	result = (result * factorial(count)) % MOD;
        }
        System.out.println(result);

        int need = N - 1;
        long result2 = permutation(countWeight1, need);
        System.out.println(result2);
        
	}
	
	
    //�� ����ġ�� �������� ���
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
        	System.out.println("result="+result+",i="+i+"==="+ (result * i) +"___"+MOD);
            result = (result * i) % MOD;

        	System.out.println("result="+result);
        	
        }
        return result;
    }

    // ���� nPk = n! / (n-k)!
    static long permutation(int n, int k) {
        long result = 1;
        for (int i = n; i > n - k; i--) {
            result = (result * i) % MOD;
        }
        return result;
    }
    
    
    //ũ�ν�Į �˰���
	private static void kruskal() {
	
		for(Edge edge : graph) {
			System.out.println("from,to==="+edge.from+"__"+edge.to);
			
			if( union(edge.from, edge.to)) {
				//total += edge.weight;
                order.add(edge);	//$F�� ���������� �ʱ�ȭ�Ѵ�. (
				count++;
				if(count == (N-1)) break;
			}
			
		}

	}	
	

	// ���� Ŭ����: ���� ������ ����(����ġ)
	//Comparable<Node> Ŭ������ �⺻ ���� ������ �����ϴ� �������̽�
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		// ���� ���� ������
		Edge(int from, int to, int weight){
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		@Override
		public int compareTo(Edge o) {
            return this.weight - o.weight;
		}
	}
	
	public static int find(int val) {
		//�θ��尡 ���� ������ ���� �θ��带 ã�´�
		//������ �θ����� ��� 1�̴�.
		if(parent[val] != val)
			parent[val] = find(parent[val]);
		return parent[val];
	}
	
	public static boolean union(int from, int to) {
		int root_a = find(from);
		int root_b = find(to);
		
		// �̹� �湮������ return 
		if(root_a == root_b) return false;
		
		//�ƴϸ� �θ��尪�� �־��ش�.
		parent[root_b] = root_a;
		
		return true;
	}
	
		
	
}
