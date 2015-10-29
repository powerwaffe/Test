package JavaFXDemos;/**
 * Created by Sean on 10/28/2015.
 */

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class ButtonInPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create a scene and place a button in the scene
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("OK"));
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Button in a pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
