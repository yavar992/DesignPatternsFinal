package designpatterns.creational.factorymethod;

public class FactoryMethodDPMain {

	public static void main(String[] args) {
		WashingService washingService = new DonysWashingService();
		washingService.washingFactory("car").startWashing();
		washingService.washingFactory("bike").startWashing();

	}

}

//Product
interface WashingService {
	WashingService washingFactory(String vehicle);

	void startWashing();
}

//Concrete product
class DonysWashingService implements WashingService {
	private Wash wash;

	@Override
	public WashingService washingFactory(String vehicle) {
		if (vehicle.equalsIgnoreCase("car")) {
			this.wash = new CarWash();
			return this;
		} else if (vehicle.equalsIgnoreCase("bike")) {
			this.wash = new BikeWash();
			return this;
		} else {
			System.out.println("Wrong vehicle");
			return this;
		}

	}

	@Override
	public void startWashing() {
		wash.wash();
	}

}

//Creator
interface Wash {
	void wash();
}

//Concrete Creator
class CarWash implements Wash {

	@Override
	public void wash() {

		System.out.println(this.getClass().getSimpleName() + " has been completed Please pay 100 ");
	}
}

class BikeWash implements Wash {

	@Override
	public void wash() {
		System.out.println(this.getClass().getSimpleName() + " has been completed Please pay 500 ");
	}
}