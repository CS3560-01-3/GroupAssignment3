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
 * Doctor class, subclass of Person
 *
 */
public class Doctor extends Person implements EventHandler<ActionEvent> {
	int doctorID;
	int personID;
	int licenseNum;

	public Doctor(Person person, int licenseNum) {
		super(person);
		this.licenseNum = licenseNum;
		this.doctorID = DBFunc.getLastDB("doctor");
		this.personID = person.personID;
	}

	public static void addDoctor(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the doctor's name, age and sex below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField personName = new TextField("Doctor Name");
		TextField personPhone = new TextField("Doctor phone");
		TextField personEmail = new TextField("Doctor Email");
		TextField doctorLicense = new TextField("Doctor License Number");
		// TODO
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
				if (DBFunc.verifyDB(personName.getText(), "person")) {
					Doctor a = new Doctor(new Person(personName.getText(), Integer.parseInt(personPhone.getText()),
							personEmail.getText()), Integer.parseInt(doctorLicense.getText()));

					a.perWriteTo();
					a.writeTo();
				}

			} catch (NumberFormatException e1) {
				System.out.println("Not a number");
			}

			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, personName, personPhone, personEmail, doctorLicense, submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	public void writeTo() {
		String sql = "insert into doctor " + "values(" + doctorID + "," + personID + "," + licenseNum + ")";
		DBFunc.execDB(sql);
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}