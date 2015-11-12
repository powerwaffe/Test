package JavaFXDemos;/**
 * Created by Sean on 11/11/2015.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxGui extends Application {

    // Declare three combo boxes
    static ComboBox<String> cbStyle;
    static ComboBox<String> cbWaist;
    static ComboBox<String> cbLength;

    @Override
    public void start(Stage primaryStage)  {

        // Create a vertical pane
        VBox pane1 = new VBox(10);
        pane1.setAlignment(Pos.CENTER);

        // Create three combo boxes
        cbStyle = new ComboBox<>();
        cbStyle.getItems().add("Choose a Style");
        cbStyle.getItems().add("Boot Cut");
        cbStyle.getItems().add("Relaxed Fit");
        cbStyle.getItems().add("Low Rider");
        cbStyle.setPrefWidth(150);
        cbStyle.getSelectionModel().select(0);

        cbWaist = new ComboBox<>();
        cbWaist.getItems().add("Select Waist Size");
        cbWaist.getItems().add("28\"");
        cbWaist.getItems().add("29\"");
        cbWaist.getItems().add("30\"");
        cbWaist.getItems().add("31\"");
        cbWaist.getItems().add("32\"");
        cbWaist.getItems().add("33\"");
        cbWaist.getItems().add("34\"");
        cbWaist.getItems().add("36\"");
        cbWaist.getItems().add("38\"");
        cbWaist.getItems().add("40\"");
        cbWaist.setPrefWidth(150);
        cbWaist.getSelectionModel().select(0);

        cbLength = new ComboBox<>();
        cbLength.getItems().add("Select Length");
        cbLength.getItems().add("28\"");
        cbLength.getItems().add("30\"");
        cbLength.getItems().add("32\"");
        cbLength.getItems().add("34\"");
        cbLength.setPrefWidth(150);
        cbLength.getSelectionModel().select(0);

        // Add the combo boxes to pane1
        pane1.getChildren().addAll(cbStyle, cbWaist, cbLength);

        // Create a horizontal pane
        HBox pane2 = new HBox(10);
        pane2.setAlignment(Pos.CENTER);

        // Create an error alert
        Alert cancel = new Alert(Alert.AlertType.ERROR);
        cancel.setTitle("Order Alert");
        cancel.setHeaderText(null);
        cancel.setContentText("Your order has been cancelled");

        // Create an order recap alert
        Alert confirm = new Alert(Alert.AlertType.INFORMATION);
        confirm.setTitle("Order Recap");
        confirm.setHeaderText(null);

        // Create two buttons and listeners
        Button btOrder = new Button("ORDER");
        btOrder.setPrefWidth(70);
        btOrder.setOnAction(e -> {
            confirm.setContentText("Ordering:" +
                    "\n\tStyle:\t" + cbStyle.getSelectionModel().getSelectedItem() +
                    "\n\tWaist:\t" + cbWaist.getSelectionModel().getSelectedItem() +
                    "\n\tLength:\t" + cbLength.getSelectionModel().getSelectedItem());
            confirm.showAndWait();
            ClearSelections();
        });

        Button btCancel = new Button("CANCEL");
        btCancel.setPrefWidth(70);
        btCancel.setOnAction(e -> {
            cancel.showAndWait();
            ClearSelections();
        });

        // Add the buttons to pane2
        pane2.getChildren().addAll(btOrder, btCancel);

        // Create a vertical pane
        VBox pane3 = new VBox(10);
        pane3.setAlignment(Pos.CENTER);

        // Add pane1 and pane2 to pane3
        pane3.getChildren().addAll(pane1, pane2);

        // Add pane3 to a scene
        Scene scene = new Scene(pane3, 300, 250);

        // Setup the stage and put the scene on it
        primaryStage.setTitle("Snappy Jeans Order Form");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static void ClearSelections() {
        cbStyle.getSelectionModel().select(0);
        cbWaist.getSelectionModel().select(0);
        cbLength.getSelectionModel().select(0);
    }
}