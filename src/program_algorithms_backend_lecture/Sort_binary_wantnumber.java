package program_algorithms_backend_lecture;

import java.util.Arrays;
import java.util.Scanner;

/*
원하는 정수 구하기
입력
5
4 1 5 2 3 
5
1 3 7 9 5

 출력
 1
 1
 0
 0
 1
*/
public class Sort_binary_wantnumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			boolean find = false;
			int target = sc.nextInt();
			
			int start = 0;
			int end=A.length -1;
			
			while(start <= end) {
				int midi = (start+end)/2;
				int midV = A[midi];
				if(midV > target) {
					end = midi- 1;
				}else if(midV < target) {
					start = midi +1;
				}else {
					find = true;
					break;
				}
			}
			if(find) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
			
		}

	}

}
