package dBs;

import java.util.ArrayList;
import java.util.List;

import application.*;

/**
 * product class
 *
 */

//javaFX imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Product {

	// DB fields
	String name;
	int productID;
	double price;

	// Utility fields -- no longer needed
	static int noProducts = 0; 

	// GUI fields
	private static Scene register1;

	private Product(String name) {
		this.name = name;
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.productID = DBFunc.getLastDB("product"); 
	}

	/**
	 * When a new product is added to the inventory of the pharmacy, add the product
	 * to the database and it�s associated information.
	 * 
	 * @param productID of the product
	 * @param name      of the product
	 */
	public static void register(Stage primaryStage, Scene prev) {

		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the product name and supplier below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField productName = new TextField("Product Name");
		TextField price = new TextField("0");
		// TODO
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			try {
			    if (DBFunc.verifyDB(productName.getText(), "product")) {
					Product a = new Product(productName.getText(), Double.parseDouble(price.getText()));
					a.writeTo();
				}
				
			} catch (NumberFormatException e1) {
			    System.out.println("Not a number");
			}
			
			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, productName, price, submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	public static void deregister(Stage primaryStage, Scene prev) {
		VBox regInputs = new VBox();
		Label pagePrompt = new Label("Enter the product name below");
		Button back = new Button("Back");
		back.setOnAction(e -> primaryStage.setScene(prev));
		TextField productName = new TextField("Product Name");
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			Product a = new Product(productName.getText());
			a.remove();
			primaryStage.setScene(prev);
		});

		regInputs.getChildren().addAll(pagePrompt, productName, submit, back);
		Scene register1 = new Scene(regInputs, 300, 250);
		primaryStage.setScene(register1);
	}

	public void writeTo() {
		String sql = "insert into product " + "values(" + productID + "," + "'" + name + "'" + "," + price + ")";
		DBFunc.execDB(sql);
	}

	public void remove() {
		String sql = "delete from product where productName = " + "'" + name + "'";
		DBFunc.execDB(sql);
	}



}
