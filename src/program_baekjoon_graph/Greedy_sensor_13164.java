package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 행복 유치원 / 13164
/*
입력
5 3
1 3 5 6 10

출력
3


행복 유치원 /https://www.acmicpc.net/problem/13164

*/
public class Greedy_sensor_13164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		st = new StringTokenizer(bf.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	//원생수
		int K = Integer.parseInt(st.nextToken());	//조의 갯수
		
		
		//자료받기
		int[] array = new int[N];
		st = new StringTokenizer(bf.readLine()," ");
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			array[i] = a;
		}
		
		//오름차순 정렬
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array)+"<==입력데이터 오름차순정렬");
		
		//키차이 구하기
		int[] dp = new int[N-1];
		for(int i=0;i<N-1;i++) {
			dp[i] = array[i+1]-array[i];
		}
		//System.out.println(Arrays.toString(dp)+"<==키차이 구하기");
		
		//센서 거리 오름차순 정렬
		Arrays.sort(dp);
		//System.out.println(Arrays.toString(dp)+"<==거리 오름차순 정렬");
		
		//마지막 계산은 제외하고, 최소합 더하기
		int result =0;
		for(int i=0;i<N-K;i++) {
			result += dp[i];
		}
		
		//결과값 출력
		System.out.println(result);
		
		
	}
	
}
