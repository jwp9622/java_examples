package program_baekjoon;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class turret_2{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str =  bf.readLine();
		int a = Integer.parseInt(str);
				 
        int result= 0;
        while(a>0){
        	String str_x1 = bf.readLine();
        	String str_y1 = bf.readLine();
        	String str_r1 = bf.readLine();
        	String str_x2 = bf.readLine();
        	String str_y2 = bf.readLine();
        	String str_r2 = bf.readLine();

            int x1 = Integer.parseInt(str_x1);
            int y1 = Integer.parseInt(str_y1);
            int r1 = Integer.parseInt(str_r1);
            int x2 = Integer.parseInt(str_x2);
            int y2 = Integer.parseInt(str_y2);
            int r2 = Integer.parseInt(str_r2);
            
            result = point(x1,y1,r1,x2,y2,r2);
            System.out.println(result);
            a--;
        }
        bf.close();
        
    }
    public static int point(int x1, int y1, int r1, int x2, int y2, int r2){
        double d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        if(d ==0&& r1==r2){ 
            return -1; //무한이 많은 접점(동일한 원)
        }else if(d==r1+r2 || d == Math.abs(r1-r2)){
            return 1; //원이 외접, 내접
        }else if( Math.abs(r1-r2)<d && d<r1+r2 ){
            return 2; //두점이 인접
        }else{
            return 0; //만나지 않음
        }
	}
}