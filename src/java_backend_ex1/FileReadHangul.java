package java_backend_ex1;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


//Ű����� �Է¹ް� ���
public class FileReadHangul {

// InputStreamReader�� �̿��Ͽ� MS949 ���� �������� �ѱ� �ؽ�Ʈ ������ �а� ����϶�.
	
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("d:\\hangul.txt");
			in = new InputStreamReader(fin, "MS949"); 
			int c;
			System.out.println("���ڵ� ���� ������ " + in.getEncoding()); 

			//���� ����
			FileOutputStream out = new FileOutputStream("d:\\hangul.txt");
			Scanner sc = new Scanner(System.in);
			while(true) {

				System.out.println("���ڸ� �Է��ϼ���>>>"); 				
				String line = sc.nextLine();
				
				if(line.length() ==0)
					break;
				
				byte[] bbb = line.getBytes();
				out.write(bbb);
			}
			
			
			//���� �б�
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			sc.close();
			out.close();
			
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("����� ����"); 
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
			out.flush(); // ���ۿ� ���� �ִ� ���� ��� ��� fin.close();
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		
		

	}
}
