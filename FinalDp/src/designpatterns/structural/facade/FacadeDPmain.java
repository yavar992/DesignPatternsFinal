package designpatterns.structural.facade;

public class FacadeDPmain {

	public static void main(String[] args) {
		UniversalRemote remote = new UniversalRemote();
		remote.OnDVD();
		remote.OnSpeaker();
		remote.OnTv();

	}

}

//facade
class UniversalRemote {
	Device tv;
	Device dvdPlayer;
	Device homeTheaterSpeaker;

	public UniversalRemote() {
		super();
		tv = new Tv();
		dvdPlayer = new DVDPlayer();
		homeTheaterSpeaker = new HomeTheaterSpeaker();
	}

	public void OnTv() {
		tv.turnOn();
	}

	public void OnDVD() {
		dvdPlayer.turnOn();
	}

	public void OnSpeaker() {
		homeTheaterSpeaker.turnOn();
	}
}

//Subsystem classes
class Tv implements Device {

	@Override
	public void turnOn() {
		System.out.println("Tv ON");
	}
}

class DVDPlayer implements Device {

	@Override
	public void turnOn() {
		System.out.println("DVDPlayer ON");
	}
}

class HomeTheaterSpeaker implements Device {

	@Override
	public void turnOn() {
		System.out.println("HomeTheaterSpeaker ON");
	}
}

//Interfaces
interface Device {
	void turnOn();
}
