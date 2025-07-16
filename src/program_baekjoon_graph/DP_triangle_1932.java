package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ���� �ﰢ�� / 1932
/*
�Է�
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
		
		
���
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
		
		//�� �Է¹ޱ�
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0;j<i+1;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//������ ���� ���Ҽ� ������ ������ ���� �̸� �־� ���´�.
		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = array[N - 1][i];
		}
		
		//��ͷ� �ִ밪 ã��
		System.out.print(find(0, 0));
		
	}
	
	static int find(int depth, int idx) {
		
		// ������ ���� üũ
		if(depth == N - 1) {
			//System.out.println("	** return return["+depth+"]["+idx+"] = "+dp[depth][idx] );
			return dp[depth][idx];
		}
 
		// Ž������ �ʾҴ� ���� ���, �������� ����, ������ ���� �� ��
		System.out.println("dp["+depth+"]["+idx+"] ="+dp[depth][idx]);
		if (dp[depth][idx] == null) {

			//System.out.println("	���ֱ� dp["+depth+"]["+idx+"] = Math.max(find("+(depth+ 1)+","+ idx+"), find("+(depth+1)+","+ (idx+1)+")) + array["+depth+"]["+idx+"]="+array[depth][idx]);
			
			//���ؼ� ū���� ���簪�� ���Ѵ�.
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + array[depth][idx];
		}

		//System.out.println("	* return dp["+depth+"]["+idx+"]="+dp[depth][idx] );
		return dp[depth][idx];
 
	}
}
