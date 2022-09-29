package JavaRushSolution;

/* 
Адаптер
Адаптер

Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.

*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
	private FileOutputStream fileOutputStream;
	
	public AdapterFileOutputStream(FileOutputStream fos) {
		this.fileOutputStream = fos;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	@Override
	public void flush() throws IOException {
		fileOutputStream.flush();
	}
	
	@Override
	public void writeString(String s) throws IOException {
		fileOutputStream.write(s.getBytes());
	}
	
	@Override
	public void close() throws IOException {
		fileOutputStream.close();
	}
	
}

