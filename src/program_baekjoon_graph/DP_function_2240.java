package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// ����1 / 2240
/*
�Է�
7 2
2
1
1
2
2
1
1

���
6

*/
public class DP_function_2240 {

	static int N, K, tree;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //��������
		K = Integer.parseInt(st.nextToken()); //��ġ�� ��
		
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			//coin[i] = Integer.parseInt(bf.readLine());
		}
		int[][] dp = new int[N+1][K+1];
		

        for (int i=1; i<=N; i++) {
            tree = Integer.parseInt(bf.readLine());

            for (int j=0; j<=K; j++) {

                if (j == 0) {
                    if (tree == 1) { dp[i][j] = dp[i-1][j] + 1; } 
                    else { dp[i][j] = dp[i-1][j];}

                    continue;
                }

                if (j%2 == 0) {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]); // ���� ��ġ�� ���Ű� �������� ��ġ�� ���ٸ� +1, �������ٸ� �ٸ� �����̴� +0
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1); // �������� +1
                    }
                } else {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]); // �������� +1
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1); // ������ �־�� +1
                    }
                }
            }
        }

        int ans = 0;
        for (int i=0; i<=K; i++) {
            ans = Math.max(ans, dp[N][K]);
        }

        System.out.println(ans);
        
		
		
	}
	

}
