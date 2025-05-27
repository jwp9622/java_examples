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
		
		//calendar - 추상클래스(미완성된 메소드, 클래스 new 생성안됨)
		//Calendar가 스스로 리턴이 안되므로 getInstance를 호출해서 사용
		//Calnedar 호출시 Gregorian Calendar 에서 getInstance를 인스턴스를 리턴을 해준다.
		//이유중 하나는 미래의 새로운 형식의 달력이 표준이 될수 있기때문에 업데이드시 유리
		//calendar 를 상수가 많아서 상수 사용 가능.
		Calendar cal = Calendar.getInstance(); //calendar 호출하여 사용 가능.
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1); //자바는 월을 0~11까지표시, 월은 1더해야함.
		System.out.println(cal.get(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.HOUR)); //시간을 12까지 표현
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); //시간을 24까지 표현
		System.out.println(cal.get(Calendar.MINUTE)); //분
		System.out.println(cal.get(Calendar.SECOND)); //초
		
		cal.add(Calendar.HOUR, 5); //5시간 이전으로 되돌려줌.원하는 시간으로 되돌릴수 있음.
		
		System.out.println("------------------------");
		
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE,10);
        int year = cal2.get(cal2.YEAR);
        int month = cal2.get(cal2.MONTH)+1;
        int day = cal2.get(cal2.DATE);
        int hour = cal2.get(cal2.HOUR_OF_DAY);
        
        StringBuffer sb = new StringBuffer();
        sb.append(year).append("년").append(month).append("월").append(day).append("일");
        String next_date = String.valueOf(sb);
        System.out.println(next_date);
        

        Calendar cal3 = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyy'년'MM'월'dd'일'");
        System.out.println("현재 날짜="+f.format(cal3.getTime()));
        cal3.add(Calendar.DAY_OF_YEAR, 100);
        System.out.println("100일후 날짜="+f.format(cal3.getTime()));
       
        
        
        
        Calendar cal4 = Calendar.getInstance();
            
        SimpleDateFormat ff = new SimpleDateFormat("yyyy'년'MM'월'dd'일'");
        next_date = f.format(cal4.getTime());
        System.out.println("100일후 날짜="+next_date);
        
        
        
        
        
        
        
		
	}
}
