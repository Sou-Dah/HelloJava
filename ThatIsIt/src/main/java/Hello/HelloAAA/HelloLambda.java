package Hello.HelloAAA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
Лямбда-выражения можно писать только для интерфейсов с одним методом.
	
В Java есть интерфейс Consumer<Тип> (Consumer == Потребитель), который содержит метод accept(Тип obj).
В Java 8 у коллекций появился метод forEach(), который позволяет для каждого элемента коллекции выполнить 
какое-нибудь действие. И вот для передачи действия в метод forEach() как раз и используется функциональный интерфейс 
Consumer<T>.

	Ссылка на метод объекта
	объект::метод
Этот код эквивалентен коду x -> объект.метод(x).
В качестве объекта могут фигурировать такие специальные переменные как this и super.

	Ссылка на метод класса
	класс::метод
Этот код будет преобразован к коду вида x -> класс.метод(x);

	Ссылка на конструктор
	класс::new
Например, можно обойти стирание типов у коллекций и передать в метод toArray() ссылку на конструктор, который 
создаст нужный массив: toArray( int[]::new );
 */
public class HelloLambda {
	public static void main(String[] args) {
		
		System.out.println("	+	Сравнение строк по длине своим анонимным сравнителем");
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll( list, "Привет", "как", "дела?" );
		Comparator<String> comparator = new Comparator<String>() {
			
			public int compare (String obj1, String obj2) {
				return obj1.length() - obj2.length();
			}
		};
		Collections.sort(list, comparator);
		
		
		System.out.println("	+	Сравнение строк по длине своим лямбда-сравнителем");
		Comparator<String> stringComparator = (String str1, String str2) -> {
			return str1.length() - str2.length();
		};
		Collections.sort( list, stringComparator );
		
		Collections.sort( list, (String str1, String str2) -> {
			return str1.length() - str2.length();
		});
		
		//	Если в коде метода одна команда, то фигурные скобки и return можно не писать
		Collections.sort( list, (str1, str2) -> str1.length() - str2.length() );
		
		
		System.out.println("	+	Функциональный интэрфэйс Consumer<T> используется для передачи действия в метод");
		System.out.println("	+	Вывод элементов коллекции в консоль, способ 1");
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println( s );
			}
		});
		
		
		System.out.println("	+	Вывод элементов коллекции в консоль, способ 2");
		list.forEach( (s) -> System.out.println( s ) );
		
		System.out.println("	+	Вывод элементов коллекции в консоль, способ 3");
		//	Если параметр только один, то можно опустить скобки
		list.forEach( s -> System.out.println( s ) );
		
		System.out.println("	+	Вывод элементов коллекции в консоль, способ 3");
		//	x -> объект.метод(x)
		//	заменяется на
		//	объект::метод
		list.forEach( System.out::println );
		
		
		System.out.println("	+	Поиск строки наибольшей длины длинно");
		Stream<String> stream = list.stream();
		Optional<String> optional = stream.max((s1, s2) -> s1.length() - s2.length());
		String strMax = optional.get();
		System.out.println( strMax );
		
		System.out.println("	+	Поиск строки наибольшей длины коротко");
		strMax = list.stream().max((s1, s2) -> s1.length() - s2.length()).get();
		System.out.println( strMax );
		
	}
}
