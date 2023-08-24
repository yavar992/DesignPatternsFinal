package designpatterns.creational.singleton;

public class SingletonDPMain {

	public static void main(String[] args) {

		Singleton firstInstance=Singleton.getInstance();
		
		System.out.println(firstInstance.hashCode());
		System.out.println(Singleton.getInstance().hashCode());
	}

}

//class
class Singleton {
	private static Singleton singletonInstance = new Singleton();

	private Singleton() {
		super();
	}

	static Singleton getInstance() {
		return singletonInstance;
	}

}