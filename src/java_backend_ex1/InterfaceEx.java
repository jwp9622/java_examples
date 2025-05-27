package java_backend_ex1;


//�������̽� ��������
interface PhoneInterface { // �������̽� ����
	final int TIMEOUT = 10000; // ��� �ʵ� ����
	void sendCall(); // �߻� �޼ҵ�
	void receiveCall(); // �߻� �޼ҵ�
	default void printLogo() { // default �޼ҵ�
		System.out.println("** Phone **");
	}
}
class Calc { // Ŭ���� �ۼ�
	public int calculate(int x, int y) { return x + y; } 
}

class SamsungPhone  extends Calc implements PhoneInterface { // �������̽� ���� // PhoneInterface�� ��� �޼ҵ� ����
	@Override
	public void sendCall() {
		System.out.println("�츮������");
	}
	@Override
	public void receiveCall() {
		System.out.println("��ȭ�� �Խ��ϴ�.");
	}
	// �޼ҵ� �߰� �ۼ�
	public void flash() { System.out.println("��ȭ�⿡ ���� �������ϴ�."); } 
	
	// �߰��� �ۼ��� �޼ҵ�
	public void schedule() { System.out.println("���� �����մϴ�."); }	
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
		System.out.println("3�� 5�� ���ϸ� " + phone.calculate(3, 5)); phone.schedule();
		
		
	} 
}
