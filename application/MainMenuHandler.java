package application;


import dBs.*;
//javaFX imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainMenuHandler implements EventHandler<ActionEvent> {
	// handle
	@Override
	public void handle(ActionEvent event) {

		if (event.getSource() == Main.registerProduct) {
			Product.register(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.registerCustomer) {
			Customer.addCustomer(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.registerDoctor) {
			Doctor.addDoctor(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.registerEmployee) {
			Employee.register(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.deletePerson) {
			Person.removePerson(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.orderProduct) {
			Main.primaryStage.setScene(Main.empty);

		} else if (event.getSource() == Main.deregisterProduct) {
			Product.deregister(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.addPrescription) {
			Prescription.addPerscription(Main.primaryStage, Main.home);
			;

		} else if (event.getSource() == Main.deletePrescription) {
			Main.primaryStage.setScene(Main.empty);

		} else if (event.getSource() == Main.registerSupplier) {
			Supplier.register(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.deregisterSupplier) {
			Supplier.deregisterSupplier(Main.primaryStage, Main.home);

		} else if (event.getSource() == Main.goHome) {
			Main.primaryStage.setScene(Main.home);
		}
	}
}
