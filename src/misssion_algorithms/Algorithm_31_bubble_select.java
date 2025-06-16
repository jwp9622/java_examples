package misssion_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//31	정렬알고리즘(버블정렬,선택정렬등)구현하기
public class Algorithm_31_bubble_select {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//버블정렬
		int A[] = {45, 66, 34, 10, 42,44};
		int flag = 0;
		int temp = 0;
		int i, j;
		
		for (i=0; i<A.length; i++) {
		    //flag = 0;
		    for (j=0; j<A.length-1; j++) {
		        if (A[j] > A[j+1]) {
		            temp = A[j];
		            A[j] = A[j+1];
		            A[j+1] = temp;
		        }
		    }
		    if (flag == 0) {
		       //break;
		    }
		}	
		System.out.println(Arrays.toString(A));
		

		//선택정렬
		int B[] = {25, 6, 125, 45, 78, 56, 2 ,7};
		i = 0;
		j = 0;
		temp = 0;
		for(i=0;i<B.length-1; i++) {
			int minIdx = i;
			for(j=i+1;j<B.length;j++) {
				if(B[minIdx] > B[j]){
					minIdx =j;
				}
			
			}
            temp = B[i];
            B[i] = B[minIdx];
            B[minIdx] = temp;
	        
		}
		System.out.println(Arrays.toString(B));
		
	}
	public static int swap(int a, int b){
		int temp = 0;
		temp = a;
		a = b;
		a = temp;
		return a;
	}
}
