package java_report;

public class FlowEx10 {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 10)+1;
		String msg = "";
		
		score *= 100;
		
		msg = "����� ������ "+ score+"�̰�, ��ǰ�� ";
		
		msg += (score >= 1000) ? "������, ":
			   (score >= 900) ? "TV":
			   (score >= 800) ? "��Ʈ��":
			   (score >= 700) ? "������": "����";

		System.out.println(msg+" �Դϴ�.");
	
	}
}



/*
		
		

		if(score >= 1000) {
			msg += "������, ";
		}else if(score >= 900) {
			msg += "TV, ";
		}else if(score >= 800) {
			msg += "��Ʈ��, ";
		}else if(score >= 700) {
			msg += "������";
		}else {
			msg += "����";
		}
				
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
		}
		
 */