package designpatterns.structural.flyweight;

import java.util.HashSet;

public class FlyweightDPMain {

	public static void main(String[] args) {
		Item person = new Person("Belt");
		Item person1 = new Person("Belt");
		Item person2 = new Person("Tie");

		Accessories accessories = new Accessories();
		accessories.addAccessory(person1);
		accessories.addAccessory(person);
		accessories.addAccessory(person2);
		accessories.showItems();
	}

}

//flyweight Factory
class Accessories {
	private HashSet<String> accessories = new HashSet<>();

	void addAccessory(Item item) {

		accessories.add(item.getItem());
	}

	void showItems() {
		accessories.forEach(e -> System.out.println(e));
	}
}

//flyweight Concrete Class
class Person implements Item {
	private String item;

	public Person(String item) {
		super();
		this.item = item;
	}

	@Override
	public void addItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return item;
	}
}

//flyweight
interface Item {
	void addItem(String item);

	String getItem();
}
