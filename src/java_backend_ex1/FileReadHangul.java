package java_backend_ex1;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


//키보드로 입력받고 출력
public class FileReadHangul {

// InputStreamReader를 이용하여 MS949 문자 집합으로 한글 텍스트 파일을 읽고 출력하라.
	
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("d:\\hangul.txt");
			in = new InputStreamReader(fin, "MS949"); 
			int c;
			System.out.println("인코딩 문자 집합은 " + in.getEncoding()); 

			//파일 쓰기
			FileOutputStream out = new FileOutputStream("d:\\hangul.txt");
			Scanner sc = new Scanner(System.in);
			while(true) {

				System.out.println("문자를 입력하세요>>>"); 				
				String line = sc.nextLine();
				
				if(line.length() ==0)
					break;
				
				byte[] bbb = line.getBytes();
				out.write(bbb);
			}
			
			
			//파일 읽기
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			sc.close();
			out.close();
			
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류"); 
		}
		
		
		//buffer outstream
		try {
			FileReader fr = null;
			int c;
			
			fr = new FileReader("d:\\hangul.txt"); 
			BufferedOutputStream out = new 
			BufferedOutputStream(System.out, 5); 
			while ((c = fr.read()) != -1) { 
				out.write(c);
			}
			out.flush(); // 버퍼에 남아 있던 문자 모두 출력 fin.close();
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		
		

	}
}
