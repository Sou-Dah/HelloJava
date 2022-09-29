package Hello.HelloString;

/*
https://javarush.ru/groups/posts/1412-formatiruem-vihvod-chisel-v-java
https://javarush.ru/groups/posts/1941-kak-ne-poterjatjhsja-vo-vremeni--datetime-i-calendar
 */

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HelloString {
	
	private static final String GREETINGS_MESSAGE = "My name is %s, my age is %d!%n";
	
	public static void main(String[] args) {
		//	Метод intern() добавит строку в StringPool, если ее еще там нет, и вернет ссылку на строку из StringPool.
		
		/*			Экранированные символы
			\t	табуляция
			\b	удаление 1 символа слева
			\r	перевод указателя в начало текукщей строки, следующий текст перекроет текущий
			\f	прогон страницы или разрыв страницы, или новая страница
			\u00A9	символ Юникода в шестнадцатиричном счислении
			\uD83D\uDD0A	всё, что не попало в 2 байта char: иероглифы, рожицы и прочее
		 */
		//	🔊
		System.out.println("\uD83D\uDD0A");
		
		//	Форматированный вывод
		System.out.println("Hello!");
		System.out.println("We are robots!");
		System.out.printf(GREETINGS_MESSAGE, "Amigo", 18);
		System.out.printf(GREETINGS_MESSAGE, "R2-D2", 235);
		System.out.printf(GREETINGS_MESSAGE, "C-3PO", 435);
		
		String str;
		str = "AsdfgHjkl;\"";
		
		// Возвращает символ типа символ с индексом, если рассматривать строку как массив символов
		System.out.println("charAt: " + str.charAt(1) );
		
		// Преобразование алфавитных символов в заглавные
		System.out.println("toUpperCase: " + str.toUpperCase() );
		
		//	Сравнение без учёта размера букв
		System.out.println("equalsIgnoreCase: " + str.equalsIgnoreCase(str.toLowerCase()) );
		
		/*			Форматирование сток	
		
		%s 	Любой тип, который будет приведен к строке 	
		%b 	Любой тип, который будет приведен к boolean: true — если значение не null, false — если null 	
		%h 	Можно передавать любой объект, который будет приведен к шестнадцатеричной строке значения из метода 
		hashCode() 	
		%c 	Используется для задания символа Unicode (char) 	
		%d 	Задается целое число (int. byte, short, int, long, BigInteger) 	
		%f 	Используется для задания числа с плавающей запятой 	
		%e 	Числа с плавающей запятой в экспоненциальном представлении 	
		%a 	Числа с плавающей запятой будут представлены в шестнадцатеричном виде 	
		%x 	Передается целое число (int. byte, short, int, long, BigInteger), в результате будет символ под данным 
		номером в таблице ASCII 	
		%o 	Принимается целое число (int. byte, short, int, long, BigInteger), которое будет представлено в виде 
		восьмеричного числа 	
		%t 	Префикс для преобразований даты и времени. Для форматирования требуются дополнительные флаги 	
		%n 	Разделитель строк для конкретной платформы. Аналог \n 	
		%%	Собственно процент
		 */
		
		System.out.println();
		System.out.println(" - - - Форматирование чисел - - - ");
		/*			Форматирование чисел
				
		%[аргумент_индекс][флаги][ширина][.точность]спецификатор типа
			
			[аргумент_индекс] — целое число, указывающее позицию в списке аргументов. К примеру, ссылка на первый 
			аргумент 1$, ссылка на второй аргумент — 2$, и т.д. Если же позиция не была задана, аргументы должны находиться в том же порядке, что и ссылки на них в строке форматирования.
			[флаги] — специальные символы для форматирования. Например:
				+ флаг, означающий, что если числовое значение положительное, оно должно включать знак +
				- означает выравнивание результата по левому краю
				, устанавливает разделитель тысяч у целых чисел
			[ширина] — положительное целое десятичное число, определяющее минимальное количество символов, которые будут выведены. Если перед этим числом стоит 0, то недостающие символы будут дополнены 0, если 0 нет, то пробелами.
			[.точность] — неотрицательное целое число с точкой перед ним. Как правило используется для ограничения количества символов. Специфика поведения зависит от конкретного вида спецификатора.

		Символы для шаблонов (некоторые):
			# — цифра, ведущие нули опускаются;
			0 — цифра отображается всегда, даже если в номере меньше цифр (в таком случае отображается 0);
			. — знак десятичного разделителя;
			, — знак группировки разделителей (например, разделитель тысяч);
			; — разделяет форматы;
			- — отмечает префикс отрицательного числа;
			% — умножает на 100 и показывает число в процентах;
			? — умножает на 1000 и показывает число в промилле;
			E — разделяет мантиссу и порядок для экспоненциального формата.
		 */
		
		//	Вывод +03,14159
		str = String.format( "%1$+09.5f", 3.1415926535897 );
		System.out.println("String.format: " + str );
		
		//	Вывод 72,224
		DecimalFormat decimalFormat;
		decimalFormat = new DecimalFormat( "#.###" );
		System.out.println("decimalFormat; " + decimalFormat.format( 72.224463 ) );
		
		//	Вывод 74 554 542,22
		System.out.println("decimalFormat 1; " + new DecimalFormat( "###,###.##" ).format(74554542.224463));
		
		//	%72,35
		System.out.println("decimalFormat 2; " + new DecimalFormat( "%###.##" ).format(0.723456));
		
		//	042,224
		System.out.println("decimalFormat 3; " + new DecimalFormat( "000.###" ).format(42.224463));
		
		//	Повторное использование шаблона
		decimalFormat = new DecimalFormat( "###.###" );
		decimalFormat.applyPattern( "000000.000" );
//		decimalFormat.applyLocalizedPattern( "#,#00.0#" );
		
		//	Округление
		DecimalFormat dF = new DecimalFormat("##.###");
		//	Если перед 5 число чётное, то округление производится в большую сторону
		str = dF.format(56.4585);
		System.out.println("Округление 1: " + str );
		//	Если перед 5 число нечётное, округление производится в меньшую сторону
		str = dF.format(56.4595);
		System.out.println("Округление 2: " +  str );
		
		//	Округление с нолями в дробной части
		//	9,0000
		str = String.format("%.4f", 9.00001273);
		System.out.println("Окургление нолей: " + str);
		//	9
		decimalFormat = new DecimalFormat("#.####");
		String secondStr = decimalFormat.format(9.00001273);
		System.out.println("Окургление нолей: " + secondStr);
		
		System.out.println();
		System.out.println(" - - - Форматирование даты - - - ");
		/*			Форматирование даты
		%tB 	Полное название месяца, например, January, February и т.д.
		%tb 	Сокращенное название месяца, например, Jan, Feb и т.д.
		%tA 	Полное название дня недели, например, Sunday, Monday
		%ta 	Сокращенное название дня недели, например, Sun, Mon и т.д.
		%tY 	Год в формате 4 цифры, например, от 0000 до 9999
		%ty 	Год в формате 2 цифры, например, от 00 до 99
		%tm 	Месяц отформатирован с нуля в начале, например, от 01 до 12
		%tc 	Дата и время в формате %ta %tb %td %tT %tZ %tY, например, Mon Feb 17 03:56:12 PST 2020
		%tD 	Дата в формате %tm/%td/%ty
		%td 	День месяца в формате двух цифр, например, от 01 до 31
		%te 	День месяца в формате без 0 в начале, например от 1 до 31
		%tT 	Время в 24-часовом формате, например, %tH:%tM:%tS
		%tH 	Час дня в 24-часовом формате, от 00 до 23
		%tI 	Час дня для 12-часового формата, например, от 01 до 12
		%tM 	Минуты в часе форматируются с нуля в начале, например, от 00 до 59
		%tS 	Секунды в минуте, состоящие из двух цифр, например, от 00 до 59
		%tZ 	Аббревиатура часового пояса, например, PST, UTC и т.д.
		 */
		Date date;
		date = new Date();
		
		//	October 11, 2020
		System.out.println(" - - date 1:");
		System.out.printf(Locale.ENGLISH, "%tB %te, %tY", date, date, date);
		System.out.println();
		
		//	11 октября 2020 года 
		//	13:43:22
		System.out.println(" - - date 3:");
		System.out.printf("%td %tB %tY года %n%tH:%tM:%tS",date,date,date,date,date,date,date);
		System.out.println();
		
		//	Вывод как в предыдущем, но с  внутренней поднастройкой $ для указания аргумента
		System.out.println(" - - date 2:");
		System.out.printf("%1$td %1$tB %1$tY года %n%1$tH:%1$tM:%1$tS",date);
		
		
		//	Преобразование пути к файлу из Юникса в Винду
		//	Решение 1 — массив символов и цикл по ним
		Scanner console1 = new Scanner(System.in);
		String path1 = console1.nextLine();
		
		char[] chars1 = path1.toCharArray();
		for (int i = 0; i < chars1.length; i++)
			if (chars1[i] == '/')
				chars1[i] = '\\';
		
		String result1 = new String(chars1);
		System.out.println( result1 );
		
		
		//	Решение 2 — split() и join()
		Scanner console2 = new Scanner(System.in);
		String path2 = console2.nextLine();
		
		String[] array2 = path2.split("/");
		
		String result2 = String.join("\\", array2);
		
		System.out.println( result2 );
		
		
		//	Решение 3 — replace(char oldChar, char newChar)
		Scanner console3 = new Scanner(System.in);
		String path3 = console3.nextLine();
		
		String result3 = path3.replace('/', '\\');
		
		System.out.println( result3 );
		
		
	}
}
