package Hello.HelloCollections;
/*
List	ArrayList	
List	LinkedList	
List	Vector		
List	Stack		

Set		HashSet		
Set		TreeSet		
Set		SortedSet	

Map		HashMap		
Map		TreeMap		
Map		SortedMap	
Map		HashTable	

 */

import java.util.*;

public class HelloCollections {
	
	//	Заполнение списка неизвестной длины из конструктора
	public String name;
	public ArrayList<String> assets = new ArrayList<>();
	public HelloCollections(String name, String... assets) {
		this.name = name;
		if (assets != null) {
			this.assets.addAll(Arrays.asList(assets));
		}
	}
	
	public static void main(String[] args) {
		//	Двумерный массив
		//	int[][] имя = new int[ширина][высота]; или
		//	int[][] имя = new int[ширина][высота]; - зависит от договорённостей или от ТЗ
		int[][] matrix = {
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5} 
		};
		int[] row1 = matrix[0];
		int[] row2 = matrix[1];
		
		//	Перемена строк местами
		int[] tmp = matrix[0];
		matrix[0] = matrix[1];
		matrix[1] = tmp;
		
		//	Неровный массив
		int[][] data = new int[2][];
		data[0] = new int[10];
		data[1] = new int[50];
		
		//	Заполнение одномерного массива одинаковыми значениями
		Arrays.fill(data[0], 999);
		Arrays.fill(data[1], 0, 9, 555);
		Arrays.fill(data[1], 10, 19, 222);
		Arrays.fill(data[1], 20, 29, 333);
		Arrays.fill(data[1], 30, 39, 444);
		Arrays.fill(data[1], 40, 49, 111);
		
		//	Вывод многомерного массива
		System.out.println( Arrays.deepToString(matrix) );
		
		//	Сравнение ссылок в массивах
		System.out.println( Arrays.equals(matrix, data) );
		
		//	Сравнение многомерных массивов
		System.out.println( Arrays.deepEquals(matrix, data) );
		
		//	Сортировка по возрастанию всего массива или его части
		Arrays.sort( matrix[1] );
		Arrays.sort( matrix[1], 1, 3 );
		
		int index1 = Arrays.binarySearch(data[1], 0);
		int index2 = Arrays.binarySearch(data[1], -20);
		int index3 = Arrays.binarySearch(data[1], 99);
		int index4 = Arrays.binarySearch(data[1], 5);
		
		
		
		String mercury = new String("Меркурий");
		String venus = new String("Венера");
		String earth = new String("Земля");
		String mars = new String("Марс");
		String jupiter = new String("Юпитер");
		String saturn = new String("Сатурн");
		String uranus = new String("Уран");
		String neptune = new String("Нептун");
		
		// Создание массива
		String[] solarSystemArray = {mercury, venus, earth, mars, jupiter, saturn, uranus, neptune};
		System.out.println("\t+ массив \n" + Arrays.toString(solarSystemArray));
		
		//	Заполнение массива начальными значениями
		Byte[] bytes = new Byte[255];
		Arrays.fill(bytes, (byte) 0);
		
		// Создание списка через массив
		ArrayList<String> solarSystem = new ArrayList<>(Arrays.asList(mercury, venus, earth, mars,
																	  jupiter, saturn, uranus, neptune));
		System.out.println("\t+ список через массив \n" + solarSystem);
		
		//	void sort(int[] myArray, int fromIndex, int toIndex) сортирует массив целых чисел или его подмассив по 
		// возрастанию.
		
		//	int binarySearch(int[] myArray, int fromIndex, int toIndex, int key). Этот метод ищет элемент key в уже 
		//	отсортированном массиве myArray или подмассиве, начиная с fromIndex и до toIndex. Если элемент найден, 
		//	метод возвращает его индекс, если нет - (-fromIndex)-1.
		
		// Перестановка элементов местами
		Collections.swap(solarSystem, solarSystem.indexOf(mercury), solarSystem.indexOf(neptune));
		System.out.println("\t+ Перестановка \n" + solarSystem);
		
		// Упрорядочивание по возрастанию
		Collections.sort(solarSystem);
		System.out.println("\t+ по возрастанию \n" + solarSystem);
		
		// Изменение порядка на противоположный
		Collections.reverse(solarSystem);
		System.out.println("\t+ обратный порядок \n" + solarSystem);
		
		// Хаотичное перемешивание
		Collections.shuffle(solarSystem);
		System.out.println("\t+ перемешивание \n" + solarSystem);
		
		// Создание неизменяемой копии
		List<String> solarSystemReserved = Collections.unmodifiableList(solarSystem);
		
		// Разные ли (правда или ложь) два списка (нет ни одного одинакового элемента)
		ArrayList<String> solarSystemPart1 = new ArrayList<>(Arrays.asList(mercury, venus, earth, mars));
		ArrayList<String> solarSystemPart2 = new ArrayList<>(Arrays.asList(jupiter, saturn, uranus, neptune));
		System.out.println("Разные ли: " + Collections.disjoint(solarSystemPart1, solarSystemPart2));
		
		// Наибольшее и наименьшее значения
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
		System.out.println("большее: " + Collections.max(numbers));
		System.out.println("меньшее: " + Collections.min(numbers));
		
		
		// Упрощенное заполнение списка
		ArrayList<String> list = new ArrayList<String>()
		{{
			add("Привет");
			add("Как");
			add("Дела");
		}};
		
	}
}
