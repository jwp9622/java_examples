package program_baekjoon_graph;

import java.util.*;
import java.io.*;


// 1922 / ��Ʈ��ũ ����
public class graph_min_spanning_network_1922 {

/*
�Է�
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
 
���
23
*/    

    static int[] parent;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //����, ���� �Է¹���
        int V = Integer.parseInt(br.readLine()); // ���� ����
        int E = Integer.parseInt(br.readLine()); // ���� ����

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
        	
            if (union(edge.from, edge.to)) {
                totalWeight += edge.weight;
                count++;
                if (count == V - 1) break; //�Ѱ����� ������ �����ϸ� �ߴ��Ѵ�. ���� -1 = ���� �� ����
            }
        }
        System.out.println(totalWeight);
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
        
        parent[rootB] = rootA;

        return true;
    }

   
    
}