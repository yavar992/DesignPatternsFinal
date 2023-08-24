package designpatterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorDPMain {

	public static void main(String[] args) {

		WhatsAppGroup whatsAppGroup = new WhatsAppGroup();
		User person1 = new Person("user1");
		User person2 = new Person("user2");
		User person3 = new Person("user3");
		whatsAppGroup.addUser(person1);
		whatsAppGroup.addUser(person2);
		whatsAppGroup.addUser(person3);
		whatsAppGroup.sendMessage(person1, "Hi Everyone");
	}

}

//concreteColleague
class Person implements User {
	private GroupChat groupChat;
	private String userName;

	public Person(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void sendMessage(String Message) {
		groupChat.sendMessage(this, Message);
	}

	@Override
	public void receiveMessage(String Message, User userSender, User userReceiver) {
		System.out.println(((Person)userReceiver).getUserName() + " received message " + Message + " from " + ((Person)userSender).getUserName());

	}

	public GroupChat getGroupChat() {
		return groupChat;
	}

	public void setGroupChat(GroupChat groupChat) {
		this.groupChat = groupChat;
	}
}

//colleague
interface User {
	void sendMessage(String Message);

	void receiveMessage(String Message, User userSender, User userReceiver);
}

//concretemediator
class WhatsAppGroup implements GroupChat {
	private List<User> member = new ArrayList<>();

	void addUser(User user) {
		member.add(user);
	}

	@Override
	public void sendMessage(User user, String message) {
		member.stream().filter(e -> !e.equals(user)).forEach(e -> e.receiveMessage(message, user, e));
		// .println(((Person) e).getUserName() + " received message from" + ((Person)
		// user).getUserName()));
	}

}

//mediator
interface GroupChat {
	void sendMessage(User user, String message);
}
