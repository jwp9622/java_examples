package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// �ູ ��ġ�� / 13164
/*
�Է�
5 3
1 3 5 6 10

���
3


�ູ ��ġ�� /https://www.acmicpc.net/problem/13164

*/
public class Greedy_sensor_13164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		st = new StringTokenizer(bf.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	//������
		int K = Integer.parseInt(st.nextToken());	//���� ����
		
		
		//�ڷ�ޱ�
		int[] array = new int[N];
		st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			array[i] = a;
		}
		
		//�������� ����
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array)+"<==�Էµ����� ������������");
		
		//Ű���� ���ϱ�
		int[] dp = new int[N-1];
		for(int i=0;i<N-1;i++) {
			dp[i] = array[i+1]-array[i];
		}
		//System.out.println(Arrays.toString(dp)+"<==Ű���� ���ϱ�");
		
		//���� �Ÿ� �������� ����
		Arrays.sort(dp);
		//System.out.println(Arrays.toString(dp)+"<==�Ÿ� �������� ����");
		
		//������ ����� �����ϰ�, �ּ��� ���ϱ�
		int result =0;
		for(int i=0;i<N-K;i++) {
			result += dp[i];
		}
		
		//����� ���
		System.out.println(result);
		
		
	}
	
}
