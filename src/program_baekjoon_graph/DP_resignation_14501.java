package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 퇴사 / 14501
/*
입력
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

출력
45

*/
public class DP_resignation_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//근무가능일수
		int N = Integer.parseInt(bf.readLine()); //day
		
		//입력받기
		int[][] array = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			array[i][0] = Integer.parseInt(st.nextToken()); //상담일수
			array[i][1] = Integer.parseInt(st.nextToken()); //상담비용
		}
		int[] dp = new int [N+1];
		
		
		//임시 내용 출
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				//System.out.println(array[i][j]);
			}
		}
		
		//dp 계산
		for(int i=0;i<N;i++) {
			
			System.out.println("i="+i);
			if(i + array[i][0] <= N) { //마지막 인지 체크
				//현재아이와 소요시간을 더한 다음 일정 과 dp에 시간을 더한값중에 최대값을 비교
				dp[i+array[i][0]] = Math.max(dp[i+array[i][0]], dp[i]+array[i][1]);
				
				//dp[i+array[i][0]] =  dp[i]+array[i][1];
				System.out.println("	Math.max(dp["+(i+array[i][0])+"], dp["+i+"]+array["+i+"][1])");
				
			}
			System.out.println( "		"+ Arrays.toString(dp));
			//마지막까지 배열에 안들어가는 수가 있으므로, 
			//현재위치에서 다음위치의 값을 비교해서 큰값을 다음위치에 넣는다.
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
			System.out.println( "		"+ Arrays.toString(dp) +"-----");
		}
		

		
		System.out.println(dp[N]);
		
	}
	

}
