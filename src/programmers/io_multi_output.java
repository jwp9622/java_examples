package programmers;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class io_multi_output {
	public static void main(String[] args) {
		//data.txt�� ���� ���پ� ����
		try(
				DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"))
		){
			out.writeInt(100);
			out.writeBoolean(false);
			out.writeDouble(50.5);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
