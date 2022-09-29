package Hello.HelloDate;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
/*
Все объекты классов пакета java.time имеют свойство immutable - их нельзя изменить после создания.

 */

public class HelloLocalDate {
	public static void main(String[] args) {
		LocalDate today, date, localDate;
		
		
		System.out.println("	+	Сегодняшняя дата");
		today = LocalDate.now();
		System.out.println("Сегодня: " + today);
		
		
		System.out.println("	+	Сегодняшняя дата в часовом поясе");
		ZoneId timeZone = ZoneId.of("Asia/Shanghai");
		localDate = LocalDate.now(timeZone);
		System.out.println("Сейчас в Шанхае: " + localDate);
		
		
		System.out.println("	+	Дата");
		date = LocalDate.of(2019, Month.FEBRUARY, 22);
		date = LocalDate.of(2019, 2, 22);
		System.out.println( date );
		
		
		System.out.println("	+	Дата через порядковый день в году");
		date = LocalDate.ofYearDay(2019, 199);
		System.out.println( date );
		
		
		System.out.println("	+	Юникс-вермя, дни начиная с 01.01.1970");
		date = LocalDate.ofEpochDay(10);
		System.out.println( date );
		
		
		System.out.println("	+	Составляющие даты");
		System.out.println( today.getEra() + " эра (BC - Before Current Era и CE - Current Era)" );
		System.out.println( today.getYear() + " год" );
		System.out.println( today.getMonth() + " месяц (название)" );
		System.out.println( today.getMonthValue() + " месяц (номер)" );
		System.out.println( today.getDayOfMonth() + " число" );
		System.out.println( today.getDayOfWeek() + " день недели (название)" );
		System.out.println( today.getDayOfYear() + " день с начала года" );
		
		
		System.out.println("	+	Действия с датой возвращают новый объект");
		System.out.println( today + " сегодня");
		System.out.println( today.plusYears(1) + " плюс 1 год");
		System.out.println( today.plusMonths(2) + " плюс 2 месяца");
		System.out.println( today.plusWeeks(5) + " плюс 5 недель");
		System.out.println( today.plusDays(10) + " плюс 10 дней");
		System.out.println( today.minusYears(2) + " минус 2 года");
		System.out.println( today.minusMonths(3) + " минус 3 месяца");
		System.out.println( today.minusWeeks(6) + " минус 6 недель");
		System.out.println( today.minusDays(11) + " минус 11 дней");
		
	}
}
