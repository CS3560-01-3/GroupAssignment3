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
 * Customer class, subclass of Person
 *
 */
public class Customer extends Person implements EventHandler<ActionEvent> {
	int customerID;
	int personID;
	int age;
	String sex;

	public Customer(Person person, int age, String sex) {
		super(person);
		this.age = age;
		this.sex = sex;
		this.customerID = DBFunc.getLastDB("customer");
		this.personID = person.personID;
	}

	/**
	 * When a subscription has a new customer, the System will register the customer
	 * into the database.
	 * 
	 * @param name  of the customer
	 * @param phone number of the customer
	 * @param email of the customer
	 * @param age   of the customer
	 * @param sex   of the customer
	 */
	public static void addCustomer(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the customer's name, age and sex below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField personName = new TextField("Customer Name");
		TextField personPhone = new TextField("Customer phone");
		TextField personEmail = new TextField("Customer Email");
		TextField customerAge = new TextField("Customer Age");
		TextField customerSex = new TextField("Customer Sex (M or F)");
		// TODO
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
				if (DBFunc.verifyDB(personName.getText(), "person")) {
					Customer a = new Customer(
							new Person(personName.getText(), Integer.parseInt(personPhone.getText()),
									personEmail.getText()),
							Integer.parseInt(customerAge.getText()), customerSex.getText());

					a.perWriteTo();
					a.writeTo();
				}

			} catch (NumberFormatException e1) {
				System.out.println("Not a number");
			}

			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, personName, personPhone, personEmail, customerAge, customerSex,
				submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	/**
	 * When a customer account is canceled by the Customer, it will remove their
	 * entry and data from the database.
	 * 
	 * @param name  of the customer
	 * @param phone number of the customer
	 * @param email of the customer
	 * @param age   of the customer
	 * @param sex   of the customer
	 */
	

	public void writeTo() {
		String sql = "insert into customer " + "values(" + customerID + "," + personID +","+ age + "," + "'" + sex + "'"
				+ ")";
		DBFunc.execDB(sql);
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}