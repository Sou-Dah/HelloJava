package JavaRushSolution;

/* 
Класс StringHelper
*/

public class StringHelper {
	public static String multiply(String text) {
		String result = "";
		//напишите тут ваш код
		return multiply(text, 5);
	}
	
	public static String multiply(String text, int count) {
		String result = "";
		//напишите тут ваш код
		for (int i = 0; i < count; i++) {
			result += text;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(multiply("Ab"));
		System.out.println(multiply("Cd", 3));
	}
}
