package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//�ٱ��� ������
public class Arrays_10811 {


	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //�ٱ���
		int M = Integer.parseInt(st.nextToken()); //��
		
		//�ٱ��� �ʱ�ȭ
		int array[] = new int[N];
		for(int i=0;i<array.length;i++) {
			array[i]= i+1;
		}
		
		//�� �ٲٱ�
		for(int aa=0;aa<M;aa++) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken()); 
			
			//�˻��� 1-4, 2,3 �̷��� �ΰ��� �ٲ۴�.
			while(i<j) {
				int temp1 = array[i-1];
				int temp2 = array[j-1];
				
				array[i-1] = temp2;
				array[j-1] = temp1;
				i++;
				j--;
			}
		}
		
		
		//���� ���
		for(int i=0;i<array.length;i++) {
			bw.write(array[i]+" ");
		}
		bw.flush();
		bw.close();
		
	}

}
