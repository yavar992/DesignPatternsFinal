package designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDpMain {

	public static void main(String[] args) {

		Subscriber person1 = new Person("Dony");
		Subscriber person2 = new Person("David");
		Yotuber creator = new Creator();
		creator.addSubscriberForCreator(person1);
		creator.addSubscriberForCreator(person2);
		creator.publishContent("Notification 1");

	}
}

//ConcreteSubject
class Creator implements Yotuber {
	private List<Subscriber> subscribers = new ArrayList<>();

	@Override
	public void sendNotification(String notification) {
		subscribers.forEach(e -> System.out.println(notification + " Sent to " + ((Person) e).getPerson()));
	}

	@Override
	public void addSubscriberForCreator(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void publishContent(String content) {
		sendNotification(content);
	}
}

//subject
interface Yotuber {
	void sendNotification(String notification);

	void addSubscriberForCreator(Subscriber subscriber);

	void publishContent(String content);

}

//ConcreteObserver
class Person implements Subscriber {
	private String person;

	public Person(String person) {
		super();
		this.person = person;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public Person subscribe() {
		return new Person(person);

	}
}

//Observer ->Subscriber
interface Subscriber {
	Person subscribe();
}