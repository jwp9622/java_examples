package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// ��� / 14501
/*
�Է�
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

���
45

*/
public class DP_resignation_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//�ٹ������ϼ�
		int N = Integer.parseInt(bf.readLine()); //day
		
		//�Է¹ޱ�
		int[][] array = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			array[i][0] = Integer.parseInt(st.nextToken()); //����ϼ�
			array[i][1] = Integer.parseInt(st.nextToken()); //�����
		}
		int[] dp = new int [N+1];
		
		
		//�ӽ� ���� ��
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				//System.out.println(array[i][j]);
			}
		}
		
		//dp ���
		for(int i=0;i<N;i++) {
			
			System.out.println("i="+i);
			if(i + array[i][0] <= N) { //������ ���� üũ
				//������̿� �ҿ�ð��� ���� ���� ���� �� dp�� �ð��� ���Ѱ��߿� �ִ밪�� ��
				dp[i+array[i][0]] = Math.max(dp[i+array[i][0]], dp[i]+array[i][1]);
				
				//dp[i+array[i][0]] =  dp[i]+array[i][1];
				System.out.println("	Math.max(dp["+(i+array[i][0])+"], dp["+i+"]+array["+i+"][1])");
				
			}
			System.out.println( "		"+ Arrays.toString(dp));
			//���������� �迭�� �ȵ��� ���� �����Ƿ�, 
			//������ġ���� ������ġ�� ���� ���ؼ� ū���� ������ġ�� �ִ´�.
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
			System.out.println( "		"+ Arrays.toString(dp) +"-----");
		}
		

		
		System.out.println(dp[N]);
		
	}
	

}
