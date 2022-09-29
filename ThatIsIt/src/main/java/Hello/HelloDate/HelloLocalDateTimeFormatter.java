package Hello.HelloDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/time/format/DateTimeFormatter.html

	y	Год (Year)
	M	Месяц (Month)
	d	День (day)
	H	Часы (Hours)
	m	Минуты (Minutes)
	s	Секунды (Seconds)
	S	Тысячные доли секунды
	n	Наносекунды
 */
public class HelloLocalDateTimeFormatter {
	public static void main(String[] args) {
		
		//	Вывод по шаблону Пример 1
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy");
		String text = dtf.format( LocalDateTime.now() );
		System.out.println( text );
		
		//	Вывод по шаблону Пример 2
		dtf = DateTimeFormatter.ofPattern( "MMMM-dd-yyyy");
		System.out.println( dtf.format(LocalDateTime.now()) );
		
		//	Чтение по шаблону Пример 1
		dtf = DateTimeFormatter.ofPattern("MMMM-dd-yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse("February-23-2019", dtf);
		System.out.println(date);
		
		//	Чтение по шаблону Пример 2
		dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime time = LocalTime.parse("23:59:59", dtf);
		System.out.println(time);
		
	}
}
