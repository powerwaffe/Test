package Demo;

import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Created by Sean on 11/1/2015.
 */
public class DemoDialog extends Application {

    @Override
    public void start(Stage primaryStage) {

        /**DIsplays error*/
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("There was an error with your input!");
        alert.setContentText("Please use positive integers in the correct fields.");

        alert.showAndWait();
    }
}
