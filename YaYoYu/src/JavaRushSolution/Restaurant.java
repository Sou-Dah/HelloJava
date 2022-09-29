package JavaRushSolution;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
*/

public class Restaurant {
	public static List<Thread> threads = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Waiter waiterTarget = new Waiter();
		Thread waiter = new Thread(waiterTarget);
		threads.add(waiter);
		
		Cook cookTarget = new Cook();
		Thread cook = new Thread(cookTarget);
		threads.add(cook);
		
		waiter.start();
		cook.start();
		
		Thread.sleep(2000);
		cookTarget.continueWorking = false;
		Thread.sleep(500);
		waiterTarget.continueWorking = false;
		
		System.out.println("- - Очередь заказов: " + Manager.getInstance().getOrderQueue().size());
		System.out.println("- - Очередь готовых блюд: " + Manager.getInstance().getDishesQueue().size());
	}
}
