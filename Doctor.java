package DBs;

/**
	 * Doctor class, subclass of Person
	 *
	 */
public class Doctor extends Person {
	int license;

	public Doctor(String name, String phone, String email, int license) {
		super(name, phone, email);
		this.license = license;
	}

	

}