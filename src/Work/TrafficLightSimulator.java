package Work;/**
 * Created by Sean on 11/22/2015.
 */


import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TrafficLightSimulator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        /**Create circle array*/
        Circle[] circle = new Circle[3];

        /**HBox to load VBox into*/
        HBox hBox = new HBox(30); //load vBox into hBox

        /**Circle parameters*/
        circle[0] = new Circle();
        circle[0].setRadius(50);
        circle[0].setStroke(Color.BLACK);
        circle[0].setFill(Color.BLACK);

        circle[1] = new Circle();
        circle[1].setRadius(50);
        circle[1].setStroke(Color.BLACK);
        circle[1].setFill(Color.BLACK);

        circle[2] = new Circle();
        circle[2].setRadius(50);
        circle[2].setStroke(Color.BLACK);
        circle[2].setFill(Color.GREEN);

        /**VBox to load HBox into*/
        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-background-color: grey");
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(circle[0], circle[1], circle[2]);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox);

        /**Set scene*/
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Traffic Light Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        /**Green to Yellow*/
        EventHandler<ActionEvent> eventHandler1 = e -> {
            if (circle[2].getFill() == Color.GREEN) {
                circle[2].setFill(Color.BLACK);
                circle[1].setFill(Color.YELLOW);
            }
        };

        /**Yellow to Red*/
        EventHandler<ActionEvent> eventHandler2 = e -> {
            if (circle[1].getFill() == Color.YELLOW) {
                circle[1].setFill(Color.BLACK);
                circle[0].setFill(Color.RED);
            }
        };

        /**Red to Green*/
        EventHandler<ActionEvent> eventHandler3 = e -> {
            if (circle[0].getFill() == Color.RED) {
                circle[0].setFill(Color.BLACK);
                circle[2].setFill(Color.GREEN);
            }
        };

        // Create an animation to trigger an event every half-second
        Timeline animation1 = new Timeline(new KeyFrame(Duration.seconds(1), eventHandler1));
        animation1.setCycleCount(Timeline.INDEFINITE);
        animation1.play();

        Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(2), eventHandler2));
        animation2.setCycleCount(Timeline.INDEFINITE);
        animation2.play();

        Timeline animation3 = new Timeline(new KeyFrame(Duration.seconds(3), eventHandler3));
        animation3.setCycleCount(Timeline.INDEFINITE);
        animation3.play();
    }
}