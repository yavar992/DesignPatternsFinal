package designpatterns.behavioural.command;

//client code
public class CommandDPMain {

	public static void main(String[] args) {
		Remote remote = new Remote();
		Tv tv = new Tv();
		DTHBox dthBox = new DTHBox();

		Command pressTvOff = new PressTvOff(tv);
		Command pressTvOn = new PressTvOn(tv);
		Command pressDTHBoxOn = new PressDTHBoxOn(dthBox);
		Command pressDTHBoxOff = new PressDTHBoxOff(dthBox);

		remote.setCommand(pressTvOn);
		remote.press();
		remote.setCommand(pressTvOff);
		remote.press();

		remote.setCommand(pressDTHBoxOn);
		remote.press();

		remote.setCommand(pressDTHBoxOff);
		remote.press();

	}

}

//Invoker->TV Remote
class Remote {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	void press() {
		command.press();
	}

}

//ReceiverClass->TV,DTHBox
class Tv {
	void TvOn() {
		System.out.println("TV  ==-> ON");
	}

	void TvOff() {
		System.out.println("TV  ==-> OFF");
	}

}

class DTHBox {
	void TvOn() {
		System.out.println("DTHBox  ==-> ON");
	}

	void TvOff() {
		System.out.println("DTHBox  ==-> OFF");
	}
}

//concrete command classes->TvOn,TvOff,DTHBoxOn,DTHBoxOff
class PressTvOn implements Command {
	private Tv tv;

	public PressTvOn(Tv tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void press() {
		tv.TvOn();

	}
}

class PressTvOff implements Command {
	private Tv tv;

	@Override
	public void press() {

		tv.TvOff();
	}

	public PressTvOff(Tv tv) {
		super();
		this.tv = tv;
	}

}

class PressDTHBoxOn implements Command {
	private DTHBox dthBox;

	@Override
	public void press() {
		dthBox.TvOn();

	}

	public PressDTHBoxOn(DTHBox dthBox) {
		super();
		this.dthBox = dthBox;
	}

}

class PressDTHBoxOff implements Command {
	private DTHBox dthBox;

	@Override
	public void press() {
		dthBox.TvOff();

	}

	public PressDTHBoxOff(DTHBox dthBox) {
		super();
		this.dthBox = dthBox;
	}

}

//comman interface->Command - execute()
interface Command {
	void press();
}

////extra
//interface Device {
//}
//
//class Power {
//Device device;
//
//Device TunOnMainPower(String str) {
//	Tv tv = new Tv();
//	DTHBox dthBox = new DTHBox();
//	if (str.equals("tv")) {
//		return tv;
//	} else if ("dth".equals(str)) {
//		return dthBox;
//	} else
//		return null;
//}
//
//
//}
