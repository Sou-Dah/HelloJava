package JavaRushSolution;

/* 
Расширяем AmigoOutputStream
*/

import java.io.*;

public class QuestionFileOutputStream extends AmigoOutputStream {
	
	public QuestionFileOutputStream(FileOutputStream fos) throws FileNotFoundException {
		super(fos);
	}
	
	@Override
	public void flush() throws IOException {
		
	}
	
	@Override
	public void write(int b) throws IOException {
		
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("Вы действительно хотите закрыть поток? Д/Н");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		br.close();
		if (s.equals("Д")) {
			this.close();
			System.out.println("Поток закрыт");
		} else {
			System.out.println("Поток не закрыт");
		}
		
		
	}
	
}

