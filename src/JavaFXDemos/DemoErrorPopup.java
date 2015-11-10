package JavaFXDemos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by Sean on 10/28/2015.
 */
public class DemoErrorPopup extends Application {
    /**Variables go here*/

    private TextField tfLength = new TextField(); //user enters length
    private TextField tfWidth = new TextField(); //user enters width
    private TextField tfArea = new TextField(); //where the area goes
    private TextField tfPerimeter = new TextField(); //where the perimeter goes
    private Button btCalculate = new Button("Calculate"); //button to press for calculations

    static Alert alert;
    private Label error = new Label();

    @Override
    public void start(Stage primaryStage) {
        /**GUI*/
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); //centers alignment of labels and textfields
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        GridPane errorPane = new GridPane();
        errorPane.setAlignment(Pos.CENTER);
        errorPane.setHgap(5);
        errorPane.setVgap(5);
        errorPane.add(error, 0, 0);


        gridPane.add(new Label("Length"), 0, 0);
        gridPane.add(tfLength, 1, 0);

        gridPane.add(new Label("Width"), 0, 1);
        gridPane.add(tfWidth, 1, 1);

        gridPane.add(new Label("Area"), 0, 2);
        gridPane.add(tfArea, 1, 2);

        gridPane.add(new Label("Perimeter"), 0, 3);
        gridPane.add(tfPerimeter, 1, 3);

        gridPane.add(btCalculate, 1, 6); //our button

        /**PROPERTIES FOR UI*/
        primaryStage.setResizable(false); //set to unchangeable
        tfArea.setEditable(false); //user cannot type or click field
        tfPerimeter.setEditable(false); //user cannot type or click field

        /**PROCESS EVENTS*/
        ButtonHandlerClass handler1 = new ButtonHandlerClass();
        btCalculate.setOnAction(handler1);

        /**CREATE A SCENE*/
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Area and Perimeter Calculator"); //title
        primaryStage.setScene(scene);
        primaryStage.show();

       // Scene stage = new Scene(errorPane, 300, 200);
       // primaryStage.setTitle("ERROR!"); //title
        //primaryStage.show();
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
       // alert.setHeaderText("Whoops, something went wrong.");
        alert.setContentText("Positive integers only!");
    }

    class ButtonHandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //Calculate area and perimeter
           // String length = tfLength.getText();
            //String width = tfWidth.getText();
            double length2 = Double.parseDouble(tfLength.getText());
            double width2 = Double.parseDouble(tfWidth.getText());
            double area = length2 * width2;
            double perimeter = (length2 * 2) + (width2 * 2);

            //alert.showAndWait();
            if (length2 < 0 || width2 < 0) {
                alert.showAndWait();
            }

           else {
                // Display calculations
                tfArea.setText("" + area); //display area
                tfPerimeter.setText("" + perimeter); //display perimeter
            }
        }
    }
}

