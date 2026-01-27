package d0127_2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateTest {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		
		LocalDate date1 = LocalDate.of(2025, 12, 29);
		
		
		// 만난지 며칠 - until() 사용
		long betweenDays = date1.until(date, ChronoUnit.DAYS);
		System.out.println("betweenDays: " + betweenDays);
		
		// 만난지 며칠 - ChronoUnit.DAYS.beween() 사용
		long betweenDays2 = ChronoUnit.DAYS.between(date, date1);
		System.out.println("betweenDays: " + betweenDays2);
		
		LocalDate birth = LocalDate.of(2002, 11, 1);
		LocalDate now = LocalDate.now();
		
		Period age = Period.between(birth, now);
		System.out.println("age: " + age);
		System.out.println("=======================");
		System.out.println(age.getYears() + "년");
		System.out.println(age.getMonths() + "월");
		System.out.println(age.getDays() + "일");
		System.out.println("살았습니다.");
		
		System.out.println("=======================");
		Instant start = Instant.now();
		System.out.println("start: " + start);
		
	}
}

