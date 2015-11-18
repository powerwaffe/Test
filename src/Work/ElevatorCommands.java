package Work;/**
 * Created by Sean on 11/9/2015.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ElevatorCommands extends Application {

    // Create button array and labels
    Button[] buttonsArray = new Button[5]; //column of buttons
    Button[] buttonsArray2 = new Button[5]; //column 2 of buttons
    Button clear = new Button("Clear");
    Button test = new Button("Test");

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();
        pane.setPrefWidth(200);

        /**Set border pane style*/
        pane.setLeft(getVBox1()); //elements from vBox1
        pane.setRight(getVBox2()); //elements from vBox2
        pane.setBottom(getHBox1()); //elements from hBox1

        /**Scene*/
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Elevator Panel");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private HBox getHBox1() {
        //Size of hBox
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15));

        //Add test and clear buttons
        hBox.getChildren().add(test);
        hBox.getChildren().add(clear);

        //set size and handlers for buttons
        test.setOnAction(ButtonHandler3);
        test.setPrefWidth(80);
        test.setPrefHeight(80);
        clear.setOnAction(ButtonHandler4);
        clear.setPrefWidth(80);
        clear.setPrefHeight(80);
        return hBox;
    }

    private VBox getVBox1() {
        VBox vBox = new VBox(15);
        int[] numArr = {9,7,5,3,1}; //integers to use at proper index

        for (int i=0; i < 5; i++) {
            //set integer from numArr as button label
            buttonsArray[i] = new Button(Integer.toString(numArr[i]));

            //characteristics of button
            buttonsArray[i].setShape(new Circle(1));
            buttonsArray[i].setPrefWidth(95);
            buttonsArray[i].setPrefHeight(90);
            buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            //add button to vBox and set the handler
            vBox.getChildren().add(buttonsArray[i]);
            buttonsArray[i].setOnAction(ButtonHandler);
        }
        return vBox;
    }

    private VBox getVBox2() {
        VBox vBox = new VBox(15);
        int[] numArr = {10,8,6,4,2}; //integers to use at proper index

        for (int i=0; i < 5; i++) {
            //set integer from numArr as button label
            buttonsArray2[i] = new Button(Integer.toString(numArr[i]));

            //characteristics of button
            buttonsArray2[i].setShape(new Circle(1));
            buttonsArray2[i].setPrefWidth(95);
            buttonsArray2[i].setPrefHeight(90);
            buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            //add the button to the vBox and set the handler
            vBox.getChildren().add(buttonsArray2[i]);
            buttonsArray2[i].setOnAction(ButtonHandler2);
        }
        return vBox;
    }

    /**First Row*/
    EventHandler<ActionEvent> ButtonHandler = e -> {
        Button a = (Button) e.getSource();
        a.setStyle("-fx-font: 22 arial; -fx-base: Yellow"); //apply style to button object a
    };

    /**Second Row*/
    EventHandler<ActionEvent> ButtonHandler2 = e -> {
        Button b = (Button) e.getSource();
        b.setStyle("-fx-font: 22 arial; -fx-base: Yellow"); //apply style to button object b
    };

    /**Test Button*/
    EventHandler<ActionEvent> ButtonHandler3 = e -> {
        try {
            for (int i = 5; i >= 0; i--) {
                //set all to "Selected"
                buttonsArray[i - 1].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
                buttonsArray2[i - 1].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
            }
        } catch (Exception e1) {
            //Null warning
        }
    };

    /**Clear Button*/
    EventHandler<ActionEvent> ButtonHandler4 = e -> {
        try {
            for (int i = 5; i >= 0; i--) {
                //Set all to "Unselected"
                buttonsArray[i - 1].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
                buttonsArray2[i - 1].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
            }
        } catch (Exception e1) {
            //Null warning
        }
    };
}
