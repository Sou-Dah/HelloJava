package Hello.HelloIO;

import java.nio.file.Path;
/*
	Path getParent()		Возвращает родительскую директорию
	Path getFileName()		Возвращает имя файла без директории
	Path getRoot()		Возвращает корневую директорию из пути
	boolean isAbsolute()		Проверяет, что текущий путь — абсолютный
	Path toAbsolutePath()		Преобразует путь в абсолютный
	Path normalize()		Убирает шаблоны в имени директории.
	Path resolve(Path other)		Строит новый абсолютный путь из абсолютного и относительного.
	Path relativize(Path other)		Получает относительный путь из двух абсолютных путей.
	boolean startsWith(Path other)		Проверяет, что текущий путь начинается с пути
	boolean endsWith(Path other)		Проверяет, что текущий путь заканчивается на путь
	int getNameCount()		Дробит путь на части с помощью разделителя /.
							Возвращает количество частей.
	Path getName(int index)		Дробит путь на части с помощью разделителя /.
								Возвращает часть по ее номеру.
	Path subpath(int beginIndex, int endIndex)		Дробит путь на части с помощью разделителя /.
													Возвращает часть пути, заданную интервалом.
	File toFile()		Преобразует объект Path в устаревший объект File
	URI toUri()		Преобразует объект Path в объект типа URI
	
	src/main/resources/public/0.txt
 */

public class HelloNIOfilePath {
	public static void main(String[] args) {
		Path path;
		
		//	Путь к файлу, которого может и не быть
		Path file = Path.of("c:\\projects\\note.txt");
		
		//	Путь к папке
		Path directory = Path.of("c:\\projects\\");
		
		
		String str = "c:\\windows\\projects\\note.txt";
		
		System.out.println( "	+ Родительская папка");
		System.out.println( Path.of(str).getParent() );
		System.out.println( Path.of(str).getParent().getParent() );
		System.out.println( Path.of(str).getParent().getParent().getParent() );
		System.out.println( Path.of(str).getParent().getParent().getParent().getParent() );
		
		System.out.println( "	+ Название файла или конечной папки");
		System.out.println( Path.of(str).getFileName() );
		System.out.println( Path.of(str).getParent().getFileName() );
		
		System.out.println( "	+ Абсолютный и относительный пути");
		System.out.println( Path.of( "c:\\windows\\projects\\note.txt").isAbsolute() );
		System.out.println( Path.of( "projects\\note.txt").isAbsolute() );
		
		System.out.println( "	+ Приведение к абсолютному пути");
		System.out.println(	Path.of( "ReadySteadyGo.java").toAbsolutePath() );
		
		System.out.println( "	+	Приведение к нормальному виду");
		System.out.println( Path.of("src\\com\\javarush\\..\\Main.java").normalize() );
		System.out.println( Path.of("src/main/resources/public/0.txt").normalize() );
		
		System.out.println( "	+	Вычисление относительного пути");
		System.out.println( "	+	Как из данного пройти к переданному");
		Path path1 = Path.of( "c:\\windows\\projects\\note.txt" );
		Path path2 = Path.of( "c:\\windows\\" );
		System.out.println( path1.relativize( path2 ));
		System.out.println( path2.relativize( path1 ));
		
		System.out.println( "	+	Приведение к стандарту URI");
		System.out.println( Path.of(str).toUri() );
		
	}
}
