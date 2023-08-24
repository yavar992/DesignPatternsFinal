package designpatterns.behavioural.chainofresponsibility;

//client
public class ChainOfResponsibility {

	public static void main(String[] args) {
		ApprovingPower teamLeader = new TeamLeader();
		ApprovingPower projectManager = new ProjectManager();
		ApprovingPower deliveryManager = new DeliveryManager();
		teamLeader.setApprovingPower(projectManager);
		projectManager.setApprovingPower(deliveryManager);
		TeamMember teamMember = new TeamMember(45);
		teamLeader.approveAmount(teamMember.getRedeemAmount());
	}

}

//context 
class TeamMember {
	int redeemAmount;

	public TeamMember(int redeemAmount) {
		super();
		this.redeemAmount = redeemAmount;
	}

	public int getRedeemAmount() {
		return redeemAmount;
	}

}

//ConcreteHandler
class TeamLeader implements ApprovingPower {
	private ApprovingPower approvingPower;

	public TeamLeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setApprovingPower(ApprovingPower approvingPower) {
		this.approvingPower = approvingPower;
	}

	public TeamLeader(ApprovingPower approvingPower) {
		super();
		this.approvingPower = approvingPower;
	}

	public ApprovingPower getApprovingPower() {
		return approvingPower;
	}

	@Override
	public void approveAmount(int amount) {
		if (amount < 500) {
			System.out.println(amount + " has been approved by" + this.getClass().getSimpleName());
		} else if (approvingPower != null) {
			approvingPower.approveAmount(amount);
		} else {
			System.out.println("Error Occured");
		}

	}

}

class ProjectManager implements ApprovingPower {

	public ProjectManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setApprovingPower(ApprovingPower approvingPower) {
		this.approvingPower = approvingPower;
	}

	private ApprovingPower approvingPower;

	public ProjectManager(ApprovingPower approvingPower) {
		super();
		this.approvingPower = approvingPower;
	}

	public ApprovingPower getApprovingPower() {
		return approvingPower;
	}

	@Override
	public void approveAmount(int amount) {
		if (amount < 1500) {
			System.out.println(amount + " has been approved by" + this.getClass().getSimpleName());
		} else if (approvingPower != null) {
			approvingPower.approveAmount(amount);
		} else {
			System.out.println("Error Occured");
		}
	}

}

class DeliveryManager implements ApprovingPower {

	public DeliveryManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setApprovingPower(ApprovingPower approvingPower) {
		this.approvingPower = approvingPower;
	}

	private ApprovingPower approvingPower;

	public DeliveryManager(ApprovingPower approvingPower) {
		super();
		this.approvingPower = approvingPower;
	}

	public ApprovingPower getApprovingPower() {
		return approvingPower;
	}

	@Override
	public void approveAmount(int amount) {
		if (amount < 2500) {
			System.out.println(amount + " has been approved by" + this.getClass().getSimpleName());
		} else if (approvingPower != null) {
			approvingPower.approveAmount(amount);
		} else {
			System.out.println("Amount Not Allowed");
		}
	}

}

//Handler
interface ApprovingPower {
	void approveAmount(int amount);

	void setApprovingPower(ApprovingPower approvingPower);

}