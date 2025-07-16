package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 신나는 함수 실행 / 9184
/*
입력
1 1 1
2 2 2
10 4 6
50 50 50
-1 7 18
-1 -1 -1

추력
w(1, 1, 1) = 2
w(2, 2, 2) = 4
w(10, 4, 6) = 523
w(50, 50, 50) = 1048576
w(-1, 7, 18) = 1

*/
public class DP_function_9184 {

	static int dp[][][] = new int [51][51][51];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1 && c == -1){
				break;
			}
			
			int d = w(a, b, c);
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, d);
			
			//System.out.println("w"+ "("+ a+","+b+","+c+") = "+d);
			//String str = "w("+a+","+b+","+c+") = "+d+"\n" ;
			//bw.write(visited[i]+"\n");
			
		}
		
	}
	public static int w(int a, int b, int c) {
		//System.out.println(a+"_"+b+"_"+c);
		
		//// 루프 방지 코드 입력
		if ((0 <= a && a <= 50 && 0 <= b && b <= 50 && 0 <= c && c <= 50) &&
			(dp[a][b][c]!=0)){
			return dp[a][b][c];	
		}

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return dp[a][b][c] =  w(20, 20, 20);
		}
		if(a < b && b < c ) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}else {
			return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
	}
	

}
