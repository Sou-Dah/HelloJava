package Hello.HelloDate;

import java.time.LocalTime;

/*
Все объекты классов пакета java.time имеют свойство immutable - их нельзя изменить после создания.

 */
public class HelloLocalTime {
	public static void main(String[] args) {
		LocalTime time;
		
		
		System.out.println("	+	Сейчас с наносекундами");
		time = LocalTime.now();
		System.out.println("Сейчас: " + time);
		
		
		System.out.println("	+	Заданное время (часы, минуты, секунды, наносекунды)");
		time = LocalTime.of(13, 20);
		time = LocalTime.of(13, 20, 11);
		time = LocalTime.of(13, 20, 11, 333);
		System.out.println( time );
		
		
		System.out.println("	+	Время по количеству секунд (0 - 86399)");
		System.out.println( LocalTime.ofSecondOfDay( 666 ) );
		time = LocalTime.ofSecondOfDay(777);
		System.out.println( time );
		
		
		System.out.println("	+	Время по частям");
		time = LocalTime.now();
		System.out.println( time.getHour() + " - часы" );
		System.out.println( time.getMinute() + " - минуты" );
		System.out.println( time.getSecond() + " - секунды" );
		System.out.println( time.getNano() + " - наносекунды");
		
		
		System.out.println("	+	Изменене времени (создаётся новый объект)");
		System.out.println( time + " сейчас" );
		System.out.println( time.plusHours(3) + " плюс 3 часа" );
		System.out.println( time.plusMinutes(55) + " плюс 55 минут" );
		System.out.println( time.plusSeconds(10) + " плюс 10 секунд" );
		System.out.println( time.plusNanos(777) + " плюс 777 наносекунд" );
		System.out.println( time.minusHours(2) + " минус 2 часа" );
		System.out.println( time.minusMinutes(57) + " минус 57 минут" );
		System.out.println( time.minusSeconds(59) + " минус 59 секунд" );
		System.out.println( time.minusNanos(666) + " минус 666 наносекунд" );
		
		
	}
}
