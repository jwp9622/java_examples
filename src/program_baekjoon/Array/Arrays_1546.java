package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//���
public class Arrays_1546 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //�ٱ���
		//int M = Integer.parseInt(st.nextToken()); //��
		
		//�ٱ��� �ʱ�ȭ
		List<Integer> list = new ArrayList<>();
		
		//�Է¹ޱ�
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		//�ִ밪 ���ϱ�
		double max = (double)Collections.max(list);

		//���ο� ���� ���� �����ϱ�
		double new_jumsu = 0;
		for(int i=0;i<list.size();i++) {
			
			double jumsu = (int)list.get(i);//(max*100);

			new_jumsu += (jumsu/max)*100;
		}		
		
		//��հ� ���
		double ave = new_jumsu/N;
		
		//���� ���
		bw.write(ave+"");
		bw.flush();
		bw.close();
	
		
	}

}
