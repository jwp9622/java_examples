package java_report;

public class FlowEx12 {

	public static void main(String[] args) {
		int score = (int)(Math.random()*10)+1;

		int val = score*100;

		String msg;
		msg = (val == 100) ? "����� ������ 100�̰�, ��ǰ�� �������Դϴ�.":
			  (val == 200) ? "����� ������ 200�̰�, ��ǰ�� �������Դϴ�.":
			  (val == 300) ? "����� ������ 300�̰�, ��ǰ�� �������Դϴ�.":
			  (val == 400) ? "����� ������ 400�̰�, ��ǰ�� �������Դϴ�.": "�˼������� ����� ������ �ش��ϴ� ��ǰ�� �����ϴ�.";
		
		System.out.println(msg);
	}

}
