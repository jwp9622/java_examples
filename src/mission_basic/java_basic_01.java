package mission_basic;
import java.util.Scanner;
public class java_basic_01 {
	public static void main(String[] args) {
		int input1 = 0;
		int input2 = 0;
		int max_num;
		String str;
		
		int total;
		String name;
		int old;
		name = "�ڴ���";
		old = 10;
				
		Scanner sc = new Scanner(System.in); //scanner ȣ��

		//ù���� ���� �Է� �ޱ�
		System.out.print(chkMsg(1,"i"));
		str = sc.nextLine(); //�Է³��� �޾ƿ���
		
		try {
			while(true) {
				if(inNumeric(str) == false) { //���ڰ� �ƴϸ�
					System.out.println(chkMsg(1,"e"));
					System.out.print(chkMsg(1,"i"));
					str = sc.nextLine(); //���� �ٽ� �ޱ�
				}else {	//�����̸�
					input1 = Integer.parseInt(str); //�����̸� ���������� ��ȯ
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		//ù���� ���� �Է� �ޱ�
		System.out.print(chkMsg(2,"i"));
		str = sc.nextLine(); //�Է³��� �޾ƿ���
		
		try {
			while(true) {
				if(inNumeric(str) == false) { //���ڰ� �ƴϸ�
					System.out.println(chkMsg(2,"e"));
					System.out.print(chkMsg(2,"i"));
					str = sc.nextLine(); //���� �ٽ� �ޱ�
				}else {	//�����̸�
					input2 = Integer.parseInt(str); //�����̸� ���������� ��ȯ
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		sc.close();  //scanner �ݱ�
		
		max_num = (input1 > input2) ? input1:input2;
		System.out.println("���� ū���� \""+max_num+"\" �����Դϴ�");
		
		total = input1+input2;
		System.out.println("�� ���� �հ�� \""+total+"\" �Դϴ�");
		
		System.out.println("�̸��� "+ name+" �Դϴ�");
		System.out.println("���̴� "+ old+"�� �Դϴ�");
	}
	public static String chkMsg(int num, String cate) {
		String alert_msg = "���ڸ� �Է°����մϴ�!! ";
		String info_msg = "��° ���ڸ� �Է��ϼ��� : ";
		String str = "";
			
		if (cate == "i") {
			str = num+info_msg;
		}else {
			str = alert_msg;
		}
		return str;
	}
	public static boolean inNumeric(String s){
		
		//���Խ� - ���ڿ� ���� üũ�Ҷ� ���
		/********�ڹ� ���Խ� ************
		 * [+-]?\\d+ --> ����üũ
		 * [] : ��ȣ ���� ���ڰ� �ִ����� Ȯ��
		 * + : �ϳ� �Ǵ� ���� �ݺ�
		 * - : ���� ���� ����
		 * ? : ���� �Ǵ� 1���̻�
		 * \\d+ : ���ڰ� 1���̻�
		 *
		 */
		/*
		 * replaceAll ���ڿ��� ��ȯ
		 * equals���� �����ִ��� üũ
		 * 
		 * [] : ��ȣ ���� ���ڰ� �ִ����� Ȯ��
		 * + : ���ڰ� ���ڰ� ������ �ü� �ִ�. �ϳ� �Ǵ� ���� �ݺ�
		 * - : ���� ���� ����
		 * ? : ���� �Ǵ� 1���̻�
		 * \\d+ : ���ڰ� 1���̻�
		 * replaceAll���� [+-]��ȣ�ȿ� 1���̻��� ��� ���ڹ�������, 
		 * ?�¾��� ��Ұ� 1���̻� �����߿��� 
		 * \\d �� ���ڸ� ã�Ƽ� ""�������� ġȯ�Ѵ�.
		 * \d �����ε�, �ڹٿ����� �ٸ��� ����ؼ� \\�� 2�� ���δ�.
		 */
		return s.replaceAll("[+-]?\\d+","").equals("") ? true : false; //���Խ�, ���ڿ����� ���ڸ� ���ش�.
		
	}	
}



