package Work;/**
 * Created by Sean on 11/17/2015.
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
import javafx.stage.Stage;

/**TRY CREATING ONE ARRAY AND SPLITTING WITHIN FOR LOOP*/
public class ElevatorDemo extends Application {

    // Create an array of buttons
    int numOfButtons = 10;
   // int numOfButtons2 = 5;
    Button[] buttonsArray = new Button[numOfButtons];
    //Button[] buttonsArray2 = new Button[numOfButtons2];
    int[] strArr = {9,7,5,3,1};
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
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private HBox getHBox1() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15));
        hBox.getChildren().add(test);
        hBox.getChildren().add(clear);
        test.setOnAction(ButtonHandler3);
        test.setPrefWidth(75);
        clear.setOnAction(ButtonHandler4);
        clear.setPrefWidth(75);
        return hBox;
    }

    private VBox getVBox1() {
        VBox vBox = new VBox(15);
        int count=0;
        int[] nums = {9,7,5,3,1};
        for (int i=0; i < numOfButtons; i++) {
            buttonsArray[nums[i]] = new Button(Integer.toString(nums[i]));
            buttonsArray[nums[i]].setPrefWidth(90);
            buttonsArray[nums[i]].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
            vBox.getChildren().add(buttonsArray[nums[i]]);
            buttonsArray[nums[i]].setOnAction(ButtonHandler);
        }
        return vBox;
    }

    private VBox getVBox2() {
        VBox vBox = new VBox(15);
        int[] nums = {10,8,6,4,2};
        for (int i=0; i < numOfButtons; i++) {

            // Set the button number as text for the button
            buttonsArray[nums[i]] = new Button(Integer.toString(nums[i]));

            // Set preferred width and style with a light gray background
            buttonsArray[nums[i]].setPrefWidth(90);
            buttonsArray[nums[i]].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            vBox.getChildren().add(buttonsArray[nums[i]]);
            buttonsArray[nums[i]].setOnAction(ButtonHandler2);
        }
        return vBox;
    }

    /**First Row*/
    EventHandler<ActionEvent> ButtonHandler = e -> {
        Button a = (Button) e.getSource();
        int i = Integer.parseInt(a.getText());
        buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: Yellow");

    };

    /**Second Row*/
    EventHandler<ActionEvent> ButtonHandler2 = e -> {
        Button b = (Button) e.getSource();
        int i = Integer.parseInt(b.getText());
        buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
    };

    /**Test Button*/
    EventHandler<ActionEvent> ButtonHandler3 = e -> {
        try {
            for (int i = numOfButtons; i >= 0; i--) {
                //set all to "Selected"
                buttonsArray[i - 1].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
               // buttonsArray[i - 1].setStyle("-fx-font: 22 arial; -fx-base: Yellow");
            }
        } catch (Exception e1) {
            //Null warning
        }
    };

    /**Clear Button*/
    EventHandler<ActionEvent> ButtonHandler4 = e -> {
        try {
            for (int i = numOfButtons; i >= 0; i--) {
                //Set all to "Unselected"
                buttonsArray[i - 1].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
               // buttonsArray2[i - 1].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
            }
        } catch (Exception e1) {
            //Null warning
        }
    };
}
