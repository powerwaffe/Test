package Work;
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

/**
 * Created by Sean on 10/28/2015.
 */
public class GUIGeometryCalc extends Application {
    /**Variables go here*/

    private TextField tfLength = new TextField(); //user enters length
    private TextField tfWidth = new TextField(); //user enters width
    private TextField tfArea = new TextField(); //where the area goes
    private TextField tfPerimeter = new TextField(); //where the perimeter goes
    private Button btCalculate = new Button("Calculate"); //button to press for calculations

    @Override
    public void start(Stage primaryStage) {

        /**GUI*/
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); //centers alignment of labels and textfields
        gridPane.setHgap(5);
        gridPane.setVgap(5);

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
    }

    class ButtonHandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //Calculate area and perimeter
            double length = Double.parseDouble(tfLength.getText());
            double width = Double.parseDouble(tfWidth.getText());

            double area = length*width;
            double perimeter = (length*2)+(width*2);

            // Display calculations
            tfArea.setText("" + area); //display area
            tfPerimeter.setText("" + perimeter); //display perimeter
        }
    }
}

