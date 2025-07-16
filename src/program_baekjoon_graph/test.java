package program_baekjoon_graph;

import java.io.*;
import java.util.*;

public class test {
    static final int MOD = 998244353;
    static int N, M;
    static long[] fact, invFact;
    static List<Edge> edges;
    static UnionFind uf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u - 1, v - 1, w));
        }

        precomputeFactorials(M);
        edges.sort(Comparator.comparingInt(e -> e.w));
        uf = new UnionFind(N);

        long ans = 1;
        for (int i = 0; i < M; ) {
            int j = i;
            int w = edges.get(i).w;
            while (j < M && edges.get(j).w == w) j++;

            List<Edge> group = edges.subList(i, j);
            List<Edge> candidates = new ArrayList<>();
            int initialComponents = uf.components();

            for (Edge e : group) {
                if (uf.find(e.u) != uf.find(e.v)) {
                    candidates.add(e);
                }
            }

            int c = candidates.size();
            // 선택 가능한 간선 수 = (#components before) - (#components after including all candidates)
            // But we need to simulate to find k
            UnionFind tempUF = new UnionFind(uf);
            int k = 0;
            for (Edge e : candidates) {
                if (tempUF.union(e.u, e.v)) k++;
            }

            long ways = comb(c, k) * fact[k] % MOD;
            ans = ans * ways % MOD;

            // MST 반영
            for (int t = 0; t < k; t++) {
                uf.union(candidates.get(t).u, candidates.get(t).v);
            }

            i = j;
        }

        System.out.println(ans);
    }

    static void precomputeFactorials(int max) {
        fact = new long[max + 1];
        invFact = new long[max + 1];
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= max; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[max] = modInverse(fact[max]);
        for (int i = max; i >= 1; i--) invFact[i - 1] = invFact[i] * i % MOD;
    }

    static long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    static long pow(long a, long e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return r;
    }

    static long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int comps;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            comps = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        UnionFind(UnionFind other) {
            this.parent = other.parent.clone();
            this.rank = other.rank.clone();
            this.comps = other.comps;
        }

        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (rank[a] < rank[b]) {
                parent[a] = b;
            } else if (rank[a] > rank[b]) {
                parent[b] = a;
            } else {
                parent[b] = a;
                rank[a]++;
            }
            comps--;
            return true;
        }

        int components() { return comps; }
    }
}
