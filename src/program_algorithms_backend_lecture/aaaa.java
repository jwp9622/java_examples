package program_algorithms_backend_lecture;

import java.io.*;
import java.util.*;


public class aaaa{
    public static void main(String args[]) throws IOException{
    	/*
    	// 백준 9086번 문자열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        String array[] = new String[T];
        for(int i=0;i<T;i++) {
        	String str[] = br.readLine().split("");
        	String temp = str[0]+ str[str.length-1];
        	sb.append(temp);
        	if(i<T-1) sb.append("\n");
        }
        
        bw.write(sb+"");
        bw.flush();
        bw.close();
        */
    	
            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int suNo = Integer.parseInt(stringTokenizer.nextToken());
            int quizNo = Integer.parseInt(stringTokenizer.nextToken());

            long[] S = new long[suNo + 1];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 1; i <= suNo; i++) {
            	int aa = Integer.parseInt(stringTokenizer.nextToken());
                S[i] = S[i - 1] + aa;
            	System.out.println( S[i - 1] +"__"+aa+"__"+S[i]);
            }

            for (int q = 0; q < quizNo; q++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int i = Integer.parseInt(stringTokenizer.nextToken());
                int j = Integer.parseInt(stringTokenizer.nextToken());

            	System.out.println( j +"=="+ (i - 1) );
            	
                System.out.println(S[j] - S[i - 1]);
            }
    }
}