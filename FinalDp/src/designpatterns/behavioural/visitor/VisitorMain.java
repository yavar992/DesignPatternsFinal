package designpatterns.behavioural.visitor;

import java.util.ArrayList;
import java.util.List;

//Shoppingcart Example
public class VisitorMain {

	public static void main(String[] args) {
		Basket basket = new Basket();
		Items pickedItems = new PickedItemsWithGST();
		Book book = new Book(10);
		basket.addToBasket(book);
		Friuits apples = new Friuits(10, 5);
		basket.addToBasket(apples);

		double totalBill = basket.totalBill(pickedItems);

		System.err.println(totalBill);
	}

}

//object Structure
class Basket {
	private List<AddToCart> basket = new ArrayList<>();

	void addToBasket(AddToCart addToCart) {
		basket.add(addToCart);
	}

	double totalBill(Items pickedItems) {

		return basket.stream().mapToDouble(e -> e.accept(pickedItems)).sum();

	}

}

//Concrete Element->list of items present in our website
class Book implements AddToCart {
	private int price;

	public Book(int price) {
		super();
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public double accept(Items items) {
		// TODO Auto-generated method stub
		return items.visit(this);
	}

}

class Friuits implements AddToCart {
	private int price;
	private int weight;

	public Friuits(int price, int weight) {
		super();
		this.price = price;
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public double accept(Items items) {
		// TODO Auto-generated method stub
		return items.visit(this);
	}

}

//Element
interface AddToCart {
	double accept(Items items);
}

//Concrete visitor
class PickedItems implements Items {

	@Override
	public double visit(Book book) {
		// TODO Auto-generated method stub
		return book.getPrice();
	}

	@Override
	public double visit(Friuits friuits) {
		// TODO Auto-generated method stub
		return friuits.getPrice() * friuits.getWeight();
	}

}

class PickedItemsWithGST implements Items {

	@Override
	public double visit(Book book) {
		// TODO Auto-generated method stub
		System.out.println(book.getPrice() * 0.18);
		return book.getPrice() + book.getPrice() * 0.18;
	}

	@Override
	public double visit(Friuits friuits) {
		// TODO Auto-generated method stub
		int total = friuits.getPrice() * friuits.getWeight();
		System.out.println(total);
		return total + total * 0.18;
	}

}

//visitor
interface Items {
	double visit(Book book);

	double visit(Friuits friuits);
}
