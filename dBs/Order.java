package dBs;
/**
	 * Order class
	 *
	 */
	public class Order {
		String datePlaced;
		String dateReceived;
		
		/**
		 * When the product is shipped, change the information regarding the shipping status
		 * @param productID of the product
		 */
		public void updateShippingStatus() {
//			when received, instantiate stockitem and call writeTo on stockItem
		}
		
		/**
		 * When the inventory stock is low, the System orders more products to ensure it remains in stock.
		 * @param productID of the product
		 */
		public void orderProduct(String name) {
			
		}
	}