package JavaRushSolution;

public abstract class DrinkMaker {
	abstract void getRightCup();
	abstract void putIngredient();
	abstract void pour();
	
	public void makeDrink() {
		getRightCup();
		putIngredient();
		pour();
	}
}
