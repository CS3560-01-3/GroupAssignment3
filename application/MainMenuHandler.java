package application;

//local imports
import dBs.*;

//javaFX imports
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;

public class MainMenuHandler implements EventHandler<ActionEvent> {

    public static void setupHome() {

    }

    // handle
    @Override
    public void handle(ActionEvent event) {

        // categories-menu events
        if (event.getSource() == Main.Products) {
            Main.homeMenu.getChildren().clear();

            final Separator sepHor = new Separator();
            sepHor.setOrientation(Orientation.VERTICAL);

            Main.homeMenu.getChildren().addAll(Main.categories, sepHor, Main.productsLay);

        } else if (event.getSource() == Main.Suppliers) {
            Main.homeMenu.getChildren().clear();

            final Separator sepHor = new Separator();
            sepHor.setOrientation(Orientation.VERTICAL);

            Main.homeMenu.getChildren().addAll(Main.categories, sepHor, Main.suppliersLay);

        } else if (event.getSource() == Main.Orders) {
            Main.homeMenu.getChildren().clear();

            final Separator sepHor = new Separator();
            sepHor.setOrientation(Orientation.VERTICAL);

            Main.homeMenu.getChildren().addAll(Main.categories, sepHor, Main.ordersLay);

        } else if (event.getSource() == Main.People) {
            Main.homeMenu.getChildren().clear();

            final Separator sepHor = new Separator();
            sepHor.setOrientation(Orientation.VERTICAL);

            Main.homeMenu.getChildren().addAll(Main.categories, sepHor, Main.peopleLay);

        }

        // sub-menu events
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
            Order.placeOrder(Main.primaryStage, Main.home);

        } else if (event.getSource() == Main.deregisterProduct) {
            Product.deregister(Main.primaryStage, Main.home);

        } else if (event.getSource() == Main.addPrescription) {
            Prescription.addPerscription(Main.primaryStage, Main.home);

        } else if (event.getSource() == Main.deletePrescription) {
            Main.primaryStage.setScene(Main.empty);

        } else if (event.getSource() == Main.registerSupplier) {
            Supplier.register(Main.primaryStage, Main.home);

        } else if (event.getSource() == Main.deregisterSupplier) {
            Supplier.deregisterSupplier(Main.primaryStage, Main.home);

        } else if (event.getSource() == Main.goHome) {
            Main.primaryStage.setScene(Main.home);

        } else if (event.getSource() == Main.recieveOrder) {
            Order.recieved(Main.primaryStage, Main.home);
            
        } else if (event.getSource() == Main.registerOffering) {
            Offering.register(Main.primaryStage, Main.home);
            
        } else if (event.getSource() == Main.deregisterOffering) {
            Offering.deregister(Main.primaryStage, Main.home);
        }

    }
}
