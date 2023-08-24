package designpatterns.structural.decorator;

public class DecoratorDpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza basePizza = new BasePizza();
		Pizza chicken = new Chicken(basePizza);
		System.out.println(chicken.getDescription());
		System.out.println(chicken.getPrice());
		Pizza corn = new Corn(chicken);
		System.out.println(corn.getDescription() + " " + corn.getPrice());
	}

}

//Decorator
abstract class ToppingAdder implements Pizza {
	Pizza pizza;

	public ToppingAdder(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getCost() {
		return pizza.getPrice();

	}

	public String getDescription() {
		return pizza.getDescription();
	}

}

class Chicken extends ToppingAdder {
	public Chicken(Pizza pizza) {
		super(pizza);
	}

	Pizza pizza;

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return super.pizza.getPrice() + 50;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() + " and Chicken ";
	}

}

class Corn extends ToppingAdder {
	public Corn(Pizza pizza) {
		super(pizza);
	}

	Pizza pizza;

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return super.pizza.getPrice() + 30;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.pizza.getDescription() + " and Corn ";
	}

}

//Concrete Decorator
//Componet
interface Pizza {
	int getPrice();

	String getDescription();

}

//Base Concrete Component
class BasePizza implements Pizza {

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return " Pizza with Cheese ";
	}
}