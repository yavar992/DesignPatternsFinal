package designpatterns.structural.composite;

import java.util.HashMap;

public class CompositeDPMain {

	public static void main(String[] args) {

		Engineering engineering = new Engineering();
		engineering.addDepartMent(new Cse(2, "Computer Science and Engineering"));
		engineering.addDepartMent(new Cse(3, "Civil Engineering"));
		engineering.displayTotalDepartMents();
	}

}

//leaf

class Cse implements University {
	private int deptID;
	private String deptName;

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Cse(int deptID, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
	}

	@Override
	public int getDeptID() {
		return deptID;
		// TODO Auto-generated method stub

	}

	@Override
	public String getDeptName() {
		return deptName;
		// TODO Auto-generated method stub

	}
}

class Civil implements University {

	private int deptID;
	private String deptName;

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Civil(int deptID, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
	}

	@Override
	public int getDeptID() {

		return deptID;

	}

	@Override
	public String getDeptName() {
		return deptName;
		// TODO Auto-generated method stub

	}
}

//composite
class Engineering implements University {

	private static HashMap<Integer, String> hashMap = new HashMap<>();
	static {
		hashMap.put(1, "Engineering");
	}

	@Override
	public int getDeptID() {
		return 1;
	}

	@Override
	public String getDeptName() {
		return hashMap.get(1);

	}

	void displayTotalDepartMents() {
		hashMap.entrySet().forEach(e -> System.out.println(e.getKey() + "  " + e.getValue()));
	}

	void addDepartMent(University university) {
		hashMap.put(university.getDeptID(), university.getDeptName());
	}
}

//componet
interface University {
	int getDeptID();

	String getDeptName();
}