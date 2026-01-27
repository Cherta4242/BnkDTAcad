package d0127_2;

import java.time.LocalDate;

public class LocalDateEx {
	
	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2024, 2, 27);
		LocalDate d2 = LocalDate.of(2026, 1, 27);
		LocalDate d3 = LocalDate.parse("2025-12-11");
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println("--------------------------");
		
		System.out.println(d1.getYear());	// 2024
		System.out.println(d1.getMonth());	// FABRUARY
		System.out.println(d1.getMonthValue());	// 2
		System.out.println(d1.getDayOfMonth());	// 27
		System.out.println(d1.getDayOfWeek());	// TUESDAY
		System.out.println(d1.getDayOfYear());	// 58
		System.out.println(d1.lengthOfMonth());	// 29
		System.out.println(d1.lengthOfYear());	// 366
		System.out.println(d1.isLeapYear());	// true
		
		System.out.println("--------------------------");
		System.out.println(d2.plusDays(1));
		System.out.println(d2.plusWeeks(1));
		System.out.println(d2.plusMonths(1));
		System.out.println(d2.plusYears(1));
		System.out.println();
		System.out.println(d2.minusDays(1));
		System.out.println(d2.minusWeeks(1));
		System.out.println(d2.minusMonths(1));
		System.out.println(d2.minusYears(1));
		System.out.println("--------------------------");
		
		//System.out.println(d2);
		System.out.println(d2.isBefore(d1));	// false
		System.out.println(d2.isAfter(d1));		// true
		System.out.println(d2.isEqual(d1));		// false
		System.out.println(d2.compareTo(d1));	// 양수
		System.out.println(d1.compareTo(d2));	// 음수
	}
}