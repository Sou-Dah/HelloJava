package Hello.HelloAAA;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//	=	Predicate — ФИ для проверки соблюдения некоторого условия.
//	Если условие соблюдается, возвращает true, иначе — false.
//@FunctionalInterface
//public interface Predicate<T> {
//	boolean test(T t);
//}

//	=	Consumer (с англ. — “потребитель”) — ФИ для совершения некоторого действия с объектом Т,
//	при этом ничего не возвращая
//@FunctionalInterface
//public interface Consumer<T> {
//	void accept(T t);
//}

//	=	Supplier (с англ. — поставщик) — ФИ для возврата некоторого объекта Т и
//	при этом ничего не принимая
//@FunctionalInterface
//public interface Supplier<T> {
//	T get();
//}

//	=	Function — ФИ принимает аргумент T и приводит его к объекту типа R,
//	который и возвращается как результат
//@FunctionalInterface
//public interface Function<T, R> {
//	R apply(T t);
//}

//	=	UnaryOperator — ФИ принимает объект типа T, выполняет над ним некоторые операции и 
//	возвращает результат операций в виде объекта того же типа T
//@FunctionalInterface
//public interface UnaryOperator<T> {
//	T apply(T t);
//}

public class HelloFunctionalInterfaces {
	public static void main(String[] args) {
		System.out.println("	=	Predicate");
		System.out.println("	=	Проверять на чётность числа типа Integer");
		Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
		System.out.println( isEvenNumber.test(4) );
		System.out.println( isEvenNumber.test(3) );
		
		
		System.out.println("	=	Consumer");
		System.out.println("	=	Вывод приветствия с переданной строкой");
		Consumer<String> greetings = x -> System.out.println("Hello, " + x + " !!!");
		greetings.accept("Elena");
		
		
		System.out.println("	=	Supplier");
		System.out.println("	=	Случайное имя из списка");
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.addAll( List.of("Elena",
								 "John",
								 "Alex",
								 "Jim",
								 "Sara") );
		Supplier<String> randomName = () -> {
			int value = (int)(Math.random() * nameList.size());
			return nameList.get( value );
		};
		System.out.println( randomName.get() );
		
		System.out.println("	=	Supplier");
		System.out.println("	=	Случайные имена из списка");
		Stream.generate(() -> {
			int value = (int) (Math.random() * nameList.size());
			return nameList.get( value );
		}).limit(5).forEach(System.out::println);
		
		
		System.out.println("	=	Function");
		System.out.println("	=	Преобразование строк в числа");
		Function<String, Integer> valueConverter = x -> Integer.parseInt( x );
		System.out.println( valueConverter.apply("3456") );
		System.out.println("	=	Преобразование массива строк в массив чисел");
		List<Integer> values = Stream.of("32", "43", "74", "54", "3")
				.map(x -> Integer.parseInt(x)).collect( Collectors.toList() );
		System.out.println(values);
		
		
		System.out.println("	=	UnaryOperator");
		System.out.println("	=	Возведение в квадрат");
		UnaryOperator<Integer> squareValue = x -> x * x;
		System.out.println( squareValue.apply( 5 ) );
		System.out.println("	=	Возведение в квадрат несклько раз");
		Stream.iterate(9, x -> x * x).limit(4).forEach(System.out::println);
		
	}
}
