package program_baekjoon.Array;

import java.io.*;
import java.util.*;

//바구니 뒤집기
public class Arrays_10811 {


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
			
			//검색을 1-4, 2,3 이렇게 두개씩 바꾼다.
			while(i<j) {
				int temp1 = array[i-1];
				int temp2 = array[j-1];
				
				array[i-1] = temp2;
				array[j-1] = temp1;
				i++;
				j--;
			}
		}
		
		
		//내용 출력
		for(int i=0;i<array.length;i++) {
			bw.write(array[i]+" ");
		}
		bw.flush();
		bw.close();
		
	}

}
