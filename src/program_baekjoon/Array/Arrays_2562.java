package program_baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// �ִ�
public class Arrays_2562 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		//�迭 ����
		List<Integer> list = new ArrayList<>();
		
		//���� ���� �迭 �ֱ�
		int max_cnt = 9;
		for(int i=0;i<max_cnt;i++) {
			list.add( Integer.parseInt(br.readLine()));
		}

		//�ִ밪 ã��
		int max = Collections.max(list);
		
		//�ִ밪 �ε��� ã��
		int index = list.indexOf(max)+1;
		
		System.out.println(max);
		System.out.println(index);
		
	}

}
