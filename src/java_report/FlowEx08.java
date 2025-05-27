package java_report;

public class FlowEx08 {

	public static void main(String[] args) {
		int score = 5;
		int val = score*100;

		String msg = "";
		msg = (val == 100) ? "당신의 점수는 100이고, 상품은 자전거입니다.":
			  (val == 200) ? "당신의 점수는 200이고, 상품은 입니다.":
			  (val == 300) ? "당신의 점수는 300이고, 상품은 노트북입니다.":
			  (val == 400) ? "당신의 점수는 400이고, 상품은 자동차입니다.":"죄송하지만 당신의 점수에 해당상품이 없습니다.";
		System.out.println(msg);
	
	}
}


/*
		
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
				System.out.println("죄송하지만 당신의 점수에 해당상품이 없습니다.");
				break;
		}
		
 */