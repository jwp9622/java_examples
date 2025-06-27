package program_baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// X보다 작은 수
public class Arrays_10871_bufferReader_bufferWriter {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//정수입력
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		//배열 선언
		int array[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		//공백 정수 배열 넣기
		for(int i=0;i<array.length;i++) {
			array[i]= Integer.parseInt(st.nextToken());
			if(array[i] <X) {
				bw.write(array[i]+" ");
			}
		}
		bw.flush();
		bw.close();
		
	}

}
