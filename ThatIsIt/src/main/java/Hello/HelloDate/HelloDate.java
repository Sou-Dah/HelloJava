package Hello.HelloDate;

import java.util.Date;
/*
Это количество миллисекунд с 1 января 1970 года, по Гринвичу
Это Unix-время, хранится в long.

Date birthday = new Date(год, месяц, день);
Date birthday = new Date(год, месяц, день, час, минута, секунда);
	1) Год задаётся от 1900.
	2) Месяцы нумеруются с нуля.
	3) Числа нумеруются с единицы.
	4) Часы, минуты и секунды нумеруются с нуля.

String	new Date() - ДеньНедели Месяц Число ЧЧ:ММ:СС ЧасовойПояс Год
long	new Date().getTime() - сегодня в милисекундах с 1 января 1970 года

boolean	date1.before(date2) - проверяем, что время date1 до date2
boolean	date1.after(date2) - проверяем, что время date1 после date2
boolean	date1.equals(date2) - проверяем, что время date1 то же, что и date2

DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
Date	dateFormat.parse("MAY 1 2012");
 */

public class HelloDate {
	public static void main(String[] args) throws Exception {
		// Получение текущей даты
		// Сколько прошло времени с начала сегодняшнего дня
		Date today = new Date();
		System.out.println("Сегодняшняя дата: " + today);
		System.out.println("год: " + (today.getYear() + 1900) ) ;
		System.out.println("месяц: " + (today.getMonth() + 1) );
		System.out.println("число: " + today.getDate());
		System.out.println("день недели: " + today.getDay());
		int hours = today.getHours();
		int mins = today.getMinutes();
		int secs = today.getSeconds();
		System.out.println("Время: " + hours + ":" + mins + ":" + secs);
		System.out.println();
		
		
		// Сколько дней прошло с начала года
		Date yearStartTime = new Date();
		yearStartTime.setHours(0);		// полночь
		yearStartTime.setMinutes(0);	// полночь
		yearStartTime.setSeconds(0);	// полночь
		yearStartTime.setDate(1);		// первое число
		yearStartTime.setMonth(0);		// месяц январь, нумерация для месяцев 0-11
		Date currentTime = new Date();
		long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
		long msDay = 24 * 60 * 60 * 1000;				// сколько миллисекунд в одних сутках
		int dayCount = (int) (msTimeDistance/msDay);	// количество целых дней
		System.out.println("Days from start of year: " + dayCount);
		
		
		// Вычисление разницы между двумя датами
		Date firstTime = new Date();			// получаем текущую дату и время
		Thread.sleep(3000);						// ждём 3 секунды – 3000 миллисекунд
		Date secondTime = new Date();			// получаем новое текущее время
		long msDelay = secondTime.getTime() - firstTime.getTime();	// вычисляем разницу
		System.out.println("Time distance is: " + msDelay + " in ms");
		
		
		//	Сравнение дат
		//	1. if ( date1.getTime() < date2.getTime() )
		//	2. if ( date1.before(date2) )
		//	3. if ( date2.after(date1) )
		
		
		// Наступило ли уже некоторое время
		Date startTime = new Date();
		long endTime = startTime.getTime() + 5000;		// +5 секунд
		Date endDate = new Date(endTime);
		Thread.sleep(3000);								// ждем 3 секунды
		Date nowTime = new Date();
		while (true) {
			if (nowTime.after(endDate)) {				//проверяем что время nowTime после endDate
				System.out.println("End time!");
				break;
			} else {
				System.out.println("It's not time yet!");
				Thread.sleep(1000);						// ждем 1 секунду
				nowTime = new Date();
			}
		}
		
	}
}
