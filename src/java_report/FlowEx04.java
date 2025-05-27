package java_report;

public class FlowEx04 {

	public static void main(String[] args) {
		int score = 82;
		String grade = "";
		
		System.out.println("당신의 점수는 "+score+"입니다.");
		grade = (score>=90) ? 'A' + ((score>=98) ? "+" : (score>=94) ? "-":"") : 
				(score>=80) ? 'B' + ((score>=88) ? "+" : (score>=84) ? "-":"") : "C";
		
		System.out.println("당신의 학점은 "+grade+"점 이상 입니다.");
		
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