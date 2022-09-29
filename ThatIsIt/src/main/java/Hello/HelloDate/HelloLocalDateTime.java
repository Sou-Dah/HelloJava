package Hello.HelloDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class HelloLocalDateTime {
	public static void main(String[] args) {
		LocalDateTime dateTime, localDateTime, today;
		
		
		System.out.println("	+	Сегодня и сейчас разделяюся буквой Т");
		dateTime = LocalDateTime.now();
		System.out.println( dateTime );
		
		
		System.out.println("	+	Заданный момент времени");
		//	of (int year, int month, int day, int hour, int minute)
		//	of (int year, int month, int day, int hour, int minute, int second)
		//	of (int year, int month, int day, int hour, int minute, int second, int nano)
		//	of (int year, Month month, int day, int hour, int minute)
		//	of (int year, Month month, int day, int hour, int minute, int second)
		//	of (int year, Month month, int day, int hour, int minute, int second, int nano)
		//	of (LocalDate date, LocalTime time)
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		dateTime = LocalDateTime.of( localDate, localTime );
		System.out.println( dateTime );
		
		dateTime = LocalDateTime.of(2019, Month.FEBRUARY, 15, 12, 15, 00);
		System.out.println( dateTime );
		
		
		System.out.println("	+	ЮНИКС-время в секундах с 1 января 1970 года (и наносекундах)");
		Instant timeUnix = Instant.now();
		System.out.println( timeUnix );
		
		//	Создание через миллисекуны с 1 января 1970 года
		//	Instant.ofEpochMilli(long milliseconds)
		//	Instant.ofEpochSecond(long seconds)
		//	Instant.ofEpochSecond(long seconds, long nanos)
		System.out.println( Instant.ofEpochMilli(1000_000_000) );
		
		System.out.println("	+	Получение значений полей");
		System.out.println( timeUnix + " - сейчас" );
		System.out.println( timeUnix.getEpochSecond() + "\t - секунды" );
		System.out.println( ".........." + timeUnix.getNano() + "\t - наносекунды" );
		System.out.println( timeUnix.toEpochMilli() + "\t - миллисекунды" );
		
		
	}
}
