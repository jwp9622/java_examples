package programmers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class time {
	public static void main(String[] args) {
		//java.util.Date ���� ���� 0���� ���۵Ǵ� ���� �������� ���� �߻�
		//�ڹ� se8���� ������.
		
		LocalDateTime timePoint = LocalDateTime.now();
		System.out.println(timePoint);

		LocalDateTime ldd = LocalDateTime.of(2012, Month.DECEMBER , 12,11,20);
		System.out.println(ldd);
		
		
		
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER , 12);
		System.out.println(ld1);
		
		
		LocalTime lt1 = LocalTime.of(17, 18,16);
		System.out.println(lt1);
		
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
		
		
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);
		Month month = timePoint.getMonth();
		System.out.println(timePoint.toLocalTime());
		System.out.println(timePoint.getMonth());
		System.out.println(month.getValue());
		
		System.out.println("--------------------------------");
		System.out.println("��¥="+timePoint.toLocalDate());
		
		System.out.println("�ð�="+timePoint.toLocalTime());
		System.out.println("��="+timePoint.getYear());
		System.out.println("��="+timePoint.getMonth());
		System.out.println("��="+timePoint.getDayOfMonth());
		System.out.println("�ϳ��� ����="+timePoint.getDayOfYear());
		
		System.out.println("��="+timePoint.getHour());
		System.out.println("��="+timePoint.getMinute());
		System.out.println("��="+timePoint.getSecond());
		
		
		
		
		
	}
}
