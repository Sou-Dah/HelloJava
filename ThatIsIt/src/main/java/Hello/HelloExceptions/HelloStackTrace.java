package Hello.HelloExceptions;
/*

   Вот что еще мы можем получить из StackTraceElement:

String getClassName() - Возвращает имя класса.
String getMethodName() - Возвращает имя метода.
String getFileName() - Возвращает имя файла (в одном файле может быть много классов).
int getLineNumber() - Возвращает номер строки в файле, в которой был вызов метода.
String getModuleName() - Возвращает имя модуля (может быть null).
String getModuleVersion() - Возвращает версию модуля (может быть null).

 */
public class HelloStackTrace {
	public static void main(String[] args) {
		method1();
		method2();
	}
	public static void method1() {
		//не вызывает ничего
	}
	public static void method2() {
		method3();
		method4();
	}
	public static void method3() {
		//не вызывает ничего
	}
	public static void method4() {
		method5();
	}
	public static void method5() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (StackTraceElement element:stackTraceElements) {
			System.out.println(element.getMethodName());
		}
	}
}
