package program_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class chess_test {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
       
        boolean arr[][] = new boolean[N][M];
        int min = 64;
        
        for(int i=0;i<N;i++){
            String str = bf.readLine();
            for(int j=0;j<M;j++){
                if(str.charAt(j) == 'W'){
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }
            }
        }
        int N_row = N-7;
        int M_col = M-7;
        for(int i=0;i<N_row;i++){
            for(int j=0;j<M_col;j++){
                
                boolean TF = arr[i][j];
                int count = 0;    
                for(int x=i;x<(i+8);x++){
                    for(int y=j;y<(j+8);y++){
                        if(arr[x][y]!=TF) count++; 
                        TF = (!TF);    
                    }
                        TF = (!TF); 
                }
                min = Math.min(min, Math.min(count, 64-count)); 
                
            }
        }
        System.out.println(min);
        
    }
}
