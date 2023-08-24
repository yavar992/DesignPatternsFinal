package designpatterns.creational.builder;

public class BuilderDPMain {

	public static void main(String[] args) {

		Person p = new Person.Builder().setId(1).setName("Dony").setMobile("123455").setAddress("Chirala").build();
		System.out.println(p.toString());
		;
	}

}

//Product
class Person {
	private int id;
	private String name;
	private String mobile;
	private String address;

	private Person(int id, String name, String mobile, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile + ", address=" + address + "]";
	}

	// Builder
	static class Builder {
		private int id;
		private String name;
		private String mobile;
		private String address;

		public Person build() {
			return new Person(id, name, mobile, address);
		}

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

	}
}