package JavaFXDemos;/**
 * Created by Sean on 10/28/2015.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.*;

public class MultipleStageDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
    //create a scene and place a button in the scene
        Scene scene = new Scene(new Button("OK"), 200, 250);
        primaryStage.setTitle("My JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage(); // create a new stage
        stage.setTitle("Second Stage");
        //Set a scene with a button in the stage
        stage.setScene(new Scene(new Button("New Stage"), 150, 150));
        stage.setResizable(false); //user cannot modify this stage!
        stage.show(); //Display stage
    }
}
