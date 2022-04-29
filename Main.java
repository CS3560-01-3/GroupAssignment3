package application;

// SQL imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
// localS imports
import DBs.*;

// java.util imports
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application implements EventHandler<ActionEvent> {
	
	
    // mainMenu buttons
    private Button registerProduct = new Button("Register New Product");
    private Button registerCustomer = new Button("Register New Customer");
    private Button registerDoctor = new Button("Register New Doctor");
    private Button registerEmployee = new Button("Register New Employee");
    private Button deletePerson = new Button("Delete a Person");
    private Button orderProduct = new Button("order Product");
    private Button deregisterProduct = new Button("deregister Product");
    private Button addPrescription = new Button("add Perscription");
    private Button deletePrescription = new Button("delete Prescription");
    private Button registerSupplier = new Button("registerSupplier");
    private Button deregisterSupplier = new Button("deregisterSupplier");

    // home button
    private Button goHome = new Button("Home");

    // window stuff
    private static Stage primaryStage;
    public static Scene home;

    // to be removed later
    public static Scene empty;

    // data - not needed?
    private ArrayList<Product> products = new ArrayList<Product>();

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
        registerProduct.setOnAction(this);
        registerCustomer.setOnAction(this);
        registerDoctor.setOnAction(this);
        registerEmployee.setOnAction(this);
        deletePerson.setOnAction(this);
        orderProduct.setOnAction(this);
        deregisterProduct.setOnAction(this);
        addPrescription.setOnAction(this);
        deletePrescription.setOnAction(this);
        registerSupplier.setOnAction(this);
        deregisterSupplier.setOnAction(this);

        // give general buttons event detection
        goHome.setOnAction(this);

        // create mainMenu and add Buttons
        VBox mainMenu = new VBox();
        Label mainLab = new Label("Main Menu");
        mainMenu.getChildren().addAll(mainLab, registerProduct,registerCustomer,registerDoctor,registerEmployee,deletePerson, orderProduct, deregisterProduct, addPrescription,
        		deletePrescription, registerSupplier, deregisterSupplier);
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

    // handle
    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == registerProduct) {
            Product.register(primaryStage, home);
            

        } else if (event.getSource() == registerCustomer) {
            Customer.addCustomer(primaryStage, home);

        }else if (event.getSource() == registerDoctor) {
            Doctor.addDoctor(primaryStage, home);

        }else if (event.getSource() == registerEmployee) {
            Employee.register(primaryStage, home);

        }else if (event.getSource() == deletePerson) {
            Person.removePerson(primaryStage, home);

        }else if (event.getSource() == orderProduct) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == deregisterProduct) {
        	Product.deregister(primaryStage, home);

        } else if (event.getSource() == addPrescription) {
            Prescription.addPerscription(primaryStage, home);;

        } else if (event.getSource() == deletePrescription) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == registerSupplier) {
        	Supplier.register(primaryStage, home);

        } else if (event.getSource() == deregisterSupplier) {
        	Supplier.deregisterSupplier(primaryStage, home);

        } else if (event.getSource() == goHome) {
            primaryStage.setScene(home);
        }
    }

   
    
    
}

