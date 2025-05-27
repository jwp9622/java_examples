package programmers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {
	public static void main(String[] args) {
		
		//date
		Date date = new Date();
		System.out.println(date.toString());
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		
		System.out.println(ft.format(date));
		System.out.println(date.getTime());
		
		long today = System.currentTimeMillis();
		System.out.println(today);
		System.out.println(today-date.getTime());
		
		System.out.println("------------------------");
		
		//calendar - �߻�Ŭ����(�̿ϼ��� �޼ҵ�, Ŭ���� new �����ȵ�)
		//Calendar�� ������ ������ �ȵǹǷ� getInstance�� ȣ���ؼ� ���
		//Calnedar ȣ��� Gregorian Calendar ���� getInstance�� �ν��Ͻ��� ������ ���ش�.
		//������ �ϳ��� �̷��� ���ο� ������ �޷��� ǥ���� �ɼ� �ֱ⶧���� �����̵�� ����
		//calendar �� ����� ���Ƽ� ��� ��� ����.
		Calendar cal = Calendar.getInstance(); //calendar ȣ���Ͽ� ��� ����.
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1); //�ڹٴ� ���� 0~11����ǥ��, ���� 1���ؾ���.
		System.out.println(cal.get(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.HOUR)); //�ð��� 12���� ǥ��
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); //�ð��� 24���� ǥ��
		System.out.println(cal.get(Calendar.MINUTE)); //��
		System.out.println(cal.get(Calendar.SECOND)); //��
		
		cal.add(Calendar.HOUR, 5); //5�ð� �������� �ǵ�����.���ϴ� �ð����� �ǵ����� ����.
		
		System.out.println("------------------------");
		
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE,10);
        int year = cal2.get(cal2.YEAR);
        int month = cal2.get(cal2.MONTH)+1;
        int day = cal2.get(cal2.DATE);
        int hour = cal2.get(cal2.HOUR_OF_DAY);
        
        StringBuffer sb = new StringBuffer();
        sb.append(year).append("��").append(month).append("��").append(day).append("��");
        String next_date = String.valueOf(sb);
        System.out.println(next_date);
        

        Calendar cal3 = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyy'��'MM'��'dd'��'");
        System.out.println("���� ��¥="+f.format(cal3.getTime()));
        cal3.add(Calendar.DAY_OF_YEAR, 100);
        System.out.println("100���� ��¥="+f.format(cal3.getTime()));
       
        
        
        
        Calendar cal4 = Calendar.getInstance();
            
        SimpleDateFormat ff = new SimpleDateFormat("yyyy'��'MM'��'dd'��'");
        next_date = f.format(cal4.getTime());
        System.out.println("100���� ��¥="+next_date);
        
        
        
        
        
        
        
		
	}
}
