package programmers;

import java.lang.reflect.Method;

public class MyHelloExam {
	public static void main(String[] args) {
		MyHello hello = new MyHello();
		try {
			Method method= hello.getClass().getDeclaredMethod("hello");
			if(method.isAnnotationPresent(Count100.class)) {
				for(int i=0;i<100;i++) {
					hello.hello();
				}
			}else {
				hello.hello();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
