package Hello.HelloNumbers;

import java.text.DecimalFormat;
import java.util.Locale;

public class HelloNumbers {
	public static void main(String[] args) {
		//	Object занимает 4 байта (как int). Но на 64-х разрядной машине все ссылки 8 байт (64 бита)
		
		//	Char от 0 до 65_535
		//	
		//	boolean	Character.isAlphabetic(int)	Является ли символ символом алфавита
		//	boolean	Character.isLetter(char)	Является ли символ буквой
		//	boolean	Character.isDigit(char)		Является ли символ цифрой
		//	boolean	Character.isSpaceChar(char)	Является ли символ пробелом, переноса строки или смены параграфа (коды: 12, 13, 14)
		//	boolean	Character.isWhitespace(char)	Является ли символ разделителем: пробел, tab, и т.д.
		//	boolean	Character.isLowerCase(char)	Является ли буква строчной
		//	boolean	Character.isUpperCase(char)	Является ли буква заглавнойые
		//	
		//	char	Character.toLowerCase(char)	Делает символ строчным
		//	char	Character.toUpperCase(char)	Делает символ заглавным
		char ch;
		
		//	Char, Boolean, Byte, Short, Integer и Long содержат скрытый массив, хранящий объекты от -128 до 127
		//		Integer a = 100;
		//		Integer b = 100;
		//		int c = 100;
		//	Если написать Integer x = 128, autoboxing создаст новый объект, 
		//	а если Integer x = 127, autoboxing возьмёт готовый объект из кэша (из массива).
		//		System.out.println( a == b );	//	ссылки на один объект скрытого массива
		//		System.out.println( a == c );	//	привидение к примитиву
		//		System.out.println( b == c );
		
		//	Byte от -128 до 127
		byte b;
		//	Short от -32_768 до 32_767
		short sh;
		//	Int от -2_147_483_648 до 2_147_483_647
		int i;
		//	Long от -9_223_372_036_854_775_808 до 9_223_372_036_854_775_807
		long l;
		
		//	Float от +- 1,40129846432481707e-45 до +- 3,40282346638528860e+38
		//	от -3,4 х 10^38 до 3,4 х 10^38\
		//	Float состоит из мантиссы до 8 знаков (24 бита) и степени (8 бит)
		float f;
		//	Double от +- 4,94065645841246544e-324 до +- 1,79769313486231570e+308
		//	от -1,7 х 10^308 до 1,7 х 10^308
		//	Double состоит из мантиссы до 15 знаков (53 бита) и степени (11 бит)
		double d;
		
		//	double Double.NEGATIVE_INFINITY	Минус бесконечность
		//	double Double.POSITIVE_INFINITY	Плюс бесконечность
		//	int Double.MIN_EXPONENT	Наименьшее значение степени двойки (2^x)
		//	int Double.MAX_EXPONENT	Наибольшее значение степени двойки (2^x)
		//	boolean Double.isInfinite(double)	Является ли переданное число бесконечностью.
		//	boolean Double.isNaN(double)	Является ли переданное число NaN
		
		//	слово strictfp: если его написать перед именем функции, вся работа с вещественными числами внутри этой 
		//	функции будет одинаково плохой на всех устройствах! 
		double a = 2E-300 * 3E+302;
		System.out.println("(double) a = " + a);
		
		//	Примитив из класса-обёртки
		i = new Integer(5).intValue();
		
		
		//	Бесконечность и неопределённость NaN (Not a Number)
		System.out.println( 100.0 / 0.0 );
		System.out.println( -100.0 / 0.0 );
		System.out.println( 0.0 / 0.0 );
		double infinity = 1d / 0d;
		System.out.println( infinity / infinity);
		System.out.println( 5 + infinity );
		
		//	Char - прежде всего число из Unicode
		ch = 'A';
		ch = 65;
		ch = 0x41;
		ch = 0x0041;
		ch = '\u0041';
		ch++;
		
		//	Литерал - данные, записанные прямо в коде программы (числа и строки)
		//	Нижнее подчёркивание появилось в JDK 7 (одинарное и двойное)
		l =  1234_564_890L;
		i = 500__000__001;
		
		//	Целочисленные литералы изначально имеют тип integer
		//	Вещественные литералы изначально имеют тип double
		f =  10_987_654_6299.123_34f;
		d =  110_987_654_6299.123_34;
		d = 100.;
		d = .5;
		System.out.println();
		
		//	Научная запись вещественного числа
		d = 5.23e2;
		System.out.println("d = " + d);
		d = 1e-6;
		System.out.println("d = " + d);
		
		//	Из String в Double: примитив
		System.out.println( Double.parseDouble("5.5") );
		//	Из String в Double: новый объект
		System.out.println( Double.valueOf("5.5") );
		
		//	В двоичной системе счисления числа начинаются с "0b" (появилось в JDK7)
		int intBin = 0b1000;	//	== 4 == 1*4+0*2+0
		System.out.println("intBin = " + intBin);
		intBin = 0b1000_1100_1010;
		System.out.println("intBin = " + intBin);
		//	String Integer.toBinaryString(intBin)
		//	String Integer.toOctalString(intBin)
		//	String Integer.toHexString(intBin)
		
		//	В восьмиричной системе счисления числа начинаются с "0"
		int intOct = 07;	//	== 0b111
		System.out.println("intOct = " + intOct);
		intOct = 0123;	//	== 83 == 1*64+2*8+3
		System.out.println("intOct = " + intOct);
		
		//	В шестнадцатиричной системе счисления числа начинаются с "0x"
		long longHex = 0xf;	//	== 0b1111
		System.out.println("longHex = " + longHex);
		longHex = 0xFF2345FF;
		System.out.println("longHex = " + longHex);
		
		
		
		
		
		
		
		
	}
}
