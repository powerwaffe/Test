package JavaFXDemos;/**
 * Created by Sean on 11/3/2015.
 */

// Creating and handling radio buttons and check boxes

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Created by emailman on 11/1/2015.
 */

public class CheckAndRadioButtons extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create three radio buttons
        RadioButton rbWhite = new RadioButton("White");
        RadioButton rbWheat = new RadioButton("Wheat");
        RadioButton rbRye = new RadioButton("Rye");

        // Put the radio buttons in a toggle group
        ToggleGroup tgBread = new ToggleGroup();
        rbWhite.setToggleGroup(tgBread);
        rbWheat.setToggleGroup(tgBread);
        rbRye.setToggleGroup(tgBread);

        // Put the radio buttons in a VBox
        VBox vBox1 = new VBox(10, rbWhite, rbWheat, rbRye);

        // Create two labels for the bread and condiment choices
        Label lbBread = new Label();
        lbBread.setMinWidth(250);
        lbBread.setAlignment(Pos.CENTER);

        Label lbCondiment = new Label();
        lbCondiment.setMinWidth(250);
        lbCondiment.setAlignment(Pos.CENTER);

        // Put the two labels in a VBox
        VBox vBox2 = new VBox(20, lbBread, lbCondiment);

        // Create three check boxes for the condiment choices
        CheckBox cbMustard = new CheckBox("Mustard");
        CheckBox cbKetchup = new CheckBox("Ketchup");
        CheckBox cbMayonnaise = new CheckBox("Mayonnaise");

        // Put the three check boxes in a VBox
        VBox vBox3 = new VBox(10, cbMustard, cbKetchup, cbMayonnaise);

        // Put the three vBoxes in an HBox
        HBox hBox = new HBox(10, vBox1, vBox2, vBox3);
        hBox.setPadding(new Insets(20));

        // Build the scene and the stage
        Scene scene = new Scene(hBox, 450, 100);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Sand Witch Order Form");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Build an event handler for the check boxes
        EventHandler<ActionEvent>  handler1 = e -> {
            String message = "";

            // If any condiment is selected, build a string of each one selected
            if (cbMustard.isSelected() || cbKetchup.isSelected() || cbMayonnaise.isSelected()) {
                if (cbMustard.isSelected())
                    message += "Mustard ";
                if (cbKetchup.isSelected())
                    message += "Ketchup ";
                if (cbMayonnaise.isSelected())
                    message += "Mayonnaise";
                lbCondiment.setText("With " + message);
            }
            else {
                // Blank the text field if nothing no condiment was selected
                lbCondiment.setText("");
            }
        };

        // Attach the three check boxes to one handler
        cbKetchup.setOnAction(handler1);
        cbMustard.setOnAction(handler1);
        cbMayonnaise.setOnAction(handler1);

        // Build an event handler for the radio buttons
        EventHandler<ActionEvent>  handler2 = e -> {
            String message = "";
            if (rbWhite.isSelected())
                message = "On White Bread";
            if (rbWheat.isSelected())
                message = "On Wheat Bread";
            if (rbRye.isSelected())
                message = "On Rye Bread";
            lbBread.setText(message);
        };

        // Attach the three radio buttons to one handler
        rbWhite.setOnAction(handler2);
        rbWheat.setOnAction(handler2);
        rbRye.setOnAction(handler2);
    }
}