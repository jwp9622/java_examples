package program_baekjoon_graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Graph_Kruskal_27071_claude {
    static int[] parent;

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
        List<Edge> order = kruskal(edges);

        System.out.println( "=================================");
        for(int i=0;i<edges.size();i++) {
        	System.out.println( edges.get(i).u+"__"+edges.get(i).v+"__"+edges.get(i).w );
        }
        System.out.println( "=================================");

        for(int i=0;i<order.size();i++) {
        	System.out.println( order.get(i).u+"__"+order.get(i).v+"__"+order.get(i).w );
        }
        System.out.println( "=================================");
        
        //int result = (int) Math.pow(2, order.size(), MOD);
        //System.out.println(result);
        
        int result = modPow(2, order.size(), MOD);
        System.out.println(result);
        
    }

    public static int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }

    public static List<Edge> kruskal(List<Edge> edges) {
        List<Edge> order = new ArrayList<>();
        int count = 0;

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            if (find(u) != find(v)) {
                union(u, v);
                order.add(edge);
                count++;

                if (count == N - 1) {
                    break;
                }
            }
        }

        return order;
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
            return this.w - o.w;
        }
    }
    
    
}