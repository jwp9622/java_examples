package java_report;

public class FlowEx15 {

	public static void main(String[] args) {
		
		int score = 88;
		char grade = ' ';

		int avg = score/10;
		
		if(avg >= 10) {
			grade = ' ';			
		}else if(avg >=9) {
			grade = 'A';
		}else if(avg >=8 ) {
			grade = 'B';
		}else if(avg >=7) {
			grade = 'C';
		}else if(avg >=6) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.println("당신의 학점은 "+grade+"입니다.");
		
	}
}


/*
switch(score/10) {
	case 10:
	case 9:
		grade = 'A';
		break;
	case 8:
		grade = 'B';
		break;
	case 7:
		grade = 'C';
		break;
	case 6:
		grade = 'D';
		break;
	default:
		grade = 'F';
		break;
}
*/
