package Work;/**
 * Created by Sean on 11/9/2015.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

    public class ElevatorCommands extends Application {

        // Create an array of buttons
        int numOfButtons = 5;
        int numOfButtons2 = 5;
        Button[] buttonsArray = new Button[numOfButtons];
        Button[] buttonsArray2 = new Button[numOfButtons2];
        Button clear = new Button("Clear");
        Button test = new Button("Test");

        @Override
        public void start(Stage primaryStage) {

            BorderPane pane = new BorderPane();

            /**Set border pane style*/
            pane.setLeft(getVBox1()); //elements from vbox1
            pane.setRight(getVBox2()); //elements from vbox2
            pane.setBottom(getHBox1()); //elements from hbox1

            /**Scene*/
            Scene scene = new Scene(pane);
            primaryStage.setTitle("Elevator Panel");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private HBox getHBox1() {
            HBox hBox = new HBox(15);
            hBox.setPadding(new Insets(40));
            hBox.getChildren().add(test);
            hBox.getChildren().add(clear);
            test.setOnAction(ButtonHandler3);
            clear.setOnAction(ButtonHandler4);
            return hBox;
        }

        private VBox getVBox1() {
            VBox vBox = new VBox(15);
            for (int i = numOfButtons - 1; i >= 0; i--) {

                // Set the button number as text for the button
                buttonsArray[i] = new Button(Integer.toString(i + 1));

                // Set preferred width and style with a light gray background
                buttonsArray[i].setPrefWidth(100);
                buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

                // Add the button to the pane and set the handler
                vBox.getChildren().add(buttonsArray[i]);
                buttonsArray[i].setOnAction(ButtonHandler);
            }
            return vBox;
        }

        private VBox getVBox2() {
            VBox vBox = new VBox(15);
            for (int i = numOfButtons2 - 1; i >= 0; i--) {

                // Set the button number as text for the button
                buttonsArray2[i] = new Button(Integer.toString(i + 1));

                // Set preferred width and style with a light gray background
                buttonsArray2[i].setPrefWidth(100);
                buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

                // Add the button to the pane and set the handler
                vBox.getChildren().add(buttonsArray2[i]);
                buttonsArray2[i].setOnAction(ButtonHandler2);
            }
            return vBox;
        }

        /**First Row*/
        EventHandler<ActionEvent> ButtonHandler = e -> {
            // Identify the object that caused the event
            Button a = (Button) e.getSource();

            // Read the text field of the object and convert it to an integer
            int i = Integer.parseInt(a.getText());

            // Check the background of the button to a dark red
            buttonsArray[i - 1].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
        };

        /**Second Row*/
        EventHandler<ActionEvent> ButtonHandler2 = e -> {
            Button b = (Button) e.getSource();

            int i = Integer.parseInt(b.getText());

            buttonsArray2[i-1].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
        };

        /**Test Button*/
        EventHandler<ActionEvent> ButtonHandler3 = e -> {
            //Button c = (Button) e.getSource();

            //int i = Integer.parseInt(c.getText());

            buttonsArray[i-1].setStyle("-fx-base: Yellow");
            buttonsArray2[i-1].setStyle("-fx-base: Yellow");
        };

        /**Clear Button*/
        EventHandler<ActionEvent> ButtonHandler4 = e -> {
            //Button d = (Button) e.getSource();

           // int i = Integer.parseInt(d.getText());

            buttonsArray[i-1].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
            buttonsArray2[i-1].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
        };
    }
