package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// ����1 / 2293
/*
�Է�
3 10
1
2
5

�߷�
10
*/
public class DP_function_2293 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //��������
		int K = Integer.parseInt(st.nextToken()); //��ġ�� ��
		
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		}
		int[] dp = new int [K+1];
		
		//�ʱⰪ ����
		dp[0] = 1;

		System.out.println(Arrays.toString(dp));

		//�޸����̼����� ������ ���
		for(int i=0; i<N;i++) { //���� ������ �ݺ�
			for(int j=1; j<=K; j++) { //��
				if(j >= coin[i]) { //������ ũ�⸦ ���ؼ� ����ũ���� ��ġ���� �ٽð��
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
