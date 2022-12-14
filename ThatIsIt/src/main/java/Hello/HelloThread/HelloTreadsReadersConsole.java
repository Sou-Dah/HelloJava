package Hello.HelloThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Кто первый встал - того и тапки
JavaRush Core level 16 task 28
5
1
2
3
4
5
*/
/*
Программа считывает с консоли в несколько нитей. Какая успела считать, та себе и записала.
 */
public class HelloTreadsReadersConsole {
	public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
	public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		//read count of strings
		int count = Integer.parseInt(reader.readLine());
		
		//init threads
		ReaderThread consoleReader1 = new ReaderThread();
		ReaderThread consoleReader2 = new ReaderThread();
		ReaderThread consoleReader3 = new ReaderThread();
		
		consoleReader1.start();
		consoleReader2.start();
		consoleReader3.start();
		
		while (count > readStringCount.get()) {
		}
		
		consoleReader1.interrupt();
		consoleReader2.interrupt();
		consoleReader3.interrupt();
		System.out.println("#1:" + consoleReader1);
		System.out.println("#2:" + consoleReader2);
		System.out.println("#3:" + consoleReader3);
		
		reader.close();
	}
	
	public static class ReaderThread extends Thread {
		private List<String> result = new ArrayList<String>();
		
		public void run() {
			//напишите тут ваш код
			try {
				while (!isInterrupted()) {
					result.add(reader.readLine());
					
					readStringCount.addAndGet(1);
				}
				
			} catch (IOException e) {
				
			}
		}
		
		@Override
		public String toString() {
			return result.toString();
		}
	}
}
