package DBs;

import java.util.ArrayList;

import application.Main;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
		public static void register(Stage primaryStage, Scene prev) {
			
		}
		/**
		 * deregister supplier from the database
		 * @param companyName of the supplier
		 * @param email of the supplier
		 * @param phone number of the supplier
		 * @param website of the supplier
		 */
		public static void deregisterSupplier(Stage primaryStage, Scene prev) {
			
		}
		
		public void writeTo() {

//			String sql = "insert into product " + "values(" + id + "," + "'" + productName + "'" + "," + "'" + supplierName
//					+ "'" + "," + quantity + ")";
//			Main.insertDB(sql);

		}
	}