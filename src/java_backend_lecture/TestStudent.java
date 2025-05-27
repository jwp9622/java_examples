package java_backend_lecture;


public class TestStudent { //실행클래스

	public static void main(String[] args) { //콜레메소드

		int val = 3;
		int i;
		int j;
		
		//if 문
		System.out.print("if : ");
		if(false) {
			System.out.println("false");	
		}else if(true) {
			System.out.println("true");	
		}else {
			System.out.println("false");	
		}
		
		//switch
		System.out.print("switch : ");
		switch(val) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			default:
				System.out.println("null");
		}
		
		//삼항 연산자
		String str ="";
		str = (val ==1) ? "1" :
			  (val ==2) ? "2" :
		      (val ==2) ? "2" :"";
		System.out.println("삼항연산자 : "+str);
		
		//while
		i =0;
		while(i < val) {
			System.out.println("while i : "+i);
			i++;
		}
		
		//do-while
		i = 0;
		do {
			System.out.println("do while i : "+i);
			i++;
		}while(i < val);
		
		//for 
		for(i=0; i<val;i++) {
			System.out.println("for i : "+i);
		}
		
		//enhanced for
		int[] arry = {3,4,2,5,4,9};
		for(int num : arry) {
			System.out.println("enhanced for: "+num);
		}
		
		//class , 워킹클래스, 콜링클래스
		Student cls = new Student("김나라"); //콜링클래스
		cls.setNumber(2025);
		cls.setOld(20);
		System.out.println("class name: "+cls.getName());
		
		//메소드 오버로딩
		cls.doService(); //매개변수 없음
		cls.doService("홍길동"); //매개변수 1개 있음.
		
		System.out.println("class name: "+cls.getName());
		System.out.println("class number: "+cls.getNumber());
		System.out.println("class old: "+cls.getOld());
	}
}


class Student{ //워킹 메소드

	int number; //멤버필드
	String name; 
	int old; //멤버필드
	
	//생성자, 값의 초기화, 리턴타입, 파라미터 없음.
	//생성자에서는 privat 사용안됨.
	//기본 생성자
	Student(){
	}
	//일반 생성자
	Student(String name){
		this.name = name;
	}	
	
	//멤버 메소드
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}		

	//멤버메소드 오버로딩
	void doService() { 
		System.out.println("doService 매개변수 : 없음");
	}
	//멤버메소드 오버로딩, 중복정의
	void doService(String name) { 
		System.out.println("doService 매개변수 : "+name);
	}
		
}



