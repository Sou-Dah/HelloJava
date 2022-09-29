package Hello.HelloCollections;

/*
Появился в Java 5
Важный момент, т.к. значения типа enum представляют собой фиксированный набор констант, их можно сравнивать через ==.
 Ну не может существовать двух одинаковых объектов MONDAY с разными ссылками. Каждый объект-значение типа enum 
 существует только в единственном экземпляре. Поэтому сравнение переменных типа enum через == всегда будет работать.
 */

public class HelloEnumeration {
	enum Day
	{
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY
	}
	
	public static void main(String[] args) {
		Day day;
		
		//	Массив значений
		Day[] days = Day.values();
		
		//	Порядковый номер значения
		int i = Day.FRIDAY.ordinal();
		
		//	Получение объекта по названию
		day = Day.valueOf("TUESDAY");
		
		//	Получение объекта по номеру
		day = Day.values()[3];
		
	}
}
