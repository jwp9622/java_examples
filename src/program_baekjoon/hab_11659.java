package program_baekjoon;

import java.io.*;
import java.util.*;

//백준 11659
public class hab_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		//부분합으로 계산하기
		int array[] = new int[A+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<A;i++) {
			array[i] = array[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<B;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println( array[end] - array[start-1] );
		}
		//bw.write(sb+"");
		//bw.flush();
		//bw.close();
		
	}
}
