package java_report;

public class FlowEx12 {

	public static void main(String[] args) {
		int score = (int)(Math.random()*10)+1;

		int val = score*100;

		String msg;
		msg = (val == 100) ? "당신의 점수는 100이고, 상품은 자전거입니다.":
			  (val == 200) ? "당신의 점수는 200이고, 상품은 자전거입니다.":
			  (val == 300) ? "당신의 점수는 300이고, 상품은 자전거입니다.":
			  (val == 400) ? "당신의 점수는 400이고, 상품은 자전거입니다.": "죄송하지만 당신의 점수에 해당하는 상품이 없습니다.";
		
		System.out.println(msg);
	}

}
