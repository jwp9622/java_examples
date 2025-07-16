package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌게임 / 9655
public class DP_function_9655 {
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;	//돌 1개 1번 - 상근 sk 이김
        dp[2] = 2;  //돌 1개 2번 - 창영 cy 이김
        dp[3] = 1;  //돌 3개 1번 - 상근 sk 이김
        
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
            System.out.println(i+"__dp["+(i-1)+"]___dp["+(i-3) +"]__"+dp[i]);
        }
        if (dp[n] % 2 == 0) {
            System.out.println("CY"); //짝수 창영
        } else {
            System.out.println("SK"); //홀수 상근
        }
	}
}
