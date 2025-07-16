package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 동전1 / 2294
/*
입력
3 15
1
5
12

출력
3

*/
public class DP_function_2294 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //동전종류
		int K = Integer.parseInt(st.nextToken()); //가치의 합
		
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		}
		int[] dp = new int [K+1];
		
		Arrays.sort(coin);
		

		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF-1);
		dp[0] = 0;
		
		for(int i=0; i<N;i++) {
			for(int j=1; j<=K; j++) {
				if(j >= coin[i]) { //동전에 크기를 비교해서 동적크기의 위치에서 다시계산
					//System.out.println(coin[i]+"__dp["+j+"]=dp["+j+"]+dp["+(j-coin[i])+"]");
					//dp[j] += dp[j-coin[i]];
					dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
				}
			}
			//System.out.println(Arrays.toString(dp));
			//System.out.println(" ");
		}
		
		int result = (dp[K] == INF-1)? -1 : dp[K];
		
		System.out.println(result);
		
	}
	

}
