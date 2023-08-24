package designpatterns.behavioural.template;

public class TemplateDpMain {

	public static void main(String[] args) {
		WashingService bike = new Bike();
		WashingService car = new Car();
		bike.service();
		car.service();
	}

}

//concrete class
class Bike extends WashingService {

	@Override
	void applyShampoo() {
		System.out.println("Bike Shampoo Applied");

	}
}

class Car extends WashingService {

	@Override
	void applyShampoo() {
		System.out.println("Car Shampoo Applied");
	}
}

//abstract class
abstract class WashingService {
	void pourwater() {
		System.out.println("appling water");
	};

	void cleanWithCloth() {
		System.out.println("Finishing with cloth");
	};

	abstract void applyShampoo();

	void service() {
		pourwater();
		applyShampoo();
		cleanWithCloth();
	}
}