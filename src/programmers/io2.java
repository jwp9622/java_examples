package programmers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class io2 {
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		 FileInputStream fis = null;
		 FileOutputStream fos = null;
		 
		 try {
				fis = new FileInputStream("src/programmers/io.java");
				fos = new FileOutputStream("byte2.txt");
				
				int readCount = -1;
				byte[] buffer = new byte[512];
				//수행시간 줄어듬.
				while((readCount = fis.read(buffer)) != -1){
					fos.write(buffer, 0, readCount);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		 
		 long engTime = System.currentTimeMillis();
		 System.out.println(engTime-startTime);
		 
	}
}
