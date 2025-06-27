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

// 최댓값
public class Arrays_2562 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		//배열 선언
		List<Integer> list = new ArrayList<>();
		
		//공백 정수 배열 넣기
		int max_cnt = 9;
		for(int i=0;i<max_cnt;i++) {
			list.add( Integer.parseInt(br.readLine()));
		}

		//최대값 찾기
		int max = Collections.max(list);
		
		//최대값 인덱스 찾기
		int index = list.indexOf(max)+1;
		
		System.out.println(max);
		System.out.println(index);
		
	}

}
