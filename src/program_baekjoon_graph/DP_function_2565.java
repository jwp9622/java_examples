package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// ������ / 2565
/*
�Է�
6
2
1 6 9 3 6 7

���
3

*/

// ���߱��� ���Ű��ɿ����� �Ÿ��� ���� �ּҰ� 
public class DP_function_2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		int N = Integer.parseInt(bf.readLine()); //������ ��
		int K = Integer.parseInt(bf.readLine()); //���߱��� ����
		
		
		//�ڷ�ޱ�
		int[] array = new int[N];
		st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			array[i] = a;
		}
		
		//�������� ����
		Arrays.sort(array);
		System.out.println(Arrays.toString(array)+"<==�Էµ����� ������������");
		

		//���� �����鰣�� �Ÿ� ���ϱ�
		int[] dp = new int[N-1];
		for(int i=0;i<N-1;i++) {
			dp[i] = array[i+1]-array[i];
		}
		System.out.println(Arrays.toString(dp)+"<==���� �����鰣�� �Ÿ�");
		
		//���� �Ÿ� �������� ����
		Arrays.sort(dp);
		System.out.println(Arrays.toString(dp)+"<==�Ÿ� �������� ����");
		
		//�Ÿ� ���ϱ�
		int result =0;
		for(int i=0;i<N-K;i++) {
			result += dp[i];
		}
		
		//����� ���
		System.out.println(result);
		
		
		
	}
	

}
