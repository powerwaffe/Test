package JavaFXDemos;/**
 * Created by Sean on 11/9/2015.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HandleEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**Create pane and set its properties*/
        HBox pane = new HBox(15);
        pane.setAlignment(Pos.CENTER);

        Button btOk = new Button("OK");
        Button btCancel = new Button("Cancel");

        OkHandlerClass handler1 = new OkHandlerClass();
        btOk.setOnAction(handler1);

        CancelHandlerClass handler2 = new CancelHandlerClass();
        btCancel.setOnAction(handler2);

        pane.getChildren().addAll(btOk, btCancel);

        /**Create a scene and place it in the stage*/
        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class OkHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("OK button clicked");
        }
    }

    class CancelHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("Cancel button clicked");
        }
    }
}


