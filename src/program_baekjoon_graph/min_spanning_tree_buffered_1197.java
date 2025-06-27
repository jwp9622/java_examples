package program_baekjoon_graph;

import java.util.*;
import java.io.*;

public class min_spanning_tree_buffered_1197 {
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
            //System.out.println("compareTo  ---");   
        	// this�� other���� ������ ����, ������ 0, ũ�� ��� ��ȯ
        	//System.out.println(this.weight+"___"+o.weight+"=====>"+Integer.compare(this.weight, o.weight));
        	//this.weight ���簡��ġ, o.weight ��������ġ
            return Integer.compare(this.weight, o.weight); // ����ġ ��������
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //����, ���� �Է¹���
        int V = Integer.parseInt(st.nextToken()); // ���� ����
        int E = Integer.parseInt(st.nextToken()); // ���� ����

        //����ġ ����Ʈ ����
        List<Edge> edges = new ArrayList<>();

        //������, ����, ���� �Է¹���.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(A, B, C));
            // 1 2 1
            // 2 3 2 
            // 1 3 3
        }

        // ����ġ �������� �������� ����
        Collections.sort(edges);  //����Ʈ(List)�� ������ �� ����ϴ� ����
        // 1 2 1
        // 2 3 2 
        // 1 3 3        

	        //System.out.println("--------------------------"); 
	        //for (Edge edge : edges) {
	        //	System.out.println(edge.from+"====="+edge.to+"===="+edge.weight);
	        //}  
	        
        //�θ����� ��ȣ�� 1,2,3������ ����ϱ� ���ؼ� +1�Ѵ�.[0, 1, 2, 3]
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i; // 
        }

        long totalWeight = 0; //���ϴ� ����ġ ���� ����
        int count = 0; //�߻�Ƚ�� ���� ����

        for (Edge edge : edges) {
        	
        	System.out.println("  ");
        	System.out.println("     from="+edge.from+"____to="+edge.to+"____weight="+edge.weight);
            
            if (union(edge.from, edge.to)) {
                totalWeight += edge.weight;
                count++;
            	System.out.println("     totalWeight="+totalWeight+",count="+count);
                if (count == V - 1) break; //�Ѱ����� ������ �����ϸ� �ߴ��Ѵ�. ���� -1 = ���� �� ����
            }
        }
        System.out.println(totalWeight);
    }
    

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // ��� ����
        }
        return parent[x];
    }

    public static boolean union(int a, int b) {
    	System.out.println("     a="+a+",b="+b);
        int rootA = find(a);
        int rootB = find(b);

    	System.out.println("     rootA="+rootA+",b="+rootB);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;

        System.out.println("     union parent="+Arrays.toString(parent));
        
        return true;
    }

   
    
}