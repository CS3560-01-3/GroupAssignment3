package application;

// javaFX imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	// mainMenu buttons
	protected static Button registerProduct = new Button("Register New Product");
	protected static Button registerCustomer = new Button("Register New Customer");
	protected static Button registerDoctor = new Button("Register New Doctor");
	protected static Button registerEmployee = new Button("Register New Employee");
	protected static Button deletePerson = new Button("Delete a Person");
	protected static Button orderProduct = new Button("order Product");
	protected static Button deregisterProduct = new Button("deregister Product");
	protected static Button addPrescription = new Button("add Perscription");
	protected static Button deletePrescription = new Button("delete Prescription");
	protected static Button registerSupplier = new Button("registerSupplier");
	protected static Button deregisterSupplier = new Button("deregisterSupplier");

	// home button
	protected static Button goHome = new Button("Home");

	// window stuff
	protected static Stage primaryStage;
	protected static Scene home;

	// to be removed later
	public static Scene empty;

	// main
	public static void main(String[] args) {

		// TODO
		// read database to array lists

		// launch the GUI
		launch(args);

		// TODO
		// write changes to database
	}

	// Application process
	@Override
	public void start(Stage original) throws Exception {
		primaryStage = original;

		primaryStage.setTitle("Pharmacy Inventory Manager");

		// give main menu buttons event detection
		MainMenuHandler watcher = new MainMenuHandler();
		registerProduct.setOnAction(watcher);
		registerCustomer.setOnAction(watcher);
		registerDoctor.setOnAction(watcher);
		registerEmployee.setOnAction(watcher);
		deletePerson.setOnAction(watcher);
		orderProduct.setOnAction(watcher);
		deregisterProduct.setOnAction(watcher);
		addPrescription.setOnAction(watcher);
		deletePrescription.setOnAction(watcher);
		registerSupplier.setOnAction(watcher);
		deregisterSupplier.setOnAction(watcher);

		// give general buttons event detection
		goHome.setOnAction(watcher);

		// create mainMenu and add Buttons
		VBox mainMenu = new VBox();
		Label mainLab = new Label("Main Menu");
		mainMenu.getChildren().addAll(mainLab, registerProduct, registerCustomer, registerDoctor, registerEmployee,
				deletePerson, orderProduct, deregisterProduct, addPrescription, deletePrescription, registerSupplier,
				deregisterSupplier);
		home = new Scene(mainMenu, 300, 300);

		// create emptyMenu and add Button
		VBox emptyMenu = new VBox();
		Label unFinished = new Label("This option has not yet been implemented.");
		emptyMenu.getChildren().addAll(unFinished, goHome);
		empty = new Scene(emptyMenu, 300, 300);

		// show main menu
		primaryStage.setScene(home);
		primaryStage.show();
	}



}
