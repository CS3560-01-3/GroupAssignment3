package DBs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Person superclass
 *
 */
public class Person {
	int personID;
	String name;
	int phone;
	String email;
	
	private Person(String name) {
		this.name = name;
	}
	public Person(String name, int phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.personID = DBFunc.getLastDB("person");
	}
	public Person(Person person) {
		this.name = person.name;
		this.phone = person.phone;
		this.email = person.email;
		this.personID = DBFunc.getLastDB("person");
	}

	public void perWriteTo() {
		String sql = "insert into person " + "values(" + personID + "," + "'" + name + "'" + "," + phone + "," + "'"+ email+ "'"
				+ ")";
		DBFunc.execDB(sql);
	}
	public static void removePerson(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the Person name below to remove");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField PersonName = new TextField("Person Name");
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			Person a = new Person(PersonName.getText());
			a.remove(DBFunc.nameToIdDB(a.name, "person"));
			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, PersonName, submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}
	public void remove(int id) {
		String sql = "delete from person where personID = " + "'" + id + "'";
		DBFunc.execDB(sql);
		sql = "delete from customer where personID = " + "'" + id + "'";
		DBFunc.execDB(sql);
		sql = "delete from doctor where personID = " + "'" + id + "'";
		DBFunc.execDB(sql);
		sql = "delete from employee where personID = " + "'" + id + "'";
		DBFunc.execDB(sql);
	}
}