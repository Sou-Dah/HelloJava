package Hello.HelloThread;

/*
интерфейс UncaughtExceptionHandler
У объекта типа Thread есть специальный метод – setUncaughtExceptionHandler. В него нужно передать объект, 
который реализует интерфейс Thread.UncaughtExceptionHandler. У этого интерфейса есть всего один метод 
uncaughtException(Thread t, Throwable e). Именно этот метод будет вызван у переданного объекта, если внутри метода 
run возникнет исключение, которое не будет захвачено.
 */

/* 
Отдебажим все на свете
Java Core level 6 task 21
*/

public class HelloUncaughtExceptionHandler {
	public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();
	
	public static void main(String[] args) {
		TestedThread commonThread = new TestedThread(handler);
		
		Thread threadA = new Thread(commonThread, "Нить 1");
		Thread threadB = new Thread(commonThread, "Нить 2");
		
		threadA.setUncaughtExceptionHandler(handler);
		threadB.setUncaughtExceptionHandler(handler);
		
		threadA.start();
		threadB.start();
		
		threadA.interrupt();
		threadB.interrupt();
	}
	
	public static class TestedThread extends Thread {
		public TestedThread(Thread.UncaughtExceptionHandler handler) {
			setUncaughtExceptionHandler(handler);
			start();
		}
		
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				throw new RuntimeException("My exception message");
			}
		}
	}
	
	public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(t.getName() + ": " + e.getMessage());
		}
	}
}
