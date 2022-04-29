package application;

// SQL imports
import java.sql*;

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

public class Main extends Application implements EventHandler<ActionEvent> {

    // mainMenu buttons
    private Button registerProduct = new Button("Register New Product");
    private Button orderProduct = new Button("order Product");
    private Button deregisterProduct = new Button("deregister Product");
    private Button addPerscription = new Button("add Perscription");
    private Button deletePerscription = new Button("delete Perscription");
    private Button registerSupplier = new Button("registerSupplier");
    private Button deregisterSupplier = new Button("deregisterSupplier");

    // home button
    private Button goHome = new Button("Home");

    // window stuff
    private static Stage primaryStage;
    public static Scene home;

    // to be removed later
    public static Scene empty;

    // data
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
        orderProduct.setOnAction(this);
        deregisterProduct.setOnAction(this);
        addPerscription.setOnAction(this);
        deletePerscription.setOnAction(this);
        registerSupplier.setOnAction(this);
        deregisterSupplier.setOnAction(this);

        // give general buttons event detection
        goHome.setOnAction(this);

        // create mainMenu and add Buttons
        VBox mainMenu = new VBox();
        Label mainLab = new Label("Main Menu");
        mainMenu.getChildren().addAll(mainLab, registerProduct, orderProduct, deregisterProduct, addPerscription,
                deletePerscription, registerSupplier, deregisterSupplier);
        home = new Scene(mainMenu, 300, 250);

        // create emptyMenu and add Button
        VBox emptyMenu = new VBox();
        Label unFinished = new Label("This option has not yet been implemented.");
        emptyMenu.getChildren().addAll(unFinished, goHome);
        empty = new Scene(emptyMenu, 300, 250);

        // show main menu
        primaryStage.setScene(home);
        primaryStage.show();
    }

    // handle
    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == registerProduct) {
            Product.registerProduct(products, primaryStage, home);
            

        } else if (event.getSource() == orderProduct) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == deregisterProduct) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == addPerscription) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == deletePerscription) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == registerSupplier) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == deregisterSupplier) {
            primaryStage.setScene(empty);

        } else if (event.getSource() == goHome) {
            primaryStage.setScene(home);
        }
    }

    // method to access database
    public static void accesDB() {
   //  change url dependently
   String url ="jdbc:mysql://127.0.0.1:3306/groupassignment";
   String user ="root";
   String password ="Jokerstom123";

   Connection conn = null;
   Statement stmt = null;

   try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(url,user,password);
      stmt = conn.createStatement();



  } catch (SQLException e1) {
      e1.printStackTrace();
  }catch (ClassNotFoundException e) {
      e.printStackTrace();
  }
}
}
}
