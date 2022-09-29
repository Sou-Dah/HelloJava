package Hello.HelloIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
FileInputStream(String fileName); — конструктор
int read(); — чтение 1 байта и возвращение его как результат с приведением к int
int read(byte[] buff); — чтение блока байт в массив, пока он не заполнится или пока не иссякнет источник; возвращает 
количество прочитанного (может быть меньше длины массива) 
int available(); — количество непрочитанных доступных байт
void close();

FileOutputStream (String fileName); — конструктор
void write(int data); — запись очередного байта, обрезая переменную data до одного байта (лишняя часть просто 
отбрасывается)
void write(byte[] buff);
void write(byte[] buff, int from, int count); — используется в случаях, когда есть вероятность, что блок данных был 
заполнен не целиком
void flush(); — немедленно записать всю несохраненную информацию на диск
часто данные для записи сначала собираются в большие блоки в памяти, а потом только пишутся на диск
void close();

 */
public class HelloIOFileStream {
	public static void main(String[] args) throws Exception
	{
		//Создаем поток-чтения-байт-из-файла
		FileInputStream inputStream = new FileInputStream("c:/data.txt");
		// Создаем поток-записи-байт-в-файл
		FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
		
		byte[] buffer = new byte[1000];
		while (inputStream.available() > 0) //пока есть еще непрочитанные байты
		{
			// прочитать очередной блок байт в переменную buffer и реальное количество в count
			// Когда мы читаем самый последний блок данных в файле, может оказаться, что байт осталось не 1000, а, 
			// скажем, 328. Тогда и при записи нужно указать, что записать не весь блок, а только его первые 328 ячеек.
			int count = inputStream.read(buffer);
			outputStream.write(buffer, 0, count); //записать блок (часть блока) во второй поток
		}
		
		inputStream.close(); //закрываем оба потока. Они больше не нужны.
		outputStream.close();
	}
}
