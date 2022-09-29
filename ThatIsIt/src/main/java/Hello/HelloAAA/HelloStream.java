package Hello.HelloAAA;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Stream - это interface
Расширенная поддержка потоков появилась в Java 8
	Stream<Тип> имя = Arrays.stream(массив);
	Stream<Тип> имя = коллекция.stream();
	
			Методы	Описание
	Stream<T> of()	Создает поток из набора объектов
	Stream<T> generate()	Генерирует поток по заданному правилу
	Stream<T> concat()	Объединяет вместе несколько потоков
	Stream<T> filter()	Фильтрует данные: пропускает только данные, которые соответствуют заданному правилу
	Stream<T> distinct()	Удаляет дубликаты: не пропускает данные, которые уже были
	Stream<T> sorted()	Сортирует данные
	Stream<T> peek()	Выполняет действие над каждым данным
	Stream<T> limit(n)	Обрезает данные после достижения лимита
	Stream<T> skip(n)	Пропускает первые n данных
	Stream<R> map()	Преобразовывает данные из одного типа в другой
	Stream<R> flatMap()	Преобразовывает данные из одного типа в другой
	boolean anyMatch()	Проверяет, что среди данных потока есть хоть одно, которое соответствует заданному правилу
	boolean allMatch()	Проверяет, что все данные в потоке соответствуют заданному правилу
	boolean noneMatch()	Проверяет, что никакие данные в потоке не соответствуют заданному правилу
	Optional<T> findFirst()	Возвращает первый найденный элемент, который соответствует правилу
	Optional<T> findAny()	Возвращает любой элемент из потока, который соответствует правилу
	Optional<T> min()	Ищет минимальный элемент в потоке данных
	Optional<T> max()	Возвращает максимальный элемент в потоке данных
	long count()	Возвращает количество элементов в потоке данных
	R collect()	Вычитывает все данные из потока и возвращает их в виде коллекции

 */
public class HelloStream {
	public static void main(String[] args) {
		Stream stream, stream1, stream2;
		
		
		System.out.println("	+	Создание потока из списка");
		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list, "Привет", "как", "дела");
		Stream<String> streamList = list.stream();
		
		
		System.out.println("	+	Создание потока из массива");
		Integer[] array = {1, 2, 3};
		Stream<Integer> streamArray = Arrays.stream(array);
		
		
		//	Stream<T>.of(T obj)
		System.out.println("	+	Создание потока из элемента");
		System.out.println("	Stream<T>.of(T obj)");
		Stream<Integer> oneElementStream = Stream.of( 1 );
		
		
		//	Stream<T> Stream.of(T obj1, T obj2, T obj3, ...)
		System.out.println("	+	Создание потока из нескольких элементов");
		System.out.println("	Stream<T> Stream.of(T obj1, T obj2, T obj3, ...)");
		Stream<Integer> aFewElementsStream = Stream.of( 1, 2, 3, 4, 5 );
		
		
		//	Stream<T> Stream.generate(Supplier<T> obj)
		//	Ограничения задаются с помощью метода .limit(5)
		System.out.println("	+	Создание потока по правилу");
		System.out.println("	Stream<T> Stream.generate(Supplier<T> obj)");
		Stream<Double> randomDoubleSream = Stream.generate( Math::random );
		
		
		//	Stream<T> Stream.concat(Stream<T> a, Stream<T> b)
		System.out.println("	+	Новый объединённый поток");
		System.out.println("	Stream<T> Stream.concat(Stream<T> a, Stream<T> b)");
		Stream<Integer> int1stream = Stream.of( 1, 2, 3, 4, 5 );
		Stream<Integer> int2stream = Stream.of( 6, 7, 8, 9, 0 );
		Stream<Integer> concatStream = Stream.concat( int1stream, int2stream );
		
		
		//	Stream<T> filter(Predicate<T>)
		System.out.println("	+	Новый просеенный поток из старого");
		System.out.println("	Stream<T> filter(Predicate<T>)");
		
		//	Остаются только числа меньше трёх
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		int2stream = int1stream.filter( x -> (x < 3) );
		
