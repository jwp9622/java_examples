package java_report;

public class FlowEx08 {

	public static void main(String[] args) {
		int score = 5;
		int val = score*100;

		String msg = "";
		msg = (val == 100) ? "����� ������ 100�̰�, ��ǰ�� �������Դϴ�.":
			  (val == 200) ? "����� ������ 200�̰�, ��ǰ�� �Դϴ�.":
			  (val == 300) ? "����� ������ 300�̰�, ��ǰ�� ��Ʈ���Դϴ�.":
			  (val == 400) ? "����� ������ 400�̰�, ��ǰ�� �ڵ����Դϴ�.":"�˼������� ����� ������ �ش��ǰ�� �����ϴ�.";
		System.out.println(msg);
	
	}
}


/*
		
		if(val == 100) {
			System.out.println("����� ������ 100�̰�, ��ǰ�� �������Դϴ�.");
		}else if(val == 200) {
			System.out.println("����� ������ 200�̰�, ��ǰ�� TV�Դϴ�.");
		}else if(val == 300) {
			System.out.println("����� ������ 300�̰�, ��ǰ�� ��Ʈ���Դϴ�.");
		}else if(val == 400) {
			System.out.println("����� ������ 400�̰�, ��ǰ�� �ڵ����Դϴ�.");
			System.out.println("�˼������� ����� ������ �ش��ǰ�� �����ϴ�.");
		}	
		
		
		switch(score*100) {
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
				System.out.println("����� ������ 400�̰�, ��ǰ�� �ڵ����Դϴ�.");
				System.out.println("�˼������� ����� ������ �ش��ǰ�� �����ϴ�.");
				break;
		}
		
 */