package java_report;

public class FlowEx05 {

	public static void main(String[] args) {
		int score = (int)(Math.random() *10)+1;
		int val = score*100;
		
		if(val == 100) {
			System.out.println("����� ������ 100�̰�, ��ǰ�� �������Դϴ�.");
		}else if(val == 200) {
			System.out.println("����� ������ 200�̰�, ��ǰ�� TV�Դϴ�.");
		}else if(val == 300) {
			System.out.println("����� ������ 100�̰�, ��ǰ�� ��Ʈ���Դϴ�.");
		}else if(val == 400) {
			System.out.println("����� ������ 300�̰�, ��ǰ�� �ڵ����Դϴ�.");
		}else {
			System.out.println("�˼������� ����� ������ �ش��ǰ�� �����ϴ�.");
		}	
	}

}

/*
		
		switch(score*10) {
			case 100:
				System.out.println("����� ������ 100�̰�, ��ǰ�� �������Դϴ�.");
			case 200:
				System.out.println("����� ������ 200�̰�, ��ǰ�� TV�Դϴ�.");
				break;
			case 300:
				System.out.println("����� ������ 100�̰�, ��ǰ�� ��Ʈ���Դϴ�.");
				break;
			case 400:
				System.out.println("����� ������ 300�̰�, ��ǰ�� �ڵ����Դϴ�.");
				break;
			default:
				System.out.println("�˼������� ����� ������ �ش��ǰ�� �����ϴ�.");
				break;
		}
		
 */