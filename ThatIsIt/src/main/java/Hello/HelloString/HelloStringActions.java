package Hello.HelloString;

import java.util.StringTokenizer;

public class HelloStringActions {
	public static void main(String[] args) {
		/*
		Возвращает индекс первого символа встретившийся строки.
		int indexOf( String str )
		
		Возвращает индекс найденного вхождения.
		int indexOf( String str, int indexStartFrom )
		
		int lastIndexOf( String str )
		int lastIndexOf( String str, int indexStartFrom )
		
		Удаление всех пробелов в начале и в конце строки (перенос строк остаётся)
		String trim()
		*/
		
		
		/*			Разделение строки на части
		StringTokenizer имя = new StringTokenizer(строка, разделители);
		boolean hasMoreTokens()
		String nextToken()
		 */
		String str = "Good news everyone!";
		StringTokenizer tokenizer = new StringTokenizer(str, "ne");
		while(tokenizer.hasMoreElements()) {
			String s = tokenizer.nextToken();
			System.out.println(s);
		}
		
	}
}
