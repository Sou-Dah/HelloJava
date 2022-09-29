package Hello.HelloNumbers;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;

public class HelloNumbersActions {
	
	public static void main(String[] args) {
		
		//	Округление
		double value = 3456.3456;
		//	1
		System.out.printf("%.3f", value);
		//	2
		String result2 = String.format("%.3f", value, Locale.ENGLISH);
		System.out.println("\nresult2 = " + result2);
		//	3
		System.out.format("\n%.3f", value, Locale.ENGLISH);
		//	4
		DecimalFormat decimalFormat = new DecimalFormat("#.###" );
		String result4 = decimalFormat.format(value);
		System.out.println("result4 = " + result4);
		//	особенности округления "5"
		System.out.println( decimalFormat.format(7.4565) );
		System.out.println( decimalFormat.format(7.4575) );
		//	изменение шаблона после его создания
		decimalFormat.applyPattern("#.#");
		decimalFormat.applyLocalizedPattern("#.#####");
		
		//	Округление в большую сторону
		System.out.println( Math.ceil(value) );
		
		//	Округление в меньшую сторону
		System.out.println( Math.floor(value) );
		
		//	double sqrt(double a)	квадратный корень из "a"
		//	double cbrt(double a)	кубический корень из "a"
		//	double pow(double a, double b)	возведение "a" в степень "b"
		//	double exp(double a)	экспонента в степени "a"
		//	double log(double a)	натуральный логарифм "a": ln(a)
		//	double log10(double a)	десятичный логарифм от "a": log10a
		
		//	Для очень маленьких значениях x
		//	double log1p(double x)	натуральный логарифм от "x + 1": ln(x + 1)
		//	double expm1(double x)	экспонента в степени "x" за вычетом единицы
		
		//	Наименьшее и наибольшее
		//	Math.min( Math.min(a, b), Math.min(c, d) ):
		//	Math.max( a, Math.max(b, c) ):
		
		//	Случайные числа
		//	double Math.random()	[0, 1) - нужный диапазон через умножение результата и прибавление к нему
		
		//	Псевдослучайные числа (последовательность) [0, 1)
		Random r = new Random();
		//	[0, 1)
		float fR = r.nextFloat();
		//	[ Integer.MIN_VALUE, Integer.MAX_VALUE ] == [ -2_147_483_648, +2_147_483_647]
		int iR = r.nextInt();
		//	[0, max)
		int iRmax = r.nextInt(10);
		//	[ Long.MIN_VALUE, Long.MAX_VALUE ]
		long lR = r.nextLong();
		//	[false, true]
		boolean bR = r.nextBoolean();
		//	Заполнение массива случайными значениями. Очень удобно, если нужен большой буфер со случайными данными.
		byte[] data = new byte[1024];
		r.nextBytes( data );
		//	[0, 1) распредение результата по кривой Гаусса (нормальное распределение)
		double dRgauss = r.nextGaussian();
		
	}
}
