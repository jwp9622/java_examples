package program_baekjoon_graph;

import java.util.*;


import java.io.*;


// 6497 / ���³�
public class graph_min_spanning_elec_6497 {

/*
�Է�
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
0 0
 
���
51

*/    

    static int[] parent;
    static List<Edge> edges;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
	        //����, ���� �Է¹���
	        st = new StringTokenizer(br.readLine());
	        int V = Integer.parseInt(st.nextToken()); // ���� ����
	        int E = Integer.parseInt(st.nextToken()); // ���� ����
	        
	        //�������̸� ����
	        if (V == 0 && E == 0) break;
	
	        //����ġ ����Ʈ ����
	        edges = new ArrayList<>();
    	
	        //������, ����, ���� �Է¹���.
	        int cost = 0;
	        for (int i = 0; i < E; i++) {
	            st = new StringTokenizer(br.readLine());
	            int A = Integer.parseInt(st.nextToken());
	            int B = Integer.parseInt(st.nextToken());
	            int C = Integer.parseInt(st.nextToken());
	            
	            cost += C;
	            
	            edges.add(new Edge(A,B, C));
	            //edges[B].add(new Edge(A, C));
	        }
	
	        // ����ġ �������� �������� ����
	        Collections.sort(edges);  
	        
	        //parent ����
	        parent = new int[V];
	        for (int i = 0; i < V; i++) {
	            parent[i] = i; // 
	        }
	
	        long weight = 0; //���ϴ� ����ġ ���� ����
	        int count = 0; //�߻�Ƚ�� ���� ����
	
	        for(Edge edge : edges) {
	            if (union(edge.from, edge.to)) {
	                weight += edge.weight;
	                count++;
	                if (count == V - 1) break; //�Ѱ����� ������ �����ϸ� �ߴ��Ѵ�. ���� -1 = ���� �� ����
	            }
	        }
	        bw.write((cost-weight)+"\n");
    	}
        bw.flush();
        bw.close();
        br.close();
    }
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            //System.out.println("Edge ������  ---");            
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight); // ����ġ ��������
        }
    }
    
    public static int find(int x) {
    	//�θ��尡 ���� ������ ���� �θ��带 ã�´�
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
    	
    	//�������̸� �̹� �湮 �Ѱ����� ����� return 
        if (rootA == rootB) return false;
        
        //�ƴϸ� �θ��尪�� �־��ش�.
        parent[rootB] = rootA;
        
        return true;
    }

   
    
}