package designpatterns.structural.adapter;

public class AdapterDPMain {

	public static void main(String[] args) {
		SamsungCharger samsungCharger = new SamsungCharger();
		Adapter adapter = new Adapter(samsungCharger);
		adapter.chargeAnyPhone("Oppo");
	}

}

//Target
interface UniversalAdapter 
{

	public void chargeAnyPhone(String S);
}

//Adapter
class Adapter implements UniversalAdapter {
	private SamsungCharger samsungCharger;

	public Adapter(SamsungCharger samsungCharger) {
		super();
		this.samsungCharger = samsungCharger;
	}

	@Override
	public void chargeAnyPhone(String phone) {

		System.out.println(phone + " is" + samsungCharger.chargeSamsungPhone());
	}
}

//Adaptee
class SamsungCharger {

	public String chargeSamsungPhone() {
		return "Charging with Samsung Charger";
	}

}
