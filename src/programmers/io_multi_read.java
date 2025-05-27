package programmers;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class io_multi_read {
	public static void main(String[] args) {
		//data.txt에서 파일 읽기
		try(  
			DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
		){
			int i = in.readInt();
			boolean b = in.readBoolean();
			double d = in.readDouble();
			System.out.println(i);
			System.out.println(b);
			System.out.println(d);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		////////////////////////////////
        int sum = 0;
        //data.txt로부터 int값 3개를 읽어들여서 sum에 더하세요.
        try(
            DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
        ){
            int i = in.readInt();
        }catch(Exception e){
            e.printStackTrace();  
        }		
		
		
	}
}
