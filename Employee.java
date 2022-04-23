package DBs;

/**
	 * Employee class, subclass of Person
	 *
	 */
	public class Employee extends Person {
		int ID;
		boolean isManager;

		public Employee(String name, String phone, String email, int ID, boolean isManager) {
			super(name, phone, email);
			this.ID = ID;
			this.isManager = isManager;
		}

		/**
		 * When a product needs to be removed, delete the entry of the product given. 
		 * @param productID of the product
		 */
		public static void deregisterProduct(String productID) {
			
		}

		/**When information regarding a perscription is received, inputs the information into the database.
		 * @param filled status of perscription
		 * @param date filled the perscription
		 * @param expDate of the perscription
		 */
		public static void addPerscription(boolean filled, String date, String expDate) {
			
		}
		/**
		 * When a subscription is canceled, the information and entry is removed from the database.
		 * @param filled status of perscription
		 * @param date filled the perscription
		 * @param expDate of the perscription
		 */
		public static void removePerscription(boolean filled, String date, String expDate) {
			
		}

		/**
		 * When a customer picks up their medical product, an Employee registers that they have collected their product.
		 * @param productID of the product
		 * @return the status of whether the product was picked up or not
		 */
		public static boolean pickUpProduct(String productID) {
			return true;
		}
	}