package designpatterns.behavioural.interpreter;

import java.util.ArrayList;

//client code -> 2+(3-1)
public class Interpreter {

	public static void main(String[] args) {

		Context context = new Context();
		context.numbers.add(2);// 0
		context.numbers.add(3);// 1
		context.numbers.add(1);// 2
		Intrepret expression = new Addition(new Number(context.numbers.get(0)),
				new Subtraction(new Number(context.numbers.get(1)), new Number(context.numbers.get(2))));
		System.out.println(expression);
		int interpret = expression.interpret(context);
		System.out.println(interpret);

	}

}

//context
class Context {
	public ArrayList<Integer> numbers = new ArrayList<>();

}

//Non Terminal Expression1
class Addition implements Intrepret {
	private Intrepret leftvalue;
	private Intrepret rightvalue;

	public Addition(Intrepret leftvalue, Intrepret rightvalue) {
		super();
		this.leftvalue = leftvalue;
		this.rightvalue = rightvalue;
	}

	@Override
	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return leftvalue.interpret(context) + rightvalue.interpret(context);
	}

//	@Override
//	public String toString() {
//		return "Addition [leftvalue=" + leftvalue + ", rightvalue=" + rightvalue + "]";
//	}
//	

}

//Non Terminal Expression2
class Subtraction implements Intrepret {
	private Intrepret leftvalue;
	private Intrepret rightvalue;

	public Subtraction(Intrepret leftvalue, Intrepret rightvalue) {
		super();
		this.leftvalue = leftvalue;
		this.rightvalue = rightvalue;
	}

	@Override
	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return leftvalue.interpret(context) - rightvalue.interpret(context);
	}
//
//	@Override
//	public String toString() {
//		return "Subtraction [leftvalue=" + leftvalue + ", rightvalue=" + rightvalue + "]";
//	}
//	
}

//Terminal Expression
class Number implements Intrepret {
	private int number;

	public Number(int number) {
		super();
		this.number = number;
	}

	@Override
	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return number;
	}
//
//	@Override
//	public String toString() {
//		return "Number [number=" + number + "]";
//	}
//	

}

//Abstract Expression
interface Intrepret {

	int interpret(Context context);
}