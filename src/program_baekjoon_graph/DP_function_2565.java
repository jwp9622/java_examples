package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 전깃줄 / 2565
/*
입력
6
2
1 6 9 3 6 7

출력
3

*/

// 집중국의 수신가능영역의 거리의 합이 최소값 
public class DP_function_2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		int N = Integer.parseInt(bf.readLine()); //센서의 수
		int K = Integer.parseInt(bf.readLine()); //집중국의 갯수
		
		
		//자료받기
		int[] array = new int[N];
		st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			array[i] = a;
		}
		
		//오름차순 정렬
		Arrays.sort(array);
		System.out.println(Arrays.toString(array)+"<==입력데이터 오름차순정렬");
		

		//인접 센서들간의 거리 구하기
		int[] dp = new int[N-1];
		for(int i=0;i<N-1;i++) {
			dp[i] = array[i+1]-array[i];
		}
		System.out.println(Arrays.toString(dp)+"<==인접 센서들간의 거리");
		
		//센서 거리 오름차순 정렬
		Arrays.sort(dp);
		System.out.println(Arrays.toString(dp)+"<==거리 오름차순 정렬");
		
		//거리 더하기
		int result =0;
		for(int i=0;i<N-K;i++) {
			result += dp[i];
		}
		
		//결과값 출력
		System.out.println(result);
		
		
		
	}
	

}
