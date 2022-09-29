package Hello.HelloCollections;

import java.util.*;

/*
List	ArrayList	
List	LinkedList	
List	Vector		
List	Stack
 */
public class HelloList {
	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("Mama");
		arraylist.add("Mila");
		arraylist.add("Ramu");
		arraylist.addAll( List.of("Мама",
								  "Мыла",
								  "Раму") );
		
		// Упрощенное заполнение списка
		ArrayList<String> list1 = new ArrayList<String>()
		{{
			add("Привет");
			add("Как");
			add("Дела");
		}};
		
		List<String> list = Arrays.asList("1", "2");
		
		
		// Сжатие внутреннего массива до заполненного размера  
		arraylist.trimToSize();
		
		Iterator<String> iterator = arraylist.iterator();//получение итератора для списка
		
		while (iterator.hasNext()) {      //проверка, есть ли ещё элементы
			//получение текущего элемента и переход на следующий
			String text = iterator.next();
			
			System.out.println(text);
		}
		
		// Stack стопка - разновидность List списка
		//   Object push() - добавляет элемент в верх стопки
		//    Object pop() - возвращает верхний элемент и удаляет его из стопки
		//   Object peek() - возвращает верхний элемент, оставляя на прежнем месте
		//    int search() - поиск позиции элемента в стопке от вершины, при отсутствии возвращается -1
		// boolean empty() - пуста ли стопка
		Stack<String> stack = new Stack<>();
		
	}
}
