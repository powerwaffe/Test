package Work;/**
 * Created by Sean on 11/19/2015.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AddressForm extends Application {

    /**
     * Fields and buttons
     */
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();
    private Button btFirst = new Button("First");
    private Button btPrevious = new Button("Previous");
    private Button btNext = new Button("Next");
    private Button btLast = new Button("Last");
    private Label lRecord = new Label("Label Field->");

    @Override
    public void start(Stage primaryStage) {

        /**GUI*/
        GridPane pane = new GridPane();
        //pane.setStyle("-fx-background-color: grey");
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);


        /**Scene*/
        Scene scene = new Scene(pane);
        primaryStage.setTitle("AddressForm");
        primaryStage.setScene(scene);
        primaryStage.show();

        /**Labels*/
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);

        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);

        pane.add(new Label("City"), 0, 2);
        pane.add(tfCity, 1, 2);

        pane.add(new Label("State"), 2, 2);
        pane.add(tfState, 3, 2);

        pane.add(new Label("Zip"), 4, 2);
        pane.add(tfZip, 5, 2);

        pane.add(btFirst, 0, 3);
        btFirst.setPrefWidth(120);
        pane.add(btPrevious, 1, 3);
        btPrevious.setPrefWidth(120);
        pane.add(btNext, 2, 3);
        btNext.setPrefWidth(120);
        pane.add(btLast, 3, 3);
        btLast.setPrefWidth(120);
        pane.add(lRecord, 0, 4);
    }

    class ButtonHandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
        }
    }

    private HBox getHBox() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15));
        hBox.getChildren().add(btFirst);
        hBox.getChildren().add(btPrevious);
        hBox.getChildren().add(btNext);
        hBox.getChildren().add(btLast);
        return hBox;
    }
}
