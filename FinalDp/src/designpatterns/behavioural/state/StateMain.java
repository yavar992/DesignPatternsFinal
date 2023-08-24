package designpatterns.behavioural.state;

public class StateMain {

	public static void main(String[] args) {
		SignalLight signalLight = new SignalLight();
		signalLight.getSignalLightState();
		System.out.println(signalLight.toString());
		signalLight.setSignalLightState(new GreenLight());
		System.out.println(signalLight.toString());

	}

}

//context
class SignalLight {
	private SignalLightState signalLightState;

	public SignalLight() {
		super();
		signalLightState = new RedLight();
	}

	public void getSignalLightState() {
		signalLightState.display();
	}

	public void setSignalLightState(SignalLightState signalLightState) {
		this.signalLightState = signalLightState;
	}

	@Override
	public String toString() {
		return "SignalLight [signalLightState=" + signalLightState + "]";
	}
	

}

//ConcurrentStates
class RedLight implements SignalLightState {

	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName());
	}
}

class GreenLight implements SignalLightState {

	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName());
	}
}

class YellowLight implements SignalLightState {

	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName());
	}
}

//State
interface SignalLightState {
	void display();

}
