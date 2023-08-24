package designpatterns.creational.abstractfactory;

public class AbstractFactoryDPMain {

	public static void main(String[] args) {
		
		OsFactory oSFactory = new WindowsOSFactory();
		OS createOS = oSFactory.createOS(new WindowsButton());
		createOS.clickButton();
	}

}

//Abstract Product
interface Operations {
	void button();
}

//Concrete Product
class WindowsButton implements Operations {

	@Override
	public void button() {
		System.out.println("WindowsButtonClicked");
	}
}

class MacButton implements Operations {

	@Override
	public void button() {
		System.out.println("MacButtonClicked");
	}
}


interface OS {
	void clickButton();
}
//Abstract Factory
interface OsFactory{
	OS createOS(Operations operations);
}

//Concrete Factory


class WindowsOSFactory implements OsFactory{

	@Override
	public OS createOS(Operations operations) {
		// TODO Auto-generated method stub
		return new WindowsOS(operations);
	}}

class MacOSFactory implements OsFactory{

	@Override
	public OS createOS(Operations operations) {
		// TODO Auto-generated method stub
		return new MacOS(operations);
	}}




class WindowsOS implements OS {
	Operations operation;

	public WindowsOS(Operations operation) {
		super();
		this.operation = new WindowsButton();
	}

	public Operations getOperation() {
		return operation;
	}

	public void setOperation(Operations operation) {
		this.operation = operation;
	}

	@Override
	public void clickButton() {

		operation.button();
	}
	

}

class MacOS implements OS {
	Operations operation;

	public MacOS(Operations operation) {
		super();
		this.operation = new MacButton();
	}

	public Operations getOperation() {
		return operation;
	}

	public void setOperation(Operations operation) {
		this.operation = operation;
	}

	@Override
	public void clickButton() {

		operation.button();
	}

}