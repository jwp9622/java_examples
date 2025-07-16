package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 동전1 / 2293
/*
입력
3 10
1
2
5

추력
10
*/
public class DP_function_2293 {

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
		
		//초기값 세팅
		dp[0] = 1;

		System.out.println(Arrays.toString(dp));

		//메모제이션으로 누적값 계산
		for(int i=0; i<N;i++) { //동전 종류별 반복
			for(int j=1; j<=K; j++) { //갗
				if(j >= coin[i]) { //동전에 크기를 비교해서 동적크기의 위치에서 다시계산
					//System.out.println(coin[i]+"__dp["+j+"]=dp["+j+"]+dp["+(j-coin[i])+"]");
					dp[j] += dp[j-coin[i]];
				}
			}
			//System.out.println(Arrays.toString(dp));
			//System.out.println(" ");
		}
		System.out.println(dp[K]);
		
	}
	

}
