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
 * Employee class, subclass of Person
 *
 */
public class Employee extends Person implements EventHandler<ActionEvent>{
	int employeeID;
	int personID;
	int isManager;

	public Employee(Person person, int isManager) {
		super(person);
		this.employeeID = DBFunc.getLastDB("employee");
		this.personID = person.personID;
		this.isManager = isManager;
	}

//		in progress
	public static void register(Stage primaryStage, Scene prev) {

		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the Employee's name and supplier below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField personName = new TextField("Employee Name");
		TextField personPhone = new TextField("Employee phone");
		TextField personEmail = new TextField("Employee Email");
		TextField isManager = new TextField("0 for non manager 1 for yes manager");
		// TODO
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
				if (DBFunc.verifyDB(personName.getText(), "person")) {
					Employee a = new Employee(new Person(personName.getText(), Integer.parseInt(personPhone.getText()),
							personEmail.getText()), Integer.parseInt(isManager.getText()));
					a.perWriteTo();
					a.writeTo();
				}

			} catch (NumberFormatException e1) {
				System.out.println("Not a number");
			}

			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, personName, personPhone,personEmail,isManager, submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}
	public void writeTo() {
		String sql = "insert into employee " + "values(" + employeeID + "," + personID + "," + isManager + ")";
		DBFunc.execDB(sql);
	}
	/**
	 * When a customer picks up their medical product, an Employee registers that
	 * they have collected their product.
	 * 
	 * @param productID of the product
	 * @return the status of whether the product was picked up or not
	 */
	public static boolean pickUpProduct(String productID) {
		return true;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}