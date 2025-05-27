package java_backend_ex1;

class Person { }
class Student extends Person { }
class Researcher extends Person { }
class Professor extends Researcher { }
	
//��ӿ��� Ȯ��
public class InstanceOfEx {
	
	static void print(Person p) {
		//Person �ȿ� p�� �ִ��� Ȯ��
		if(p instanceof Person) 
			System.out.print("Person ");
		
		if(p instanceof Student) 
			System.out.print("Student ");
		
		if(p instanceof Researcher) 
			System.out.print("Researcher ");
		
		if(p instanceof Professor) 
			System.out.print("Professor ");
		
		System.out.println();
	}
	//instanceof ��ӿ��� Ȯ��
	//
	public static void main(String[] args) {
		System.out.print("new Student() -> ");    
		print(new Student()); 
		
		System.out.print("new Researcher() -> "); 
		print(new Researcher()); 
		
		System.out.print("new Professor() -> ");   
		print(new Professor());
	} 
	
	
}