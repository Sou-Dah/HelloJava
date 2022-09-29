package Hello.HelloIO;

import java.io.*;

/*
Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
 */
public class HelloIOFile {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String sourceFileName = reader.readLine();
		String destinationFileName = reader.readLine();
		
		InputStream fileInputStream = new FileInputStream(sourceFileName);
		OutputStream fileOutputStream = new FileOutputStream(destinationFileName);
		
		int count = 0;
		while (fileInputStream.available() > 0) ;
		{
			int data = fileInputStream.read();
			fileOutputStream.write(data);
			count++;
		}
		
		System.out.println("Скопировано байт " + count);
		
		fileInputStream.close();
		fileOutputStream.close();
	}
	
}
