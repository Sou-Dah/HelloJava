package Hello.HelloIO;

import java.io.*;

/*	
System.in - объект класса InputStream, является входящим потоком, привязанным к системному усройству ввода данных - 
клавиатуре.
System.out - объект класса OutputStream, является выходящим потоком, привязанным к консоли.

Scanner оперирует символами.
Reader оперирует символами.
InputStream оперирует байтами.
BufferedReader оперирует блоками данных, храня их у себя, тем самым уменьшая количество обращений к потоку в разы.

System.out – это статическая переменная по имени out типа PrintStream (наследник OutputStream) в классе System
 */
public class HelloIOReader {
	public static void main(String[] args) {
		
		// Подмена System.in
		{
			// Сохранение исходной ссылки System.in в отдельную переменную
			InputStream systemInOriginal = System.in;
			
			// Например, создаётся строка из данных
			StringBuilder sb = new StringBuilder();
			sb.append("Lena").append('\n');
			sb.append("Olya").append('\n');
			sb.append("Anya").append('\n');
			String data = sb.toString();
			
			// Преобразование строки в поток байт
			InputStream is = new ByteArrayInputStream(data.getBytes());
			
			// Замена System.in
			System.setIn(is);
			
			// Возврат System.in к исходному состоянию
			System.setIn(systemInOriginal);
		}
		
		/*
		Заключённые в скобки потоки закрываются автоматически по завершению работы оператора.
		 */
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			
			while (br.ready()) {
				String s = br.readLine();
				if (s.equals("") || s.isEmpty()) break;
				System.out.println(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Пример использования выводящих методов для вывода текста
		// System.out – это статическая переменная типа PrintStream (наследник OutputStream) в классе System
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream console = new PrintStream(stream);
		console.println("Hello");
		System.out.println("stream = " + stream);
	}
}
