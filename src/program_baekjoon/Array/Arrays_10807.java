package program_baekjoon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//개수 세기 
public class Arrays_10807 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//정수입력
		int N = Integer.parseInt(br.readLine());
		
		//공백 정수 
		int array[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		//공백 정수 배열 넣기
		for(int i=0;i<array.length;i++) {
			array[i]= Integer.parseInt(st.nextToken());
		}
		
		//찾는 정수 입력받음.
		int V = Integer.parseInt(br.readLine());
		
		//비교
		int count = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i] == V) count++;
		}
		
		System.out.println(count);
		
		
	}

}
