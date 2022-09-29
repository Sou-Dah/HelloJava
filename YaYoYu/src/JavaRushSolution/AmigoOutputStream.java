package JavaRushSolution;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
avaRush © All rights reserved.
*/

public class AmigoOutputStream extends FileOutputStream {
	public static String fileName = "C:/tmp/result.txt";
	
	public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
		super(fileName);
	}
	public static void main(String[] args) throws FileNotFoundException {
		new AmigoOutputStream(new FileOutputStream(fileName));
	}
	
	@Override
	public void close() throws IOException {
		flush();
		super.write("avaRush © All rights reserved.".getBytes());
		super.close();
	}
	
}
