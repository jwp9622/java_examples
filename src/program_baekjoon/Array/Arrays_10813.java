package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//공바꾸기 문제
public class Arrays_10813 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //바구니
		int M = Integer.parseInt(st.nextToken()); //공
		
		//바구니 초기화
		int array[] = new int[N];
		for(int i=0;i<array.length;i++) {
			array[i]= i+1;
		}
		
		//공 바꾸기
		for(int aa=0;aa<M;aa++) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken()); 
			
			int a = array[i-1];
			int b = array[j-1];

			array[j-1] = a;
			array[i-1] = b;
		}
		
		//내용 출력
		for(int i=0;i<array.length;i++) {
			bw.write(array[i]+" ");
		}
		bw.flush();
		bw.close();
		
	}

}
