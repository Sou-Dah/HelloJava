package Hello.HelloDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
DateFormat не поддерживает языкового стандарта
SimpleDateFormat можно использовать для форматирования (преобразования даты в строку) 
и для парсинга строки в дату с поддержкой языкового стандарта

DateFormat — это абстрактный класс, который обеспечивает базовую поддержку для форматирования и анализа дат
SimpleDateFormat — это конкретный класс, расширяющий класс DateFormat

SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);
Если опустить аргумент Locale.ENGLISH, то будет использовано значение Locale по умолчанию, которое не всегда 
является английским.
Если языковой стандарт не совпадает с входной строкой, то строковые данные, привязанные к языку, как у нас Mon или 
April, не будут распознаны и вызовут падение — java.text.ParseException, даже в том случае когда шаблон подходит.

Letter 	Date or Time Component 	Presentation 	Examples
G 	Era designator 	Text 	AD
y 	Year 	Year 	1996; 96
Y 	Week year 	Year 	2009; 09
M 	Month in year (context sensitive) 	Month 	July; Jul; 07
L 	Month in year (standalone form) 	Month 	July; Jul; 07
w 	Week in year 	Number 	27
W 	Week in month 	Number 	2
D 	Day in year 	Number 	189
d 	Day in month 	Number 	10
F 	Day of week in month 	Number 	2
E 	Day name in week 	Text 	Tuesday; Tue
u 	Day number of week (1 = Monday, ..., 7 = Sunday) 	Number 	1
a 	Am/pm marker 	Text 	PM
H 	Hour in day (0-23) 	Number 	0
k 	Hour in day (1-24) 	Number 	24
K 	Hour in am/pm (0-11) 	Number 	0
h 	Hour in am/pm (1-12) 	Number 	12
m 	Minute in hour 	Number 	30
s 	Second in minute 	Number 	55
S 	Millisecond 	Number 	978
z 	Time zone 	General time zone 	Pacific Standard Time; PST; GMT-08:00
Z 	Time zone 	RFC 822 time zone 	-0800
X 	Time zone 	ISO 8601 time zone 	-08; -0800; -08:00
*/

public class HelloDateFormat {
	public static void main(String[] args) {
		// Вывод даты по шаблону
		Date date = new Date(1212121212121L);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	// создание шаблона
		System.out.println(formatter.format(date));
		
		// Преобразование строки в дату
		String strDate = "Sat, April 4, 2020";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);	// создание шаблона
		try {
			Date date1 = sdf.parse(strDate);
			System.out.println(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Дата битвы при Каннах, в которой Ганнибал победил войско Рима
		// Это произошло 2 августа 216 г. до н. э.
		// BC - Before Christ (до нашей эры),  AC - After Christ (нашей эры)
		GregorianCalendar cannes = new GregorianCalendar(216, Calendar.AUGUST, 2);
		cannes.set(Calendar.ERA, GregorianCalendar.BC);
		
		DateFormat df = new SimpleDateFormat("dd MMM yyy GG");
		System.out.println(df.format(cannes.getTime()));
		
		// Стандартный формат даты
		Calendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25);
		calendar.set(Calendar.HOUR, 10);
		calendar.set(Calendar.MINUTE, 42);
		calendar.set(Calendar.SECOND, 12);
		System.out.println(calendar.getTime());
		// Свой формат даты
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
		System.out.println(dateFormat.format(calendar.getTime()));
		
	}
}
