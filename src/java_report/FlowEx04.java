package java_report;

public class FlowEx04 {

	public static void main(String[] args) {
		int score = 82;
		String grade = "";
		
		System.out.println("����� ������ "+score+"�Դϴ�.");
		grade = (score>=90) ? 'A' + ((score>=98) ? "+" : (score>=94) ? "-":"") : 
				(score>=80) ? 'B' + ((score>=88) ? "+" : (score>=84) ? "-":"") : "C";
		
		System.out.println("����� ������ "+grade+"�� �̻� �Դϴ�.");
		
	}

}

/*
		if(score >=98) {
			grade = "A";
			if(score>=98) {
				grade += "+";
			}else if(score < 94) {
				grade += "-";
			}
		}else if(score >=80) {
			grade ="B";
			if(score >=88) {
				grade += "+";
			}else if(score < 84) {
				grade += "-";
			}
		}else {
			grade = "C";
		}

 */