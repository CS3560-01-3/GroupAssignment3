package DBs;

import java.util.ArrayList;

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

public class Product implements EventHandler<ActionEvent> {

    // DB fields
    String name;
    int productID;
    int quantity;
    Supplier supplier;

    // Utility fields
    static int noProducts = 0; // this needs to be fixed

    // GUI fields
    private static Scene register1;

    public Product(String name, Supplier supplier, int quantity) {
        this.name = name;
        this.supplier = supplier;

        this.productID = ++noProducts; // this needs to be fixed
        this.quantity = quantity;
    }

    /**
     * When a new product is added to the inventory of the pharmacy, add the product
     * to the database and it’s associated information.
     * 
     * @param productID
     *            of the product
     * @param name
     *            of the product
     */
    public static void registerProduct(ArrayList<Product> products, Stage primaryStage, Scene prev) {

        VBox regInputs = new VBox();
        Label pagePrompt = new Label("Enter the product name and supplier below");

        Button back = new Button("Back");
        back.setOnAction(e -> primaryStage.setScene(prev));

        TextField productName = new TextField("Product Name");

        TextField supplierName = new TextField("Supplier");

        // TODO
        Button submit = new Button("submit");
        submit.setOnAction(e -> {                                                //@ Viet, we need this to write to the database, or do it at end of main
            products.add(new Product(productName.getText(), new Supplier(), 0)); // we need a method to search for a supplier based on name
                                                                                 // we need to verify the product doesn't already exist
            primaryStage.setScene(prev);
        });

        regInputs.getChildren().addAll(pagePrompt, productName, supplierName, submit, back);
        Scene register1 = new Scene(regInputs, 300, 250);

        primaryStage.setScene(register1);
    }

    // handler
    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}