		//	Остаются только числа больше нуля
		int1stream = Stream.of( 0, 1, -2, 3, -4, 5 );
		int2stream = int1stream.filter( x -> (x > 0) );
		
		
		//	Stream<T> sorted(Comparator<T>)
		System.out.println("	+	Новый отсортированный поток из старого");
		System.out.println("	Stream<T> sorted(Comparator<T>)");
		
		
		//	Stream<T> distinct()
		System.out.println("	+	Новый поток с удалёнными повторами");
		System.out.println("	Stream<T> distinct()");
		int1stream = Stream.of( 1, 2, 3, 4, 5, 2, 2, 2, 3, 4 );
		int2stream = int1stream.distinct();
		
		
		//	Stream<T> peek(Consumer<T>)
		System.out.println("	+	Новый поток с обязательной функцией для элементов при их вызове");
		System.out.println("	Stream<T> peek(Consumer<T>)");
		//	Вывод объектов в момент прохождения в потоке
		int1stream = Stream.of( 1, 2, 3, 4, 5, 2, 2, 2, 3, 4 );
		int2stream = int1stream.peek( System.out::println );
		System.out.println( int2stream );
		
		//	Но так как метод peek работает с Consumer, модификации строк в Stream не произойдет, а сам peek вернет 
		//	Stream с изначальными элементами: такими, какими они ему пришли.
		//
		//	Поэтому список peopleGreetings будет состоять из элементов "Elena", "John", "Alex", "Jim", "Sara".
		List<String> peopleGreetings = Stream.of("Elena", "John", "Alex", "Jim", "Sara")
											   .peek(x -> System.out.println("Hello " + x + " !!!"))
											   .collect(Collectors.toList());
		
		
		//	Stream<T> limit(int n)
		System.out.println("	+	Новый поток из только первых \"n\" данных");
		System.out.println("	Stream<T> limit(int n)");
		int1stream = Stream.of( 1, 2, 3, 4, 5, 2, 2, 2, 3, 4 );
		int2stream = int1stream.limit( 3 );
		System.out.println(int2stream);
		
		
		//	Stream<T> skip(int n)
		System.out.println("	+	Новый поток с пропуском первых \"n\" данных");
		System.out.println("	Stream<T> skip(int n)");
		System.out.println("	Stream<T> skip(int n)");
		int1stream = Stream.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 );
		int2stream = int1stream.skip( 4 );
		
		
		//	Stream<R> map()	
		System.out.println("	+	Новый поток с пребразованными данными");
		//	Число в строку
		//	Подробная запись
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		Stream<String> strStream = int1stream.map( x -> String.valueOf(x) );
		//	Короткая запись
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		strStream = int1stream.map( String::valueOf );
		
		//	Строка в число
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		strStream = int1stream.map( String::valueOf );
		int2stream = strStream.map( Integer::parseInt );
		
		//	Строки в URI
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.addAll(List.of(
				"https://google.com",
				"https://linkedin.com",
				"https://yandex.com"
								));
