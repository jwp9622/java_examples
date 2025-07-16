package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Graph_Kruskal_27071_gpt {
    static int[] parent;
    static final int MOD = 998244353;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);

        // MST ����
        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            if (find(u) != find(v)) {
                union(u, v);
                mst.add(edge);
                if (mst.size() == N - 1) break;
            }
        }
        

        System.out.println( "=================================");
        for(int i=0;i<edges.size();i++) {
        	System.out.println( edges.get(i).u+"__"+edges.get(i).v+"__"+edges.get(i).w );
        }
        System.out.println( "=================================");

        for(int i=0;i<mst.size();i++) {
        	System.out.println( mst.get(i).u+"__"+mst.get(i).v+"__"+mst.get(i).w );
        }
        System.out.println( "=================================");
        

        // MST �������� ����ġ���� �׷�ȭ
        Map<Integer, Integer> weightCount = new HashMap<>();
        //weightCount���� ����ġ�� �ִ��� ���ؼ� ������ ����ġ�� 1�� ���ؼ� �ִ´�.
        for (Edge e : mst) {
        	System.out.println( "=="+e.w+"__"+( weightCount.getOrDefault(e.w, 0) + 1 ));
            
        	weightCount.put(e.w, weightCount.getOrDefault(e.w, 0) + 1);
        }

        for (Entry<Integer, Integer> entrySet : weightCount.entrySet()) {	
        	System.out.println(entrySet.getKey() + " : " + entrySet.getValue());	
        }
        
        // �� ����ġ �׷��� ���� ���� ���� ��� (��ⷯ ���丮��)
        // �� ����ġ���� ������ �׷�ȭ �Ѵ�.
        // ����(���� ����)�� ����� ���� ���ؼ� ���� ����� ���ϴ� �κ��Դϴ�.
        
        // ������ ���� ������ ���� ����ġ�� ���� �����鳢���� ���� ������ �ٲ㵵 ����� ���� ����.
        // n! = n*(n-1)*(n-2) * ... x1
        // n! = 3*2*1 = 6
        
        long result = 1;
        for (int count : weightCount.values()) {
        	System.out.println("count="+count);
        	
            result = (result * factorial(count, MOD)) % MOD;
        }

        System.out.println(result);
    }

    //�� ����ġ�� �������� ���
    public static long factorial(int n, int mod) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
        	System.out.println("result="+result+",i="+i+"==="+ (result * i) +"___"+mod);
            result = (result * i) % mod;

        	System.out.println("result="+result);
        	
        }
        return result;
    }

    
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot < yRoot) {
            parent[yRoot] = xRoot;
        } else {
            parent[xRoot] = yRoot;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}