package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//������
public class Arrays_3052 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//�Է°��� ����
		int max_cnt = 10;
		//�������� ����
		int minus_val = 42;
		
		//hashset ����
		HashSet<Integer> set = new HashSet<Integer>();
		
		//�� �޾ƿ���
		for(int i=0;i<max_cnt;i++) {
			int a = Integer.parseInt(br.readLine());
			set.add(a%minus_val);
		}
		
		bw.write(set.size()+"\n");

		bw.flush();
		bw.close();
		
	}

}
