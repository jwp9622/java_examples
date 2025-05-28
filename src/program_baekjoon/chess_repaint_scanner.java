package program_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class chess_repaint_scanner {
	
	public static boolean[][] arr;
	public static int min = 64;
	
	public static void main(String[] args) {
		long first = System.currentTimeMillis();

		////////////////////////		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); 
		int M = in.nextInt();
		
		arr = new boolean[N][M];
        
		// 배열 입력 
		for (int i = 0; i < N; i++) {
			String str = in.next();
			
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					arr[i][j] = true;		// W일 때는 true 
				} else {
					arr[i][j] = false;		// B일 때는 false
				}
			}
		}
		
		
		int N_row = N - 7;
		int M_col = M - 7;
		
		
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {	
				
				//find(i, j);
				int count = 0;
				boolean TF = arr[i][j];	// 첫 번째 칸의 색 
				for(int x=i;x < (i+8);x++) {
					for(int y=j;y<(j+8);y++) {
						if(arr[x][y] != TF) count++;
						TF = (!TF); //흰색이면 블랙, 블랙이면 흰색
					}
					TF = (!TF); //다음줄에서는 다른 색으로 변경
				}
				min = Math.min(min, Math.min(count, 64-count));
		
			}
		}
		System.out.println(min);
		
		
		long last = System.currentTimeMillis();
		System.out.println(last-first);
	}

	
	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
		boolean TF = arr[x][y];	// 첫 번째 칸의 색 

		System.out.println(",___TF="+TF);

		System.out.println("   ,min0="+min);
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

				System.out.print(i+"___"+j);
				
				// 올바른 색이 아닐경우 count 1 증가 
				if (arr[i][j] != TF) {	
					count++;
				}
				System.out.print(",___count="+count);
				
				/* 
				 * 다음 칸은 색이 바뀌므로
				 * true라면 false로, false 라면 true 로
				 * 값을 변경한다.
				 */
				TF = (!TF);
				System.out.println(",___TF="+TF);
			}
			TF = (!TF);
		}
		
		/*
		 *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		 *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
		 */
			System.out.println("   ,min1="+min);
			System.out.println("   ,count1="+count);
		
		//count = Math.min(count, 64 - count);
			System.out.println("   Math.min1("+count+", "+(64 - count)+")="+count);	
		/*
		 * 이전까지의 경우 중 최솟값보다 현재 count 값이
		 * 더 작을 경우 최솟값을 갱신 
		 */
			System.out.println("   Math.min2("+min+", "+count+")="+min);
		min = Math.min(min, Math.min(count, 64 - count));
			System.out.println("   Math.min3("+min+", "+count+")="+min);
	}
}
