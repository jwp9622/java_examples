package program_algorithms_backend_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//연속된자연수의 합
/*
입력 
15

출력
4

*/
public class Pointer_NaturalNum_sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while(end_index != N) {
			if(sum ==N) {
				count++;
				end_index++;
				sum = sum + end_index;
			}else if(sum > N) {
				sum = sum - start_index;
				start_index++;
			}else {
				end_index++;
				sum=sum+end_index;
			}
		}
		System.out.println(count);
		 

	}

}
