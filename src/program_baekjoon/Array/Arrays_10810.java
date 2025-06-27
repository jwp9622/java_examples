package program_baekjoon.Array;

import java.io.*;
import java.util.*;

// °ø ³Ö±â 
public class Arrays_10810 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int array[] = new int[N];
		
		ArrayList<int[]> list = new ArrayList<>();
		

		for(int aa=0;aa<M;aa++) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken()); 

			for(int ii=i-1;ii<j;ii++) {
				array[ii] = k;
			}
		}
		
		for(int i=0;i<array.length;i++) {
			bw.write(array[i]+" ");
		}
		bw.flush();
		bw.close();
		
	}

}
