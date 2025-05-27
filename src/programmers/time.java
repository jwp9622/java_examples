package programmers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class time {
	public static void main(String[] args) {
		//java.util.Date 사용시 월이 0부터 시작되는 등의 여러가지 문제 발생
		//자바 se8부터 제공됨.
		
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
		System.out.println("날짜="+timePoint.toLocalDate());
		
		System.out.println("시간="+timePoint.toLocalTime());
		System.out.println("년="+timePoint.getYear());
		System.out.println("월="+timePoint.getMonth());
		System.out.println("일="+timePoint.getDayOfMonth());
		System.out.println("일년중 몇일="+timePoint.getDayOfYear());
		
		System.out.println("시="+timePoint.getHour());
		System.out.println("분="+timePoint.getMinute());
		System.out.println("초="+timePoint.getSecond());
		
		
		
		
		
	}
}
