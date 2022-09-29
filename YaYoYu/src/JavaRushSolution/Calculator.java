package JavaRushSolution;

/* 
Калькулятор
*/

public class Calculator {
	public static int plus(int a, int b) {
		//напишите тут ваш код
		return a + b;
	}
	
	public static int minus(int a, int b) {
		//напишите тут ваш код
		return a - b;
	}
	
	public static int multiply(int a, int b) {
		//напишите тут ваш код
		return a * b;
	}
	
	public static double division(int a, int b) {
		//напишите тут ваш код
		return 1d * a / b;
	}
	
	public static double percent(int a, int b) {
		//напишите тут ваш код
		return 1d * a * b / 100;
	}
	
	public static void main(String[] args) {
		System.out.println(percent(5, 50));
		int i = 010 + 010;
		System.out.println(Integer.toOctalString(i));
		i = 010 * 010;
		System.out.println(Integer.toOctalString(i));
		i = 0b10 + 0b10;
		System.out.println(Integer.toBinaryString(i));
		i = 0b10 * 0b10;
		System.out.println(Integer.toBinaryString(i));
		i = 0x10 + 0x10;
		System.out.println(Integer.toHexString(i));
		i = 0x10 * 0x10;
		System.out.println(Integer.toHexString(i));
	}
}