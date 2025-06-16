package program_baekjoon;
import java.util.*;
import java.io.*;

public class repeat_a_b {
    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int b = 0;
        int c = 0;
        int sum =0;
        String str = "";
        
        while((str=bf.readLine()) != null){
        	if(str == null) {
        		break;
        	}else {
	            st = new StringTokenizer(str, " ");
	            b = Integer.parseInt(st.nextToken());
	            c = Integer.parseInt(st.nextToken());
	            sum = b+c;
	            bw.write(sum+"\n");
        	}
        }
        bw.flush();
        
        
    }
}