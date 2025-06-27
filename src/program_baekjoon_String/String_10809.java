package program_baekjoon_String;

import java.io.*;
import java.util.*;

//백준 10809, 알파벳 찾기
public class String_10809{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int alpha_num[] = new int[alphabet.length];
        
        String str = br.readLine();
        
        for(int i=0;i<alphabet.length;i++) {
        	int temp = str.indexOf(alphabet[i]);
        	alpha_num[i] = (temp >=0) ?  temp : -1;
        	sb.append(alpha_num[i]+" ");
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
        
    }
}

