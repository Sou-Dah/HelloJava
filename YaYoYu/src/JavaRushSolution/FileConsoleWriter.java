package JavaRushSolution;

/* 
Свой FileWriter
*/

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileConsoleWriter extends  FileWriter {
	private static FileWriter fileWriter;
	
	public static void main(String[] args) {
		
	}
	
	public FileConsoleWriter(@NotNull String fileName) throws IOException {
		super(fileName);
	}
	
	public FileConsoleWriter(@NotNull String fileName, boolean append) throws IOException {
		super(fileName, append);
	}
	
	public FileConsoleWriter(@NotNull File file) throws IOException {
		super(file);
	}
	
	public FileConsoleWriter(@NotNull File file, boolean append) throws IOException {
		super(file, append);
	}
	
	public FileConsoleWriter(@NotNull FileDescriptor fd) {
		super(fd);
	}
	
	public FileConsoleWriter(String fileName, Charset charset) throws IOException {
		super(fileName, charset);
	}
	
	public FileConsoleWriter(String fileName, Charset charset, boolean append) throws IOException {
		super(fileName, charset, append);
	}
	
	public FileConsoleWriter(File file, Charset charset) throws IOException {
		super(file, charset);
	}
	
	public FileConsoleWriter(File file, Charset charset, boolean append) throws IOException {
		super(file, charset, append);
	}
	
	@Override
	public void write(int c) throws IOException {
		super.write(c);
		System.out.print(c);
	}
	
	@Override
	public void write(@NotNull char[] cbuf, int off, int len) throws IOException {
		super.write(cbuf, off, len);
		for (int i = off; i < off + len; i++) {
			System.out.print(cbuf[i]);
		}
	}
	
	@Override
	public void write(@NotNull String str, int off, int len) throws IOException {
		super.write(str, off, len);
		System.out.print(str.substring(off, off + len));
	}
	
	@Override
	public void write(@NotNull char[] cbuf) throws IOException {
		super.write(cbuf);
		for (char ch : cbuf) {
			System.out.print(ch);
		}
	}
	
	@Override
	public void write(@NotNull String str) throws IOException {
		super.write(str);
		System.out.print(str);
	}
	
	@Override
	public void close() throws IOException {
		super.close();
	}
	
}
