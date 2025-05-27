package java_backend_ex1;


//인터페이스 연습문제
interface PhoneInterface { // 인터페이스 선언
	final int TIMEOUT = 10000; // 상수 필드 선언
	void sendCall(); // 추상 메소드
	void receiveCall(); // 추상 메소드
	default void printLogo() { // default 메소드
		System.out.println("** Phone **");
	}
}
class Calc { // 클래스 작성
	public int calculate(int x, int y) { return x + y; } 
}

class SamsungPhone  extends Calc implements PhoneInterface { // 인터페이스 구현 // PhoneInterface의 모든 메소드 구현
	@Override
	public void sendCall() {
		System.out.println("띠리리리링");
	}
	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다.");
	}
	// 메소드 추가 작성
	public void flash() { System.out.println("전화기에 불이 켜졌습니다."); } 
	
	// 추가로 작성한 메소드
	public void schedule() { System.out.println("일정 관리합니다."); }	
}

public class InterfaceEx {
	public static void main(String[] args) { 
		SamsungPhone phone = new SamsungPhone(); 
		phone.printLogo();
		phone.sendCall(); 
		phone.receiveCall(); 
		phone.flash();
		
		phone.printLogo();
		phone.sendCall();
		System.out.println("3과 5를 더하면 " + phone.calculate(3, 5)); phone.schedule();
		
		
	} 
}
