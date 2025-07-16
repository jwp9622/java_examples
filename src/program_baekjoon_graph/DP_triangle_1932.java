package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 정수 삼각형 / 1932
/*
입력
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
		
		
출력
30

*/


public class DP_triangle_1932 {

	static int array[][];
	static Integer dp[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		array = new int[N][N];
		dp = new Integer[N][N];
		
		//값 입력받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0;j<i+1;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//마지막 값은 비교할수 없으니 마지막 열은 미리 넣어 놓는다.
		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = array[N - 1][i];
		}
		
		//재귀로 최대값 찾기
		System.out.print(find(0, 0));
		
	}
	
	static int find(int depth, int idx) {
		
		// 마지막 라인 체크
		if(depth == N - 1) {
			//System.out.println("	** return return["+depth+"]["+idx+"] = "+dp[depth][idx] );
			return dp[depth][idx];
		}
 
		// 탐색하지 않았던 값일 경우, 다음행의 왼쪽, 오른쪽 양쪽 값 비교
		System.out.println("dp["+depth+"]["+idx+"] ="+dp[depth][idx]);
		if (dp[depth][idx] == null) {

			//System.out.println("	값넣기 dp["+depth+"]["+idx+"] = Math.max(find("+(depth+ 1)+","+ idx+"), find("+(depth+1)+","+ (idx+1)+")) + array["+depth+"]["+idx+"]="+array[depth][idx]);
			
			//비교해서 큰값을 현재값과 더한다.
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + array[depth][idx];
		}

		//System.out.println("	* return dp["+depth+"]["+idx+"]="+dp[depth][idx] );
		return dp[depth][idx];
 
	}
}
