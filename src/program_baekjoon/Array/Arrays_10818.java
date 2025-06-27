package program_baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소, 최대 
public class Arrays_10818 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//정수입력
		int N = Integer.parseInt(br.readLine());
		
		//배열 선언
		long array[] = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		//공백 정수 배열 넣기
		for(int i=0;i<array.length;i++) {
			array[i]= Long.parseLong(st.nextToken());
		}
		//for문에서 if문으로 min, max구하면 에러남
		//arrays.sort를 사용해야함.
		Arrays.sort(array);
		
		System.out.println(array[0]+" "+array[N-1]);
		
	}

}
