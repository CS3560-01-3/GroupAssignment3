package dBs;

import application.DBFunc;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Perscription class
 *
 */
public class Prescription implements EventHandler<ActionEvent> {
	int prescriptionID;
	int doctorID;
	int customerID;
	int productID;
	int filled;
	String date;
	String expDate;
	
	public Prescription(int doctorID, int customerID, int productID) {
		this.prescriptionID = DBFunc.getLastDB("prescription");
		this.doctorID = doctorID;
		this.customerID = customerID;
		this.productID = productID;
	}

	public Prescription(int doctorID, int customerID, int productID, int filled, String date, String expDate) {
		this.prescriptionID = DBFunc.getLastDB("prescription");
		this.doctorID = doctorID;
		this.customerID = customerID;
		this.productID = productID;
		this.filled = filled;
		this.date = date;
		this.expDate = expDate;
	}

	/**
	 * When information regarding a perscription is received, inputs the information
	 * into the database.
	 * 
	 * @param filled  status of perscription
	 * @param date    filled the perscription
	 * @param expDate of the perscription
	 */
	public static void addPerscription(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the prescription information below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField doctorName = new TextField("Doctor Name");
		TextField customerName = new TextField("Customer phone");
		TextField productName = new TextField("product Email");
		TextField filled = new TextField("1 for filled 0 for unfilled");
		TextField date = new TextField("Date Filled");
		TextField expDate = new TextField("Expiration Date");
		// TODO
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
				if (!DBFunc.verifyDB(doctorName.getText(), "person")
						&& !DBFunc.verifyDB(productName.getText(), "product")
						&& !DBFunc.verifyDB(customerName.getText(), "person")) {
					Prescription a = new Prescription(DBFunc.nameToIdDB(doctorName.getText(), "person"),
							DBFunc.nameToIdDB(customerName.getText(), "person"),
							DBFunc.nameToIdDB(productName.getText(), "product"), Integer.parseInt(filled.getText()),
							date.getText(), expDate.getText());
					a.writeTo();
				}

			} catch (NumberFormatException e1) {
				System.out.println("Not a number");
			}

			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, doctorName, customerName, productName, filled, date, expDate, submit,
				back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	public void writeTo() {
		String sql = "insert into prescription " + "values(" + prescriptionID + "," + doctorID + "," + customerID + ","
				+ productID + "," + filled+ "," +"'" + date + "'"  + ","  + "'" + expDate + "'" + ")";
		DBFunc.execDB(sql);
	}

	/**
	 * When a subscription is canceled, the information and entry is removed from
	 * the database.
	 * 
	 * @param filled  status of perscription
	 * @param date    filled the perscription
	 * @param expDate of the perscription
	 */
	public static void removePerscription(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the product name below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField doctorName = new TextField("Doctor Name");
		TextField customerName = new TextField("Customer phone");
		TextField productName = new TextField("product Email");
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
				if (!DBFunc.verifyDB(doctorName.getText(), "person")
						&& !DBFunc.verifyDB(productName.getText(), "product")
						&& !DBFunc.verifyDB(customerName.getText(), "person")) {
					Prescription a = new Prescription(DBFunc.nameToIdDB(doctorName.getText(), "person"),
							DBFunc.nameToIdDB(customerName.getText(), "person"),
							DBFunc.nameToIdDB(productName.getText(), "product"));
					a.remove();
				}

			} catch (NumberFormatException e1) {
				System.out.println("Not a number");
			}
			primaryStage.setScene(prev);
		});
		
		regInputs.getChildren().addAll(pagePrompt, doctorName, customerName, productName, submit,
				back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}
	
	public void remove() {
		String sql = "delete from product where doctorName = " + "'" + doctorID + "'";
		DBFunc.execDB(sql);
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}