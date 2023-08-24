package designpatterns.behavioural.strategy;

public class StrategyDPMain {

	public static void main(String[] args) {
		// CartProceedToPayment cartProceedToPayment = new CartProceedToPayment(new
		// UIPPayment("abc@oksbi"));
		CartProceedToPayment cartProceedToPayment = new CartProceedToPayment(new CardPayment("123456789", "355"));
		cartProceedToPayment.pay(100);

	}

}

//Context
class CartProceedToPayment {
	private ModeOfPayment modeOfPayment;

	public CartProceedToPayment(ModeOfPayment modeOfPayment) {
		super();
		this.modeOfPayment = modeOfPayment;
	}

	void pay(int amount) {
		this.modeOfPayment.pay(amount);
	}

}

//ConcreteStrategy classes
class UIPPayment implements ModeOfPayment {
	private String UPI_Id;

	public UIPPayment(String uPI_Id) {
		super();
		UPI_Id = uPI_Id;
	}

	@Override
	public void pay(int amount) {

		System.out.println(amount + " Paid through " + this.getClass().getSimpleName() + " by " + this.toString());
	}

	@Override
	public String toString() {
		return "UIPPayment [UPI_Id=" + UPI_Id + "]";
	}

}

class CardPayment implements ModeOfPayment {
	private String CardNumber;
	private String Cvv;

	@Override
	public String toString() {
		return "CardPayment [CardNumber=" + CardNumber + ", Cvv=" + Cvv + "]";
	}

	public CardPayment(String cardNumber, String cvv) {
		super();
		CardNumber = cardNumber;
		Cvv = cvv;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " Paid through " + this.getClass().getSimpleName() + " by " + this.toString());
	}
}

class NetBankingPayment implements ModeOfPayment {
	private String UserId;

	@Override
	public String toString() {
		return "NetBankingPayment [UserId=" + UserId + "]";
	}

	public NetBankingPayment(String userId) {
		super();
		UserId = userId;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " Paid through " + this.getClass().getSimpleName() + " by " + this.toString());
	}

}

//Strategy
interface ModeOfPayment {
	void pay(int amount);
}
