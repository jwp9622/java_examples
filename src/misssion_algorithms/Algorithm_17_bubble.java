package misssion_algorithms;

import java.io.IOException;
import java.util.Arrays;

//	17	버블 정렬 알고리즘 구현하기
//백준 1383번 문제
public class Algorithm_17_bubble {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//버블정렬
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//int N = Integer.parseInt(bf.readLine());
		
		int A[] = {45,66,34,10, 42,44};
		
		//StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		//for(int i=0;i<N;i++) {
		//	A[i] = Integer.parseInt(st.nextToken());
		//}

		int flag = 0;
		int temp = 0;
		int i, j;
			
		for (i=0; i<A.length; i++) {
		    flag = 0;
		    for (j=0; j<A.length-1; j++) {
		        if (A[j] > A[j+1]) {
		            flag = 1;
		            temp = A[j];
		            A[j] = A[j+1];
		            A[j+1] = temp;
		        }
		    }
		    if (flag == 0) {
		        break;
		    }
		}	
		System.out.println(Arrays.toString(A));
		
		
		//long last_time = System.currentTimeMillis();
		//System.out.println((last_time-first_time));
		
		
		//선택정렬
	}
	
}
