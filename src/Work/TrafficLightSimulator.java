package Work;/**
 * Created by Sean on 11/22/2015.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
        circle[0].setFill(Color.RED);

        circle[1] = new Circle();
        circle[1].setRadius(50);
        circle[1].setStroke(Color.BLACK);
        circle[1].setFill(Color.BLACK);

        circle[2] = new Circle();
        circle[2].setRadius(50);
        circle[2].setStroke(Color.BLACK);
        circle[2].setFill(Color.BLACK);

        /**VBox to load HBox into*/
        VBox vBox = new VBox(10);
        vBox.setStyle("-fx-background-color: gold");
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

        /**Start new Thread to induce sleep for traffic light color*/
        new Thread(() -> {
            try { //catch exception
                while (true) {
                    if (circle[2].getFill() == Color.GREEN) { //green to yellow
                        circle[2].setFill(Color.BLACK);
                        circle[1].setFill(Color.YELLOW);
                        Thread.sleep(2000); //2 second sleep on yellow
                    }

                    else if (circle[1].getFill() == Color.YELLOW) { //yellow to red
                        circle[1].setFill(Color.BLACK);
                        circle[0].setFill(Color.RED);
                        Thread.sleep(10000); //10 second sleep on red
                    }

                    else if (circle[0].getFill() == Color.RED) { //red to green
                        circle[0].setFill(Color.BLACK);
                        circle[2].setFill(Color.GREEN);
                        Thread.sleep(15000); //15 second sleep on green
                    }
                }
            }
            catch (Exception e) {
            }
        }).start(); //launch GUI
    }
}