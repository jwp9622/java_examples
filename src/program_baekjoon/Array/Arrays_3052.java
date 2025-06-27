package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//나머지
public class Arrays_3052 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//입력갯수 선언
		int max_cnt = 10;
		//나눌숫자 지정
		int minus_val = 42;
		
		//hashset 지정
		HashSet<Integer> set = new HashSet<Integer>();
		
		//값 받아오기
		for(int i=0;i<max_cnt;i++) {
			int a = Integer.parseInt(br.readLine());
			set.add(a%minus_val);
		}
		
		bw.write(set.size()+"\n");

		bw.flush();
		bw.close();
		
	}

}
