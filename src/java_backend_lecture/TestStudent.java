package java_backend_lecture;


public class TestStudent { //����Ŭ����

	public static void main(String[] args) { //�ݷ��޼ҵ�

		int val = 3;
		int i;
		int j;
		
		//if ��
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
		
		//���� ������
		String str ="";
		str = (val ==1) ? "1" :
			  (val ==2) ? "2" :
		      (val ==2) ? "2" :"";
		System.out.println("���׿����� : "+str);
		
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
		
		//class , ��ŷŬ����, �ݸ�Ŭ����
		Student cls = new Student("�質��"); //�ݸ�Ŭ����
		cls.setNumber(2025);
		cls.setOld(20);
		System.out.println("class name: "+cls.getName());
		
		//�޼ҵ� �����ε�
		cls.doService(); //�Ű����� ����
		cls.doService("ȫ�浿"); //�Ű����� 1�� ����.
		
		System.out.println("class name: "+cls.getName());
		System.out.println("class number: "+cls.getNumber());
		System.out.println("class old: "+cls.getOld());
	}
}


class Student{ //��ŷ �޼ҵ�

	int number; //����ʵ�
	String name; 
	int old; //����ʵ�
	
	//������, ���� �ʱ�ȭ, ����Ÿ��, �Ķ���� ����.
	//�����ڿ����� privat ���ȵ�.
	//�⺻ ������
	Student(){
	}
	//�Ϲ� ������
	Student(String name){
		this.name = name;
	}	
	
	//��� �޼ҵ�
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

	//����޼ҵ� �����ε�
	void doService() { 
		System.out.println("doService �Ű����� : ����");
	}
	//����޼ҵ� �����ε�, �ߺ�����
	void doService(String name) { 
		System.out.println("doService �Ű����� : "+name);
	}
		
}



