package Hello.HelloNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class HelloNumbersBig {
	public static void main(String[] args) {
		// В классе есть внутренние константы
		System.out.println(BigInteger.ZERO);
		System.out.println(BigInteger.ONE);
		System.out.println(BigInteger.TEN);
		
		BigInteger a = new BigInteger("100");
		BigInteger b = new BigInteger("200");
		
		// Сложение
		System.out.println(a.add(b));
		
		// Умножение
		System.out.println(a.multiply(b));
		
		// Остаток от деления
		System.out.println(a.remainder(b));
		
		// Альтернативный остаток от деления (с учётом знака)
		System.out.println(a.mod(b));
		
		// Модуль числа
		System.out.println(a.abs());
		
		// Случайное число с заданным количеством бит
		System.out.println(BigInteger.probablePrime(8, new Random()));
		
		// Побитовый сдвиг влево
		System.out.println(a.shiftLeft(2));
		
		// Побитовый сдвиг вправо
		System.out.println(b.shiftRight(2));
		
		System.out.println("12345678901234567890123456789012345678901234567890");
		
		// Количество цифр после запятой
		System.out.println(BigDecimal.valueOf(0.12345).scale()); // 5
		// Также работает для очень больших чисел в виде строки:
		System.out.println(new BigDecimal("2321.1234567890123456789").scale()); // 19
		// Только нужно опасаться использования new BigDecimal(double), можно получить непредвиденные значения в силу
		// того, что в double лежит не всегда именно то, что мы туда положили, а нечто очень похожее (некоторые 
		// значения невозможно представить точно в двоичной системе):
		BigDecimal d = new BigDecimal(0.123);
		System.out.println(d.scale()); // 52 ???
		System.out.println(d.toString()); // 0.1229999999999999982236431605997495353221893310546875 !!!
		
	}
	
}
