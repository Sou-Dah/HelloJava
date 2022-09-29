package Hello.HelloString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Разные методы для разных типов

   1. Считывать с консоли данные, пока не будет введено слово "exit".
   2. Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
        содержит точку '.', вызвать метод print() для Double;
        больше нуля, но меньше 128, вызвать метод print() для short;
        меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
        иначе — вызвать метод print() для String.

1.1
100
-1
test
exit
*/

public class HelloStringParser {
	public static void main(String[] args) throws IOException {
		//напиште тут ваш код
		ArrayList<String> arlist = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String s = "";
			while (!(s = br.readLine()).equals("exit")) {
				arlist.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String s : arlist) {
			if (s.contains("."))
				try {
					print(Double.parseDouble(s));
				} catch (Exception e) {
					print(s);
				}
			else {
				try {
					int i = Integer.parseInt(s);
					if ((0 < i) && (i < 128))
						print((short) i);
					else
						print(i);
				} catch (Exception e) {
					print(s);
				}
				
			}
		}
	}
	
	
	public static void print(Double value) {
		System.out.println("Это тип Double, значение " + value);
	}
	
	public static void print(String value) {
		System.out.println("Это тип String, значение " + value);
	}
	
	public static void print(short value) {
		System.out.println("Это тип short, значение " + value);
	}
	
	public static void print(Integer value) {
		System.out.println("Это тип Integer, значение " + value);
	}
}
