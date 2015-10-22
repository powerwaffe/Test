package JavaFXDemos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Sean on 10/20/2015.
 */

public class GraphicDemo1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btOK = new Button("Click Here! FREE WINDOWS 98!!!!");
        Scene scene = new Scene(btOK, 200, 250);
        primaryStage.setTitle("My First Demo");
        primaryStage.setScene(scene);
        primaryStage.show(); //shows GUI

        Stage stage = new Stage();
        stage.setTitle("Second Stage");
        stage.setScene(new Scene(new Button("New Stage"), 100, 100));
        stage.show();
    }
}
