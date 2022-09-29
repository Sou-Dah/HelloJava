package Hello.HelloNumbers;

/*
 В приоритетном порядке
 	[], ., () — скобки, вызов метода

 	++, --, !, (), new — повышение, понижение, логическое отрицание, приведение
 	
	~ — побитовое отрицание (тильда)
	
 	*, /, %
 	+, -
 	
	<< — побитовый сдвиг влево (умножение на 2)
	>> — побитовый сдвиг вправо (деление на 2)
	>>> — побитовый сдвиг вправо (деление на 2) с добавлением нолей слева независимо от того, какой бит знака был у числа
	
	<, >, <=, >=, instanceof
	!=, ==
	
	& — побитовое умножение ( OR )
	^ — побитовое различие ( XOR )
	| — побитовое сложение ( AND )
	
	&&
	||
	? : — тернарный оператор (условие)
	
	=, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>= — присваивание
 
 */

public class HelloLogicalBinary {
	public static void main(String[] args) {
		System.out.println("Пример работы с типом byte");
		byte a = 47;
		byte b = (byte) ~a;
		System.out.println("a = " + a + " \t" + Integer.toBinaryString(a));
		System.out.println("b = " + b + "\t" + Integer.toBinaryString(b));
		System.out.println();
		
		System.out.println("Пример работы с типом short");
		short c = 350;
		short d = (short) ~c;
		System.out.println("c = " + c + " \t" + Integer.toBinaryString(c));
		System.out.println("d = " + d + "\t" + Integer.toBinaryString(d));
		System.out.println();
		
		System.out.println("Пример работы с типом int");
		int e = 555555555;
		int f = (int) ~e;
		System.out.println("e = " + e + " \t" + Integer.toBinaryString(e));
		System.out.println("f = " + f + "\t" + Integer.toBinaryString(f));
		System.out.println();
		
		System.out.println("Пример работы с типом long");
		long g = 111112222233333L;
		long h = (long) ~g;
		System.out.println("g = " + g + " \t" + Long.toBinaryString(g));
		System.out.println("h = " + h + "\t" + Long.toBinaryString(h));
		
		//	Флаг - бит в двоичной записи числа Integer или Long, 1 или 0 в определённом разряде
		//	a | (1 << b)	установить флаг (a - числе, b - разряд)
		//	a & ~(1 << b)	сбросить флаг
		//	(a & (1 << b)) == (1 << b)	проверить флаг
		
		//	Простейшее шифрование достигается логическим различием
		//	XOR, дважды примененный к числу, дает исходное число, независимо от пароля.
		//	результат = число ^ пароль
		//	исходное число = результат ^ пароль
		
		//	Поменять местами переменные не испольцуя посредника
		int o1 = 36, o2 = 400;
		System.out.println("o1 =    " + Integer.toBinaryString(o1));
		System.out.println("o2 = " + Integer.toBinaryString(o2));
		o1 = o1 ^ o2;
		o2 = o1 ^ o2;
		o1 = o1 ^ o2;
		System.out.println("o1 = " + o1);
		System.out.println("o2 = " + o2);
	}
}
