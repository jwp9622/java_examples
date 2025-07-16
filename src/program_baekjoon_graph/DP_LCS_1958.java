package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// LCS 3 / 1958
/*
입력


*/


public class DP_LCS_1958 {

	static String array[][][];
	static String dp[][][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = 3;
		
		//값 입력받기
		String a = bf.readLine();	
		String b = bf.readLine();
		String c = bf.readLine();

		dp = new String[a.length()][b.length()][c.length()];
		
		
		//LCS 탐색
		System.out.print(getLCS(a, b, c));
		
	}
	
	public static int getLCS(String a, String b, String c) {

		int[][][] dp = new int[a.length() + 1][b.length() + 1][c.length() + 1];

		for (int i = 1; i <= a.length(); i++) {
			char ch1 = a.charAt(i - 1);

			for (int j = 1; j <= b.length(); j++) {
				char ch2 = b.charAt(j - 1);

				for (int k = 1; k <= c.length(); k++) {
					char ch3 = c.charAt(k - 1);
					

					if (ch1 == ch2 && ch2 == ch3)
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;

					else
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));


					//System.out.print(i+"_"+j+"_"+k+"==="+dp[i][j][k]);
				}
				//System.out.println(" ");
			}
		}

		return dp[a.length()][b.length()][c.length()];

	}
	
	
	
}
