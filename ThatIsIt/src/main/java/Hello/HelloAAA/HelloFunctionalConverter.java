package Hello.HelloAAA;

/*
 	Аннотация @FunctionalInterface нужна для сообщения компилятору, что данный интерфейс функциональный и 
должен содержать не более одного обычного метода.
 	Статических может быть сколь угодно много.
 	Молчаливых может быть сколь угодно много.
 	Методы праотца всех классов - Object - могут быть
 */

@FunctionalInterface
public interface HelloFunctionalConverter <T, N> {
	N convert(T t);
	
	static <T> boolean isNotNull(T t) {
		return t != null;
	}
	
	default void writeToConsole(T t) {
		System.out.println("Текущий объект - " + t.toString());
	}
	
	boolean equals(Object obj);
	
}