//		Stream<URI> uriStream = arrayList.stream().map( URI::new );
		Stream<URI> uriStream = arrayList.stream().map( str -> {
			try {
				return new URI( str );
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return null;
			}
		});
		
		
		//	boolean anyMatch()
		System.out.println("	+	Проверки потоков на хоть одно совпадение");
		System.out.println("	anyMatch");
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		boolean iaAnyMatch = int1stream.anyMatch( x -> x > 0 );
		System.out.println("iaAnyMatch = " + iaAnyMatch);
		
		int1stream = Stream.of( 1, -2, 3, -4, 5 );
		iaAnyMatch = int1stream.anyMatch( x -> x > 0 );
		System.out.println("iaAnyMatch = " + iaAnyMatch);
		
		int1stream = Stream.of( 1, -2, 3, -4, 5 );
		iaAnyMatch = int1stream.filter(x -> x < 0).anyMatch(x -> x > 0);
		System.out.println("iaAnyMatch = " + iaAnyMatch);
		
		
		//	boolean allMatch()
		System.out.println("	+	Проверки потоков на совпадение всех элементов");
		System.out.println("	allMatch");
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		
		boolean isAllMatch = int1stream.allMatch( x -> x > 0 );
		System.out.println("isAllMatch = " + isAllMatch);
		
		int1stream = Stream.of( 1, -2, 3, -4, 5 );
		isAllMatch = int1stream.allMatch( x -> x > 0);
		System.out.println("isAllMatch = " + isAllMatch);
		
		int1stream = Stream.of( 1, -3, -3, -4, 5 );
		isAllMatch = int1stream.filter(x -> x<0).allMatch(x -> x<0);
		System.out.println("isAllMatch = " + isAllMatch);
		
		//	boolean noneMatch()
		System.out.println("	+	Проверки потоков на отсутствие совпадений");
		System.out.println("	noneMatch");
		int1stream = Stream.of( 1, 2, 3, 4, 5 );
		boolean noneMatch = int1stream.noneMatch( x -> x > 0 );
		System.out.println("noneMatch = " + noneMatch);
		
		int1stream = Stream.of( 1, -2, -3, -4, 5 );
		noneMatch = int1stream.noneMatch( x -> x > 0 );
		System.out.println("noneMatch = " + noneMatch);
		
		int1stream = Stream.of( 1, -2, 3, -4, 5 );
		noneMatch = int1stream.filter(x -> x<0).noneMatch(x -> x>0);
		System.out.println("noneMatch = " + noneMatch);
		
		
		//	Optional<T> findFirst()
		//	Optional<T> findAny()
		//	Аналог предыдущего для параллельноой обработки
		System.out.println("	+	Поиск в потоках");
		System.out.println("	Optional<T> findFirst()");
		System.out.println("	Optional<T> findAny()");
		arrayList.clear();
		arrayList.addAll( List.of(
				"Привет",
				"как",
				"дела?"
								));
		//	Просто первый элемент из потока
		String str = arrayList.stream().findFirst().get();
		System.out.println("str = " + str);
		
		
		//	Optional<T> max(Comparator<T>)
		System.out.println("	Optional<T> max(Comparator<T>)");
		String max = arrayList.stream().max( (s1, s2) -> s1.length() - s2.length() ).get();
		System.out.println("max = " + max);
		
		//	Optional<T> min(Comparator<T>)
		System.out.println("	Optional<T> min(Comparator<T>)");
		String min = arrayList.stream().min( (s1, s2) -> s1.length() - s2.length() ).get();
		System.out.println("min = " + min);
		
		
		//	R collect()	В
		System.out.println("	+	Преобразование потока в список");
		System.out.println(arrayList);
		List<String> resList = arrayList.stream()
			//	Просеиваем строки с заглавным первым символом
				.filter( s -> Character.isUpperCase(s.charAt(0)) )
				.collect( Collectors.toList() );
		System.out.println(resList);
		
		
		//	R collect()	В
		System.out.println("	+	Преобразование потока в множество");
		Set<String> resSet = arrayList.stream()
			//	Просеиваем строки с заглавным первым символом
				.filter( s -> Character.isUpperCase(s.charAt(0)) )
				.collect( Collectors.toSet() );
		System.out.println(resSet);
		
		
		//	R collect()	В
		System.out.println("	+	Преобразование потока в словарь");
		ArrayList<String> als = new ArrayList<>();
		Collections.addAll(als, "a=2", "b=3", "c=4", "d==3");
		Map<String, String> resMap = list.stream()
			//	Преобразование каждой строки в массив строк, разделяя знаком "="
				.map( e -> e.split("-") )
			//	Просеивание массивов с длиной 2
				.filter( e -> e.length == 2 )
			//	Первая функция даёт ключ, вторая - значение
				.collect( Collectors.toMap( e -> e[0], e -> e[1] ) );
		
		
		//	R collect()	В
		System.out.println("	+	Преобразование потока в строку");
		System.out.println( als );
		String resStr = als.stream().collect( Collectors.joining( ", " ) );
		System.out.println( resStr );
		
		
	}
}
