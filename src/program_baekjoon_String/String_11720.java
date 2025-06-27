package program_baekjoon_String;

import java.io.*;
import java.util.*;

//백준 11720, 숫자의 합
public class String_11720{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int num = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        String array[] = str.split("");
        
        int total = 0;
        for(int i=0;i<array.length;i++) {
        	total += Integer.parseInt(array[i]);
        }
        bw.write(total+"");
        bw.flush();
        bw.close();
        
    }
}

