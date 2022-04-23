package DBS;

/**
	 * Suppplier class
	 *
	 */
	public class Supplier {
		String companyName;
		String email;
		String phone;
		String website;
		
		/**
		 * When a new supplier is added, inputs the data regarding the new supplier into the database
		 * @param companyName of the supplier
		 * @param email of the supplier
		 * @param phone number of the supplier
		 * @param website of the supplier
		 */
		public static void registerSupplier(String companyName, String email, String phone, String website) {
			
		}
		
		/**
		 * When a product needs to be removed, delete the entry of the product given. 
		 * @param productID of the product
		 */
		public static void deregisterProduct(String productID) {
			
		}
		/**
		 * When the product is shipped, change the information regarding the shipping status
		 * @param productID of the product
		 */
		public static void updateShippingStatus(String productID) {
			
		}
		/**
		 * When the inventory stock is low, the System orders more products to ensure it remains in stock.
		 * @param productID of the product
		 */
		public void orderItem(String productID) {
			
		}
	}