package Hello.HelloThread;

/*
Условия создания новой нити в классе:
implements Runnable
extends Thread

НЕВОЗМОЖНО отменить выполнение и остановить нить извне.
Можно дать сигнал нити на завершение, например через общую переменную типа boolean.

Короче говоря, если поток заснет на 100 лет, а мы его прервем, то узнает он об этом лишь по прошествии этих 100 лет, 
так как условия выхода из цикла никто не проверял все это время. Именно поэтому метод join и sleep постоянно 
проверяют, не был ли изменен флаг текущего потока, и если был, то нафиг ждать 100 лет, выбрасываем 
InterruptedException и поехали дальше.

Если на спящую нить воздействовать методом interrupt, то она выбросит InterruptedException. При этом флагу будет также
выставлено значение false.
1. Либо убрать проверку if (Thread.interrupted()), которая сбрасывает флаг прерывания, либо восстанавливать значение 
флага прерывания после его сброса.
2. В блоке catch восстанавливать флаг прерывания Thread.currentThread().interrupt();


interrupt() - ставит флаг нити на true для остановки
isInterrupted() - не статический метод для проверки флага (не трогает его значение)
Thread.interrupted() - статический метод Thread, который проверяет значение флага только для ТЕКУЩЕЙ НИТИ 
и сбрасывает его, переводя в false 

Важно знать, что wait, join и sleep (всё то, что бросает исключение InterruptedException) осуществляет проверку 
через Thread.interrupted(), а не isInterrupted().
Если тред прервется во время "сна", то будет выброшено InterruptedException, а флаг вернется в состояние false. 
Из-за этого тред продолжит свою работу, даже не зная, что был прерван.
 
 */
/*

interrupt() - ставит флаг треда на true (тред прерван)
isInterrupted() - не статический метод для проверки флага (не трогает значение флага)
Thread.interrupted() - статический метод Thread, который проверяет значение флага и сбрасывает его (переводит в false) 

Важно знать, что wait, join и sleep (все то, что бросает исключение InterruptedException) осуществляет проверку 
через Thread.interrupted(), а не isInterrupted(). 

Это важно, потому что иначе получится неожиданная ситуация, например, такая:

public void run() {
    while (!Thread.currentThread().isInterrupted()) {
        System.out.println(("Тред работает"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

Если тред прервется во время "сна", то будет выброшено InterruptedException, а флаг вернется в состояние false. 
Из-за этого тред продолжит свою работу, даже не зная, что был прерван.

В конкретном примере это можно исправить либо так:

public void run() {
    try {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(("Тред работает"));
            Thread.sleep(1000);
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

Либо так:

public void run() {
    while (!Thread.currentThread().isInterrupted()) {
        System.out.println(("Тред работает"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

Либо так:

public void run() {
    while (!Thread.currentThread().isInterrupted()) {
        System.out.println(("Тред работает"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            break;
        }
    }
}
 */

public class HelloThread {
	// Ключевое слово volatale:
	// 1) принуждвет всегда атомарно писать и читать 64-битные данные,
	// 2) запрещает помещать переменную в кэш процессора.
	public static volatile long l = 345345345345345L;
	public static volatile double d = 345345345345345.434343;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		// Приостановить текущую нить на 1000 мс (1 секунду)
		// При этом происходит постоянная проверка isInterrupted
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Создание новой нити и назначение ей класса на выполнение
		Thread runnableCat = new Thread(new HelloThread.RunnableCat(), "runnableCat");
		ThreadCat threadCat = new HelloThread.ThreadCat("threadCat");
		
		// Запуск нити в работу
		runnableCat.start();
		threadCat.start();
		
		// Текущая нить ожидает завершения другой
		// При этом происходит постоянная проверка isInterrupted
		runnableCat.join();
		threadCat.join();
		
		// Переводится "уступать"
		// Досрочное завершение процессорного микровремени работы текущей нити и переключение на следующую нить
		// Сон 0 мс работает также 
		Thread.yield();
		Thread.sleep(0);
		
		// При расширении класса Thread можно в конструкторе дать ему название
		System.out.println(Thread.currentThread().getName());
		System.out.println(runnableCat.getName());
		System.out.println(threadCat.getName());
		System.out.println(new Thread().getName());
		System.out.println(new Thread().getName());
		System.out.println(new Thread(new HelloThread.RunnableCat()).getName());
		System.out.println(new HelloThread.ThreadCat().getName());
		
		// 
		threadCat.setPriority(Thread.MAX_PRIORITY);
		
		// Подача сигнала на остановку
		Thread threadClock = new Thread(new Clock());
		threadClock.start();
		Thread.sleep(5_000);
		threadClock.interrupt();
		
	}
	
	public static class ThreadCat extends Thread {
		
		@Override
		public void run() {
			System.out.println(getName());
			System.out.println("Run, ThreadCat");
		}
		
		public ThreadCat() { }
		
		public ThreadCat(String name) { super(name); }
		
	}
	
	public static class RunnableCat implements Runnable {
		
		@Override
		public void run() {
			System.out.println("Run, RunnableCat");
		}
		
	}
	
	public static class Clock implements Runnable {
		public void run() {
			// Получение объекта вызвавшей нити
			Thread current = Thread.currentThread();
			
			// Выполнение, пока переменная isInterrupted вызвавшей нити позволяет
			while (!current.isInterrupted()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					current.interrupt();
				}
				
				System.out.println("Tik");
			}
		}
		
	}
	
}
