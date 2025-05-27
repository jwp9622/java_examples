package java_report;

public class FlowEx10 {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 10)+1;
		String msg = "";
		
		score *= 100;
		
		msg = "당신의 점수는 "+ score+"이고, 상품은 ";
		
		msg += (score >= 1000) ? "자전거, ":
			   (score >= 900) ? "TV":
			   (score >= 800) ? "노트북":
			   (score >= 700) ? "자전거": "볼펜";

		System.out.println(msg+" 입니다.");
	
	}
}



/*
		
		

		if(score >= 1000) {
			msg += "자전거, ";
		}else if(score >= 900) {
			msg += "TV, ";
		}else if(score >= 800) {
			msg += "노트북, ";
		}else if(score >= 700) {
			msg += "자전거";
		}else {
			msg += "볼펜";
		}
				
		if(val == 100) {
			System.out.println("당신의 점수는 100이고, 상품은 자전거입니다.");
		}else if(val == 200) {
			System.out.println("당신의 점수는 200이고, 상품은 TV입니다.");
		}else if(val == 300) {
			System.out.println("당신의 점수는 300이고, 상품은 노트북입니다.");
		}else if(val == 400) {
			System.out.println("당신의 점수는 400이고, 상품은 자동차입니다.");
			System.out.println("죄송하지만 당신의 점수에 해당상품이 없습니다.");
		}	
		
		
		switch(score*100) {
			case 100:
				System.out.println("당신의 점수는 100이고, 상품은 자전거입니다.");
			case 200:
				System.out.println("당신의 점수는 200이고, 상품은 TV입니다.");
				break;
			case 300:
				System.out.println("당신의 점수는 100이고, 상품은 노트북입니다.");
				break;
			case 400:
				System.out.println("당신의 점수는 300이고, 상품은 자동차입니다.");
				break;
			default:
				System.out.println("당신의 점수는 400이고, 상품은 자동차입니다.");
		}
		
 */