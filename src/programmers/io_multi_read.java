package programmers;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class io_multi_read {
	public static void main(String[] args) {
		//data.txt���� ���� �б�
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
        //data.txt�κ��� int�� 3���� �о�鿩�� sum�� ���ϼ���.
        try(
            DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
        ){
            int i = in.readInt();
        }catch(Exception e){
            e.printStackTrace();  
        }		
		
		
	}
}
