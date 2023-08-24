package designpatterns.behavioural.memento;

import java.util.Stack;

public class MenentoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Originator originator = new Originator("State1");
		Caretaker caretaker = new Caretaker();
		caretaker.addToMemory(originator.saveState());
		originator.setState("State2");
		originator.setState("State3");
		caretaker.addToMemory(originator.saveState());
//		caretaker.displayState();
//		System.out.println(originator.restore(caretaker.callState(0)));
		originator.setState("State2");
		caretaker.addToMemory(originator.saveState());
		caretaker.displayState();
		caretaker.undo();
		caretaker.undo();
	}

}

class Caretaker {
	private Stack<Memento> statesStorage = new Stack<>();

	void addToMemory(Memento memento) {
		statesStorage.add(memento);
	}

	public Memento callState(int index) {
		return statesStorage.get(index);

	}

	public void displayState() {
		statesStorage.forEach(e -> System.out.print(e.getState() + " "));
		System.out.println();
	}

	void undo() {
		statesStorage.pop();
		displayState();
	}
}

class Originator {
	private String state;

	public Originator(String state) {
		super();
		this.state = state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento saveState() {
		return new Memento(state);
	}

	public String restore(Memento memento) {
		return memento.getState();
	}
}

class Memento {
	private String state;

	public Memento(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
