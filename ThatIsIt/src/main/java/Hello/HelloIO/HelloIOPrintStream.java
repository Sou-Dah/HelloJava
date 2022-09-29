package Hello.HelloIO;

/*
     java.lang.Object
        java.io.OutputStream
            java.io.FilterOutputStream
                java.io.PrintStream

Общее назначение — вывод информации в какой-то поток.

Наиболее распространённые конструкторы:
    PrintStream(OutputStream outputStream)
    PrintStream(File outputFile) throws FileNotFoundException
    PrintStream(String outputFileName) throws FileNotFoundException

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class HelloIOPrintStream {
	public static void main(String[] args) throws FileNotFoundException {
		// Создание на рабочем столе файла test.txt, если он там ещё не существует, 
		// и запись в него последовтельно числа, строки, логической переменной
		PrintStream filePrintStream = new PrintStream(new File("C:\\Users\\Username\\Desktop\\test.txt"));
		
		// Вообще достаточно просто указать в конструкторе путь к файлу
		filePrintStream = new PrintStream("C:\\Users\\Username\\Desktop\\test.txt");
		
		filePrintStream.println(222);
		filePrintStream.println("Hello world");
		filePrintStream.println(false);
	}
	
}
