package Hello.HelloDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*
Calendar birthday = new GregorianCalendar(год, месяц, день);
Calendar birthday = new GregorianCalendar(год, месяц, день, часы, минуты, секунды);
	1) Год задаётся 4 цифрами.
	2) Месяцы нумеруются с нуля.
	3) Числа нумеруются с единицы.
	4) Часы, минуты и секунды нумеруются с нуля.
 */

public class HelloCalendar {
	public static void main(String[] args) {
		//	Протейшее создание текущей даты с календарём в зависимости от настроек машины
		Calendar calendar = Calendar.getInstance();
		
		//	25 января 2017 года
		System.out.println("	+	25 января 2017 года");
		calendar = new GregorianCalendar(2017, 0 , 25);
		calendar.set( Calendar.HOUR, 19);
		calendar.set( Calendar.MINUTE, 42);
		calendar.set( Calendar.SECOND, 12);
		System.out.println( calendar.getTime() );
		
		
		//	Каждое поле календаря по отдельности
		System.out.println("	+	Каждое поле календаря по отдельности");
		calendar = new GregorianCalendar();
		System.out.println("сегодня: " + calendar.getTime());
		System.out.println( calendar.get(Calendar.ERA) + " эра");
		System.out.println( calendar.get(Calendar.YEAR) + " год");
		System.out.println( calendar.get(Calendar.MONTH) + " месяц");
		System.out.println( calendar.get(Calendar.DAY_OF_MONTH) + " число");
		System.out.println( calendar.get(Calendar.WEEK_OF_MONTH) + " неделя");
		System.out.println( calendar.get(Calendar.HOUR) + " час");
		System.out.println( calendar.get(Calendar.MINUTE) + " минута");
		System.out.println( calendar.get(Calendar.SECOND) + " секунда");
		System.out.println( calendar.get(Calendar.MILLISECOND) + " милисекунда");
		
		//	Чтобы отнять значение нужно в метод передать отрицательное число
		System.out.println("	+	Изменение даты на 14 дней назад");
		calendar = new GregorianCalendar();
		calendar.add( Calendar.DAY_OF_MONTH, -14 );
		System.out.println( new GregorianCalendar().getTime() );
		System.out.println( calendar.getTime() );
		
		//	Прокручивание фрагментов даты
		System.out.println("	+	Прокуручивание только дней на 14 назад");
		calendar = new GregorianCalendar();
		calendar.roll( Calendar.DAY_OF_MONTH, -14 );
		System.out.println( new GregorianCalendar().getTime() );
		System.out.println( calendar.getTime() );
		
		//	Приведение к классу Date
		System.out.println("	+	Приведение к классу Date");
		Date date = calendar.getTime();
		System.out.println(date);
		
		//	Отдельная установка каждого из значений
		System.out.println("	+	Отдельная установка каждого из значений");
		calendar.set( Calendar.YEAR, 2017 );
		calendar.set( Calendar.MONTH, 0 );
		calendar.set( Calendar.DAY_OF_MONTH, 25 );
		calendar.set( Calendar.HOUR_OF_DAY, 19 );
		calendar.set( Calendar.MINUTE, 42 );
		calendar.set( Calendar.SECOND, 12 );
		System.out.println( calendar.getTime() );
		
		//	Дата битвы при Каннах, в которой Ганнибал победил войско Рима
		//	Это произошло 2 августа 216 г. до н. э.
		//	BC - Before Christ (до нашей эры),  AC - After Christ (нашей эры)
		GregorianCalendar cannes = new GregorianCalendar(216, Calendar.AUGUST, 2);
		cannes.set(Calendar.ERA, GregorianCalendar.BC);
		DateFormat df = new SimpleDateFormat("dd MMM yyy GG");
		System.out.println(df.format(cannes.getTime()));
		
		
	}
}
