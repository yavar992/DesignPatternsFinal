package designpatterns.structural.bridge;

public class BridgeMainDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape circle = new Circle();
		Paint colorGreen = new colorGreen(circle);
		colorGreen.colourShape();

	}

}

//Abstraction
abstract class Paint {
	Shape shape;

	public Paint(Shape shape) {
		super();
		this.shape = shape;
	}

	void colourShape() {
		System.out.println("Coluring  " + shape.getClass().getSimpleName()+" with "+getColor());
		
	}

	abstract String getColor();
}

//concrete Abstraction
class colorGreen extends Paint {

	public colorGreen(Shape shape) {
		super(shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	String getColor() {
		return "Green";
	}

}

class colorRed extends Paint {

	public colorRed(Shape shape) {
		super(shape);
	}

	@Override
	String getColor() {
		return "Red";
	}

}

//Implementation
interface Shape {
	void draw();
}

//Concrete Implementation
class Square implements Shape {

	@Override
	public void draw() {

		System.out.println("Drawing Square");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
	}

}