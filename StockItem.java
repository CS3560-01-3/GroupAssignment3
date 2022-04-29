package DBs;

	/**
	 * Stock item class
	 *
	 */
	public class StockItem {
		String expDate;
		int productID;
		
		public StockItem(String expDate, int productID) {
			this.expDate = expDate;
			this.productID = productID;
		}
		
		public void checkExp() {
//			compare currentDate to expDate
//			change database accordingly
		}
		public void writeTo() {

//			String sql = "insert into product " + "values(" + id + "," + "'" + productName + "'" + "," + "'" + supplierName
//					+ "'" + "," + quantity + ")";
//			Main.insertDB(sql);

		}
		public void remove() {

		}
	}
	
	
