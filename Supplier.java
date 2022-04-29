package DBs;

import java.util.ArrayList;

import application.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Suppplier class
 *
 */
public class Supplier {
	int supplierID;
	String supplierName;
	String email;
	int phone;
	String website;
	private Supplier(String name) {
		this.supplierName = name;
	}
	public Supplier(String companyName, String email, int phone, String website) {
		this.supplierName = companyName;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.supplierID = DBFunc.getLastDB("supplier");
	}

	/**
	 * When a new supplier is added, inputs the data regarding the new supplier into
	 * the database
	 * 
	 * @param companyName of the supplier
	 * @param email       of the supplier
	 * @param phone       number of the supplier
	 * @param website     of the supplier
	 */
	public static void register(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the suppllier name and supplier below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField supplierName = new TextField("Supplier Name");
		TextField supplierEmail = new TextField("Supplier Email");
		TextField supplierPhone = new TextField("Supplier Phone");
		TextField supplierWebsite = new TextField("Supplier Website");
		// TODO
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
				if (DBFunc.verifyDB(supplierName.getText(), "supplier")) {
					Supplier a = new Supplier(supplierName.getText(), supplierEmail.getText(),
							Integer.parseInt(supplierPhone.getText()), supplierWebsite.getText());
					a.writeTo();
				}

			} catch (NumberFormatException e1) {
				System.out.println("Not a number");
			}

			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, supplierName, supplierEmail, supplierPhone, supplierWebsite, submit,
				back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	/**
	 * deregister supplier from the database
	 * 
	 * @param companyName of the supplier
	 * @param email       of the supplier
	 * @param phone       number of the supplier
	 * @param website     of the supplier
	 */
	public static void deregisterSupplier(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the supplier name below to remove");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField supplierName = new TextField("Supplier Name");
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			Supplier a = new Supplier(supplierName.getText());
			a.remove();
			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, supplierName, submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	public void writeTo() {
		String sql = "insert into supplier " + "values(" + supplierID + "," + "'" + supplierName + "'" + "," + "'"
				+ email + "'" + "," + phone + "," + "'" + website + "'" + ")";
		DBFunc.execDB(sql);
	}
	public void remove() {
		String sql = "delete from supplier where supplierName = " + "'" + supplierName + "'";
		DBFunc.execDB(sql);
	}
}