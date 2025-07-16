package program_baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알고리즘 수업 - 피보나치 수 1 / 244416
public class DP_fibonaci_24416 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int fibo_re = fibo_re(N);
		int fibo_dp = fibo_dp(N);
		System.out.println(fibo_re +" "+fibo_dp);
	}

	//재귀함수 호출
	public static int fibo_re(int n) {
		if(n ==1 || n == 2) {
			return 1;
		}else {
			System.out.println("n="+n+"__"+(n-1)+"__"+(n-2));
			//n=5__4__3
			//n=4__3__2
			//n=3__2__1
			//n=3__2__1
			
			return fibo_re(n-1)+fibo_re(n-2);
					
		}
	}
	
	//동적 알고리즘
	public static int fibo_dp(int n) {
		int[] array = new int[n+1];
		int count = 0;
		if(n ==1 || n == 2) {
			return 1;
		}else {
			for(int i=3;i<=n;i++) {
				//System.out.println("i="+i+"__"+array[i-1]+"__"+array[i-2]);
				array[i] = array[i-1] +array[i-2];
				count++;
			}
			//i=3__0__0
			//i=4__0__0
			//i=5__0__0
					
		}		
		return count;
	}
}
