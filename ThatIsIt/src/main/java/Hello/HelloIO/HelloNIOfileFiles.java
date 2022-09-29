package Hello.HelloIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
Path createFile(Path path)		Создает новый файл с путем path
Path createDirectory(Path path)		Создает новую директорию
Path createDirectories(Path path)		Создает несколько директорий
Path createTempFile(prefix, suffix)		Создает временный файл
Path createTempDirectory(prefix)		Создает временную директорию
void delete(Path path)		Удаляет файл или директорию, если она пуста
Path copy(Path src, Path dest)		Копирует файл
Path move(Path src, Path dest)		Перемещает файл
boolean isDirectory(Path path)		Проверяет, что путь — это директория, а не файл
boolean isRegularFile(Path path)		Проверяет, что путь — это файл, а не директория
boolean exists(Path path)		Проверяет, что объект по заданному пути существует
long size(Path path)		Возвращает размер файла
byte[] readAllBytes(Path path)		Возвращает все содержимое файла в виде массива байт
String readString(Path path)		Возвращает все содержимое файла в виде строки
List<String> readAllLines(Path path)		Возвращает все содержимое файла в виде списка строк
Path write(Path path, byte[])		Записывает в файл массив байт
Path writeString(Path path, String str)		Записывает в файл строку
DirectoryStream<Path> newDirectoryStream(Path dir)		Возвращает коллекцию файлов (и поддиректорий) из заданной 
директории
 */
public class HelloNIOfileFiles {
	public static void main(String[] args) throws IOException {
		String str = "src/main/resources/public/0.txt";
		String strResPub = "src/main/resources/public/";
		System.out.println( Path.of(str) );
		Path pathReadme = Path.of("src/main/resources/public/readme.txt");
		
		System.out.println( "	+	Создание файла, папки, целевой папки вместе с недостающими");
		System.out.println( Files.createFile( Path.of(strResPub + "1111.txt") ) );
		System.out.println( Files.createDirectory( Path.of(strResPub + "0") ) );
		System.out.println( Files.createDirectories( Path.of(strResPub + "0/1/2") ) );
		Files.delete( Path.of(strResPub + "1111.txt") );
		Files.delete( Path.of(strResPub + "0/1/2") );
		Files.delete( Path.of(strResPub + "0/1") );
		Files.delete( Path.of(strResPub + "0") );
		
		System.out.println( "	+	Копирование, перемещение, удаление, сравнение");
		Path path0 = Path.of("src/main/resources/public/0.txt");
		Path path1 = Path.of("src/main/resources/public/01.txt");
		Path path2 = Path.of("src/main/resources/public/02.txt");
		System.out.println( Files.copy(path0, path1) );
		System.out.println( "одинаковые ли: " + Files.isSameFile(path0, path1) );
		System.out.println( Files.move(path1, path2) );
		Files.delete(path2);
		
		System.out.println( "	+	Проверки");
		System.out.println( "файл ли: " + Files.isRegularFile(Path.of(str)) );
		System.out.println( "папка ли: " + Files.isDirectory(Path.of(str)));
		System.out.println( "существует ли: " + Files.exists(Path.of("src/main/resources/public/00.txt")));
		System.out.println( "одинаковые ли: " + Files.isSameFile(path0, pathReadme) );
		System.out.println( "размер: " + Files.size(Path.of(str)) );
		
		System.out.println( "	+	Чтение файла");
		List<String> list = Files.readAllLines( path0 );
		for (String s : list)
			System.out.println( s );
		
		System.out.println( "	+	Содержимое папки (поток необходимо закрывать)");
		try (DirectoryStream<Path> files = Files.newDirectoryStream( path0.getParent() )) {
			for (Path path : files) {
				System.out.println(path);
			}
		}
		
		System.out.println( "	+	Потоки чтения и записи файла" );
		Path path00 = Path.of("src/main/resources/public/00.txt");
		Files.createFile( path00 );
		InputStream input = Files.newInputStream( path00 );
		input.close();
		OutputStream output = Files.newOutputStream( path00 );
		output.close();
		Files.delete( path00 );
		
		
	}
}
