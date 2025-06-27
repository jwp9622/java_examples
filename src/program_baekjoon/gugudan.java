package program_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(bf.readLine());
        StringBuffer sf = new StringBuffer();
        for(int i=1;i<=9;i++){
            sf.append(a).append("*").append(i).append("=").append(i*a).append("\n");
        }
        System.out.println(sf.toString());
        
        char aa = 'a';
        System.out.println((int)aa);
	}

}
