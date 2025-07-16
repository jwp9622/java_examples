package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ������ / 9655
public class DP_function_9655 {
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;	//�� 1�� 1�� - ��� sk �̱�
        dp[2] = 2;  //�� 1�� 2�� - â�� cy �̱�
        dp[3] = 1;  //�� 3�� 1�� - ��� sk �̱�
        
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
            System.out.println(i+"__dp["+(i-1)+"]___dp["+(i-3) +"]__"+dp[i]);
        }
        if (dp[n] % 2 == 0) {
            System.out.println("CY"); //¦�� â��
        } else {
            System.out.println("SK"); //Ȧ�� ���
        }
	}
}
