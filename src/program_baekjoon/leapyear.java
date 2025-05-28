package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leapyear {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        
        int b = 0;
        if((a%4)==0 && ((a%100)!=0 || (a%400)==0))
            b = 1;
        System.out.println(b);

	}

}
