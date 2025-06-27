package program_baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// �ּ�, �ִ� 
public class Arrays_10818 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//�����Է�
		int N = Integer.parseInt(br.readLine());
		
		//�迭 ����
		long array[] = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		//���� ���� �迭 �ֱ�
		for(int i=0;i<array.length;i++) {
			array[i]= Long.parseLong(st.nextToken());
		}
		//for������ if������ min, max���ϸ� ������
		//arrays.sort�� ����ؾ���.
		Arrays.sort(array);
		
		System.out.println(array[0]+" "+array[N-1]);
		
	}

}
