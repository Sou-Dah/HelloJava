package Hello.HelloString;
/*
https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#sum
*/

//	1. Метасимволы для поиска совпадений границ строк или текста
/*
	^ 	начало строки
	$ 	конец строки
	\b 	граница слова
	\B 	не граница слова
	\A 	начало ввода
	\G 	конец предыдущего совпадения
	\Z 	конец ввода
	\z 	конец ввода 
*/
//	2. Метасимволы для поиска символьных классов
/*
	\d 	цифровой символ
	\D 	нецифровой символ
	\s 	символ пробела
	\S 	непробельный символ
	\w 	буквенно-цифровой символ или знак подчёркивания
	\W 	любой символ, кроме буквенного, цифрового или знака подчёркивания
	. 	любой символ
*/
//	3. Метасимволы для поиска символов редактирования текста
/*
	\t 	символ табуляции
	\n 	символ новой строки
	\r 	символ возврата каретки
	\f 	переход на новую страницу
	\ u 0085 	символ следующей строки
	\ u 2028 	символ разделения строк
	\ u 2029 	символ разделения абзацев
*/
//	4. Метасимволы для группировки символов
/*
	[абв] 	любой из перечисленных (а,б, или в)
	[^абв] 	любой, кроме перечисленных (не а,б, в)
	[a-zA-Z] 	слияние диапазонов (латинские символы от a до z без учета регистра )
	[a-d[m-p]] 	объединение символов (от a до d и от m до p)
	[a-z&&[def]] 	пересечение символов (символы d,e,f)
	[a-z&&[^bc]] 	вычитание символов (символы a, d-z)
*/
//	5. Метасимволы для обозначения количества символов – квантификаторы. Квантификатор всегда следует после символа или
// группы символов.
/*
	? 	один или отсутствует
	* 	ноль или более раз
	+ 	один или более раз
	{n} 	n раз
	{n,} 	n раз и более
	{n,m} 	не менее n раз и не более m раз 

 */

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloRegularExpression {
	static String text, patternStr;
	
	public static void main(String[] args) {
		
		//	Замена по регулярному выражению
		text = "34. 4ggs !sdf,";
		System.out.println( text.replaceAll("\\p{Punct}", "+") );
		
		//	Проверка соответствия шаблону текста
		//		static boolean matches(String regex, CharSequence input)
		System.out.println("matches? = " + Pattern.matches("А.+а","Алла"));//true
		System.out.println("matches? = " + Pattern.matches("А.+а","Егор Алла Александр"));//false
		
		//	Пример экранирования для пробелов
		patternStr = "\\s";
		//	Пример экранирования для "Windows"
		patternStr = "\"Windows\"";
		//	Пример экранирования для How?
		patternStr = "How\\?";
		
		//	Поиск самого длинного совпадения от 'А' до 'а'. С начала до конца, потом от конца.
		String patternStr1 = "А.+а";
		//	Поиск самых коротких совпадений от 'А' до 'а'. 
		String patternStr2 = "А.+?а";
		//	Сверхжадный режим.
		String patternStr3 = "А.++а";
		
		//	Совпадения можно искать в String, StringBuffer, StringBuilder, Segment, CharBuffer
		text = "Егор Алла Александр Анна Дуся Клава Степан Жора  ";
		Pattern pattern = Pattern.compile( patternStr2 );
		Matcher matcher = pattern.matcher( text );
		while (matcher.find()) {
			int iStart = matcher.start();
			int iEnd = matcher.end();
			System.out.println(text.substring(iStart, iEnd));
		}
		
		//	Замена найденного и создание новой строки (исходная сохраняется)
		System.out.println(matcher.replaceFirst("ПервыйНах"));
		System.out.println(matcher.replaceAll("ВсеНах"));
		System.out.println("text = " + text);
		
		//	Показать строку шаблона
		System.out.println( "pattern = " + pattern.pattern() );
		
		//	РегВыр в качестве разделителя строки на массив строк
		//		String[] split(CharSequence text, int limit)
		//	Вторым параметром передаётся ограничитель длины массива
//		при limit > 0 выполняется поиск limit-1 совпадений;
//		при limit < 0 выполняется поиск всех совпадений в тексте
//		при limit = 0 выполняется поиск всех совпадений в тексте, при этом пустые строки в конце массива 
//		отбрасываются;
		Pattern pattern1 = Pattern.compile("\\s");
		
		String[] strings1 = pattern1.split(text, 35);
		System.out.println("strings1.length = " + strings1.length);
		System.out.println("strings1[] = " + Arrays.toString(strings1));
		
		String[] strings2 = pattern1.split(text);
		System.out.println("strings2.length = " + strings2.length);
		System.out.println("strings2[] = " + Arrays.toString(strings2));
		
		
		
	}
	
}
