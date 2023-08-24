package designpatterns.structural.proxy;

public class ProxyDPMain {

	public static void main(String[] args) {
		Student student = new Student();

		student.setUrl("abcd.com");
		Internet collegeInternet = new CollegeInternet(student);
		try {
			collegeInternet.establishConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Student {
	private String url;

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

}

//Proxy
class CollegeInternet implements Internet {
	private JioFiber jioFiber;
	private Student student;

	public CollegeInternet(Student student) {
		super();
		this.student = student;
		jioFiber = new JioFiber();
	}

	@Override
	public void connectTo(String url) {
		jioFiber.connectTo(url);

	}

	@Override
	public void establishConnection() throws Exception {
		String url = student.getUrl();
		if (url.equals("abc.com")) {
			throw new Exception("wrong site");
		} else {
			connectTo(url);
		}
	}
}

//Real Subject
class JioFiber implements Internet {

	@Override
	public void connectTo(String url) {
		System.out.println("connected to " + url);
	}

	@Override
	public void establishConnection() {

	}
}

//Subject
interface Internet {
	void connectTo(String url);

	void establishConnection() throws Exception;
}