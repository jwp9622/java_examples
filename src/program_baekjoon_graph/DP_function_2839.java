package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 설탕 배달 / 2839
/*
입력


추력

*/
public class DP_function_2839 {

	static int[] dp;
	static int INF = Integer.MAX_VALUE;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		dp = new int[N+1];
		
		Arrays.fill(dp, -1);

		
		//for(int i=0;i<array.length;i++) {
		//	System.out.println("__"+array[i]);
		//}		res = INF;
		
		res = INF;
		System.out.println(solve(N,0) == INF ? -1 : res);

		System.out.println(Arrays.toString(dp));
		
	}

	static int solve(int n, int count) {
		//n보다 작으면
		if(n<0) return 0;
		
		//이미 변경된 값이면
		if(dp[n] != -1) return dp[n];
		
		//마지막 값이면
		if(n == 0) {
			//res = Math.min(res, count);
			res = count;
			return res;

			//return count;
		}
		
		dp[n] = Math.min(solve(n-5, count+1), solve(n-3, count+1));
		return res;
		
	}
	

}
