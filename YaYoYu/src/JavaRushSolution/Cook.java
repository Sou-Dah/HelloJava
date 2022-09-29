package JavaRushSolution;

public class Cook implements Runnable {
	public boolean continueWorking = true;
	
	@Override
	public void run() {
		boolean needToWait;
		while (continueWorking || needToCookOrders()) {
			try {
				
				synchronized (this) {
					needToWait = !needToCookOrders();
					if (!needToWait) {
						cook();
					}
				}
				
				if (continueWorking && needToWait) {
					System.out.println("Повар отдыхает");
					Thread.sleep(100);
				}
				
			} catch (InterruptedException e) {
			}
		}
	}
	
	private boolean needToCookOrders() {
		return !Manager.getInstance().getOrderQueue().isEmpty();
	}
	
	private void cook() throws InterruptedException {
		Manager manager = Manager.getInstance();
		Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
		System.out.println(String.format("Повар Заказ для стола №%d будет готовить %d мс", order.getTableNumber(),
										 order.getTime()));
		Thread.sleep(order.getTime());     // готовим блюдо
		Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
		manager.getDishesQueue().add(dishes);
		System.out.println(String.format("Повар Заказ для стола №%d приготовил", dishes.getTableNumber()));
	}
}
