package program_baekjoon;

import java.util.Scanner;

public class plus {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result= 0;
        while(a>0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            result = point(x1,y1,r1,x2,y2,r2);
            System.out.println(result);
            a--;
        }
    }
    public static int point(int x1, int y1, int r1, int x2, int y2, int r2){
        double d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
       
        if(d ==0&& r1==r2){ 
            return -1; //무한이 많은 접점(동일한 원)
        }else if(d==r1+r2 || d == Math.abs(r1-r2)){
            return 1; //원이 외접, 내접
        }else if( Math.abs(r1-r2)<d && d<r1+r2 ){
            return 2;
        }else{
            return 0;
        }
	}
    
}
