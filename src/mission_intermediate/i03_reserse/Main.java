package mission_intermediate.i03_reserse;

import java.util.Scanner;

/*
 * �ڹ��߱� - 3.���ڿ� ������ �� ��ҹ��� ��ȯ ���α׷� �ۼ��ϱ�
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		
		//���� �Է¹ޱ�
		GetText gt = new GetText();
		str = gt.GetTextInput();
		
		//���� ������, ��ҹ��� ��ȯ
		if(!str.equals("")) {
			Reverse r = new Reverse();
			r.setOri_str(str);
			r.reverse();
			System.out.println("������ ���� : "+ r.getResult());
		}
				
	}		
}