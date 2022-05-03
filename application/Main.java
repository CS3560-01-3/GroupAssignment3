package application;

// javaFX imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

    // home scene buttons
    protected static Button Products = new Button("Products");
    protected static Button Suppliers = new Button("Suppliers");
    protected static Button Orders = new Button("Orders");
    protected static Button People = new Button("People");

    // Product Buttons
    protected static Button registerProduct = new Button("Register New Product");
    protected static Button deregisterProduct = new Button("Deregister Product");

    // Suppliers Buttons
    protected static Button registerSupplier = new Button("RegisterSupplier");
    protected static Button deregisterSupplier = new Button("DeregisterSupplier");
    protected static Button registerOffering = new Button("Add Product to Supplier");
    protected static Button deregisterOffering = new Button("Remove Product from Supplier");

    // Orders Buttons
    protected static Button orderProduct = new Button("Order Product");
    protected static Button recieveOrder = new Button("Recieve Order");
    
    // People Buttons
    protected static Button registerCustomer = new Button("Register New Customer");
    protected static Button registerDoctor = new Button("Register New Doctor");
    protected static Button registerEmployee = new Button("Register New Employee");
    protected static Button deletePerson = new Button("Delete a Person");
    protected static Button addPrescription = new Button("add Perscription");
    protected static Button deletePrescription = new Button("delete Prescription");

    // home button
    protected static Button goHome = new Button("Home");

    // window
    protected static Stage primaryStage;

    // scenes
    protected static Scene home;

    // layouts
    protected static HBox homeMenu;
    protected static VBox categories;
    protected static VBox productsLay;
    protected static VBox suppliersLay;
    protected static VBox ordersLay;
    protected static VBox peopleLay;

    // to be removed later
    public static Scene empty;

    // main
    public static void main(String[] args) {
        // launch the GUI
        launch(args);
    }

    // Application process
    @Override
    public void start(Stage original) throws Exception {
        primaryStage = original;

        primaryStage.setTitle("Pharmacy Inventory Manager");

        // give home menu buttons event detection
        MainMenuHandler watcher = new MainMenuHandler();
        Products.setOnAction(watcher);
        Suppliers.setOnAction(watcher);
        Orders.setOnAction(watcher);
        People.setOnAction(watcher);

        // give sub menu buttons event detection
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
        recieveOrder.setOnAction(watcher);
        registerOffering.setOnAction(watcher);
        deregisterOffering.setOnAction(watcher);

        // give general buttons event detection
        goHome.setOnAction(watcher);

        // create categories layout
        categories = new VBox();
        categories.getChildren().addAll(Products, Suppliers, Orders, People);

        // set up Products layout
        productsLay = new VBox();
        Label productLab = new Label("Product Options:");
        productsLay.getChildren().addAll(productLab, registerProduct, deregisterProduct, orderProduct);

        // set up Suppliers layout
        suppliersLay = new VBox();
        Label suppliersLab = new Label("Supplier Options:");
        suppliersLay.getChildren().addAll(suppliersLab, registerSupplier, deregisterSupplier, registerOffering, deregisterOffering);

        // set up Orders layout
        ordersLay = new VBox();
        Label ordersLab = new Label("Order Options:");
        ordersLay.getChildren().addAll(ordersLab, orderProduct, recieveOrder);

        // set up People layout
        peopleLay = new VBox();
        Label peopleLab = new Label("People Options:");
        peopleLay.getChildren().addAll(peopleLab, registerCustomer, registerDoctor, registerEmployee, deletePerson, addPrescription,
                deletePrescription);

        // set up homeMenu and add Buttons
        homeMenu = new HBox();
        homeMenu.getChildren().addAll(categories);
        home = new Scene(homeMenu, 300, 300);

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
