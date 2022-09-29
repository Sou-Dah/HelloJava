package Hello.HelloExceptions;
/*
интерфейс UncaughtExceptionHandler
У объекта типа Thread есть специальный метод – setUncaughtExceptionHandler. В него нужно передать объект, 
который реализует интерфейс Thread.UncaughtExceptionHandler. У этого интерфейса есть всего один метод 
uncaughtException(Thread t, Throwable e). Именно этот метод будет вызван у переданного объекта, если внутри метода 
run возникнет исключение, которое не будет захвачено.
 */

public class HelloExceptions extends Thread {
	public static void main(String[] args) {
		
		try {
			System.out.println("начало");
		} finally {
			System.out.println("выполнение с пробросом исключения дальше");
		}
		
		Thread thread = new HelloExceptions();
		
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// Что делать?
				
			}
		});
		
		thread.start();
	}
	
}
