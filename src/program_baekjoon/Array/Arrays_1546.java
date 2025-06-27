package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//평균
public class Arrays_1546 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //바구니
		//int M = Integer.parseInt(st.nextToken()); //공
		
		//바구니 초기화
		List<Integer> list = new ArrayList<>();
		
		//입력받기
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		//최대값 구하기
		double max = (double)Collections.max(list);

		//새로운 점수 만들어서 저장하기
		double new_jumsu = 0;
		for(int i=0;i<list.size();i++) {
			
			double jumsu = (int)list.get(i);//(max*100);

			new_jumsu += (jumsu/max)*100;
		}		
		
		//평균값 계산
		double ave = new_jumsu/N;
		
		//내용 출력
		bw.write(ave+"");
		bw.flush();
		bw.close();
	
		
	}

}
