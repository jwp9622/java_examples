package java_report;

public class FlowEx06 {

	public static void main(String[] args) {
		
		char ch = (char)(Math.random() * 4+'A');
		int score = 0;

		if(ch =='A') {
			score = 90;
		}else if(ch =='B') {
			score = 80;
		}else if(ch =='C') {
			score = 70;
		}else if(ch =='D') {
			score = 60;
		}
		
		System.out.println("당신의 학점은 "+score+"점 이상 입니다.");

	}

}



/*
switch(score) {
	case 'A':
		score = 90;
		break;
	case 'B':
		score = 80;
		break;
	case 'C':
		score = 70;
		break;
	case 'D':
		score = 60;
		break;
}	
*/
