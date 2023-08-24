package designpatterns.creational.prototype;

import java.util.HashMap;

public class PrototypeDPMain {

	public static void main(String[] args) {

		Memory memory = new Memory();
		Shape shape = memory.createCircleInstance();
		shape.draw();
		Shape createCircleInstance = memory.createCircleInstance();
		createCircleInstance.draw();

	}

}

class Memory {
	private static HashMap<String, Shape> cacheMemory = new HashMap<String, Shape>();
	private static final Circle circle = new Circle();

	public void addShape(String string, Shape shape) {

		cacheMemory.put(string, shape);
	}

	public Shape createCircleInstance() {
		if (cacheMemory.containsKey("Circle")) {
			System.out.println("Already exists get a cloned copy");
			try {
				return circle.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			addShape("Circle", circle);

			return cacheMemory.get("Circle");
		}
		return null;

	}
}

abstract class Shape {
	abstract void draw();

	@Override
	protected Shape clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

}

class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("circle drawn");
	}

}

class Square extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}