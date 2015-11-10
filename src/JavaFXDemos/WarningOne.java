package JavaFXDemos;/**
 * Created by Sean on 11/3/2015.
 */

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class WarningOne extends Application {

    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("Careful with the next step!");

        alert.showAndWait();

    }
}
