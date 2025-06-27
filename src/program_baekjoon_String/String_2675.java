package program_baekjoon_String;

import java.io.*;
import java.util.*;

//���� 2675, ���ڿ� �ݺ�
public class String_2675{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++) {
        	//�Է� �ޱ�
        	st = new StringTokenizer(br.readLine()," ");
        	int num = Integer.parseInt(st.nextToken());
        	String str = st.nextToken();
        	
        	//���ڿ� �ڸ���
        	String array[] = str.split("");
        	String array_result[] = new String[(array.length*array.length)];
        	
			//���ڿ� �ٽ� ���ڸ�ŭ �ֱ�
        	String result = "";
        	for(int j=0;j<array.length;j++) {
        		for(int k=j*num-1; k<((j*num)+num)-1; k++) {
        			result += array[j];
        		}
        	}
        	sb.append( result+"\n");
        	
        }
        
        bw.write(sb+"");
        bw.flush();
        bw.close();
        
    }
}

