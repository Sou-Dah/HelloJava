package JavaRushSolution;

public class Waiter implements Runnable {
	public boolean continueWorking = true;
	
	@Override
	public void run() {
		Manager manager = Manager.getInstance();
		
		while (continueWorking || !manager.getDishesQueue().isEmpty()) {
			System.out.println("- - Очередь заказов: " + manager.getOrderQueue().size());
			System.out.println("- - Очередь готовых блюд: " + manager.getDishesQueue().size());
			
			// Если есть готовые блюда (очередь блюд не пуста)
			if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
				Dishes dishes = manager.getDishesQueue().poll();
				System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
			} else {                                         //берем новый заказ
				Table table = manager.getNextTable();
				Order order = table.getOrder();
				System.out.println("Официант Получил заказ от стола №" + order.getTableNumber());
				manager.getOrderQueue().add(order);
			}
			
			try {
				Thread.sleep(100);  //walking to the next table
			} catch (InterruptedException e) {
			}
			
		}
		
	}
	
}
