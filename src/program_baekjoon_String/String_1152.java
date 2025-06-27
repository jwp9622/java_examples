package program_baekjoon_String;

import java.io.*;
import java.util.*;

//백준 1152, 단어의 개수
public class String_1152{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine()," ");
        
        System.out.println(st.countTokens());
        
    }
}

