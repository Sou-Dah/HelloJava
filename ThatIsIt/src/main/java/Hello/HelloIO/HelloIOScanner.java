package Hello.HelloIO;

import java.util.Scanner;

/* 	Scanner оперирует символами.
  	
  	Reader оперирует байтами.
  	InputStream оперирует символами.
 */
public class HelloIOScanner {
	
	public static void main(String[] args) {
		
		/*	В качестве источника данных выступает строка.
		 */
//		ScannerString();
		
		/*	В качестве источника данных выступает консольный ввод с проверкой на число.
		 */
		ScannerConsole();
		
	}
	
	private static void ScannerString() {
		
		/*	Немного японской поэзии:
		несколько хокку великого поэта Мацуо Басе
		 */
		Scanner scan = new Scanner("На голой ветке'" +
								   "Ворон сидит одиноко.'" +
								   "Осенний вечер." +
								   "''***''" +
								   "В небе такая луна,'" +
								   "Словно дерево спилено под корень:'" +
								   "Белеет свежий срез." +
								   "''***''" +
								   "Как разлилась река!'" +
								   "Цапля бредет на коротких ножках,'" +
								   "По колено в воде.");
		
		/*	В этот метод передаётся строка, которая будет использоваться в качестве разделителя, она заменяет установленный
		 по умолчанию разделитель.
			Разделителем по умолчанию является " "  (пробел).
		 */
		scan.useDelimiter("'");
		
		/**
		 * hasNextInt() — метод проверяет, является ли следующая порция введенных данных числом, или нет (возвращает,
		 * соответственно, true или false).
		 * hasNextLine() — проверяет, является ли следующая порция данных строкой.
		 * hasNextByte(), hasNextShort(), hasNextLong(), hasNextFloat(), hasNextDouble() — все эти методы делают то же 
		для остальных типов данных.
		 * Пользователь может ввести несколько чисел в одной строке, разделив их пробелами: такая ситуация будет 
		 * корректно обработана методами класса Scanner. Однако числа будут считаны программой только после того, как
		 * пользователь нажмет Enter.
		 */
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
		scan.close();
		
	}
	
	private static void ScannerConsole() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите число: ");
		
		if (sc.hasNextInt()) {
			int number = sc.nextInt();
			System.out.println("Спасибо! Вы ввели число " + number);
			sc.reset();
			
			//	Попытка посмотреть соответствие цифры символу в байтах
//			String s = new Scanner(String.valueOf(number)).nextLine();
//			System.out.println("Введнные цифры в байтах соответствуют следующей строке:\n" + s);
			
		} else {
			System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
		}
		sc.close();
	}
	
}
