package DBs;

	/**
	 * Person superclass
	 *
	 */
public abstract class Person {
	String name;
	String phone;
	String email;

public Person(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

}