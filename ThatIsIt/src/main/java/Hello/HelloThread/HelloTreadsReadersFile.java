package Hello.HelloThread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Последовательный вывод файлов
JavaRush Core lelel 6 task 30
D:\code\IdeaProjects\YaYoYu\src\JavaRushSolution\12345.txt
D:\code\IdeaProjects\YaYoYu\src\JavaRushSolution\67890.txt
src/JavaRushSolution/12345.txt
src/JavaRushSolution/67890.txt
*/

public class HelloTreadsReadersFile {
	public static String firstFileName;
	public static String secondFileName;
	
	//напишите тут ваш код
	static {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			firstFileName = br.readLine();
//			secondFileName = br.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		firstFileName = "D:\\code\\IdeaProjects\\YaYoYu\\src\\JavaRushSolution\\12345.txt";
		secondFileName = "D:\\code\\IdeaProjects\\YaYoYu\\src\\JavaRushSolution\\67890.txt";
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		systemOutPrintln(firstFileName);
		systemOutPrintln(secondFileName);
	}
	
	public static void systemOutPrintln(String fileName) throws InterruptedException {
		ReadFileInterface f = new ReadFileThread();
		f.setFileName(fileName);
		f.start();
		f.join();
		System.out.println(f.getFileContent());
	}
	
	public interface ReadFileInterface {
		
		void setFileName(String fullFileName);
		
		String getFileContent();
		
		void join() throws InterruptedException;
		
		void start();
	}
	
	//напишите тут ваш код
	public static class ReadFileThread extends Thread implements ReadFileInterface {
		private String fullFileName;
		
		private StringBuilder fileSB = new StringBuilder();
		private String fileS;
		
		
		@Override
		public void setFileName(String fullFileName) {
			this.fullFileName = fullFileName;
		}
		
		@Override
		public String getFileContent() {
//			return fileSB.toString();
			return  fileS;
		}
		
		@Override
		public void run() {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));) {
				while (br.ready()) {
					fileSB.append(br.readLine());
				}
				fileS = fileSB.toString();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
}
