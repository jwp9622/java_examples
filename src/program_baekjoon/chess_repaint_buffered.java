package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chess_repaint_buffered {
	
	//public static boolean[][] arr;
	//public static int min = 64;
 
	public static void main(String[] args) throws IOException {
 
		boolean arr[][];
		int min = 64;
		long first = System.currentTimeMillis();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][M];
        
		// �迭 �Է� 
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					arr[i][j] = true;		// W�� ���� true 
				} else {
					arr[i][j] = false;		// B�� ���� false
				}
			}
		}
		
		int N_row = N - 7;
		int M_col = M - 7;
		
		
		//������ �迭��ŭ ����.
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {	
				
				int count = 0;
				boolean TF = arr[i][j];	// ù ��° ĭ�� �� 
				for(int x=i;x < (i+8);x++) {
					for(int y=x;y<(j+8);y++) {
						if(arr[x][y] != TF) count++;
						TF = (!TF); //����̸� ��, ���̸� ���
					}
					TF = (!TF); //�����ٿ����� �ٸ� ������ ����
				}
				min = Math.min(min, Math.min(count, 64-count));
		
			}
		}
		System.out.println(min);
		
		long last = System.currentTimeMillis();
		System.out.println(last-first);
	}
	
}
