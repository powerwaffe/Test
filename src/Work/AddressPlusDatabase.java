package Work;


/**
 * Created by spaoli1 on 12/10/2015.
 */
import Databases.DBaseDemo6;
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

import java.sql.*;

public class AddressPlusDatabase extends Application {
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

    static String sql;

    @Override
    public void start(Stage primaryStage) {

        /**Start reading database*/
        initializeDatabase();

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
            tfName.setText(sql);
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

    private void initializeDatabase() {
        //sql = "SELECT * FROM Address";
        try {
            // This needs to be included in the External Libraries:
            // mysql-connector-java-5.1.37-bin.jar
            // for the following statement to work
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://dtcc150java.tk/db-sean?user=spaoli&password=sp060790");
            System.out.println("Database connection OK");

            // Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Address");

            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                System.out.printf("%-12s\t", resultSetMetaData.getColumnName(i));
            System.out.println();


            // Report results
            while (rs.next()) {
                tfName.setText(rs.getString(2));
                tfStreet.setText(rs.getString(3));
                tfCity.setText(rs.getString(4));
                tfState.setText(rs.getString(5));
                tfZip.setText(rs.getString(6));

                for (int i =1; i <= resultSetMetaData.getColumnCount(); i++)
                    System.out.printf("%-12s\t", rs.getObject(i));
                System.out.println();
                // System.out.println(rs.getObject(1));
                // System.out.println(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) +
                //  " " + rs.getString(5) + " " +  rs.getString(6));
                //s1 = rs.getString(2);
            }

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
        //System.out.println(s1);
    }
}
