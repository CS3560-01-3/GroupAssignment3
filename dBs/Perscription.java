package dBs;

	/**
	 * Perscription class
	 *
	 */
	public class Perscription {
		boolean filled;
		String date;
		String expDate;
		
		
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
	}