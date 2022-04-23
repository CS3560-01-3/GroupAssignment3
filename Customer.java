package DBs;

/**
	 * Customer class, subclass of Person
	 *
	 */
	public class Customer extends Person {
		int age;
		String sex;

		public Customer(String name, String phone, String email, int age, String sex) {
			super(name, phone, email);
			this.age = age;
			this.sex = sex;
		}
		
		/**
		 * When a subscription has a new customer, the System will register the customer into the database.
		 * @param name of the customer
		 * @param phone number of the customer
		 * @param email of the customer
		 * @param age of the customer
		 * @param sex of the customer
		 */
		public static void addCustomer(String name, String phone, String email, int age, String sex) {
			
		}
		/**
		 * When a customer account is canceled by the Customer, it will remove their entry and data from the database.
		 * @param name of the customer
		 * @param phone number of the customer
		 * @param email of the customer
		 * @param age of the customer
		 * @param sex of the customer
		 */
		public static void removeCustomer(String name, String phone, String email, int age, String sex) {
			
		}
		
		

		
		
	}