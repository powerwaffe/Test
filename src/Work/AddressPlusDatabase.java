package Work;


/**
 * Created by spaoli1 on 12/10/2015.
 */

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
import java.sql.*;
import java.util.ArrayList;

public class AddressPlusDatabase extends Application {

    /**Fields and buttons*/
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();
    private Button btFirst = new Button("First");
    private Button btPrevious = new Button("Previous");
    private Button btNext = new Button("Next");
    private Button btLast = new Button("Last");
    private Label lRecord = new Label("");

    @Override
    public void start(Stage primaryStage) {

        /**Start reading database*/
        initializeDatabase();

        /**GUI*/
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        /**Scene*/
        Scene scene = new Scene(pane);
        primaryStage.setTitle("AddressForm");
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(550);
        primaryStage.setScene(scene);
        primaryStage.show();

        /**Labels*/
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);
        tfName.setEditable(false);

        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);
        tfStreet.setEditable(false);

        pane.add(new Label("City"), 0, 2);
        pane.add(tfCity, 1, 2);
        tfCity.setEditable(false);

        pane.add(new Label("State"), 0, 3);
        pane.add(tfState, 1, 3);
        tfState.setEditable(false);

        pane.add(new Label("Zip"), 0, 4);
        pane.add(tfZip, 1, 4);
        tfZip.setEditable(false);

        pane.add(btPrevious, 0, 5);
        btPrevious.setPrefWidth(100);
        pane.add(btFirst, 1, 5);
        btFirst.setPrefWidth(100);
        pane.add(btLast, 0, 6);
        btLast.setPrefWidth(100);
        pane.add(btNext, 1, 6);
        btNext.setPrefWidth(100);
        pane.add(lRecord, 1, 7);
    }

    /**NOT IMPLEMENTED*/
    class ButtonHandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
        }
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://dtcc150java.tk/db-sean?user=spaoli&password=sp060790");

            System.out.println("Database connection OK");

            //Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Address");

            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                System.out.printf("%-12s\t", resultSetMetaData.getColumnName(i));
            System.out.println();

            //Report results
            while (rs.next()) {
                tfName.setText(rs.getString(2));
                tfStreet.setText(rs.getString(3));
                tfCity.setText(rs.getString(4));
                tfState.setText(rs.getString(5));
                tfZip.setText(rs.getString(6));
                lRecord.setText(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " +
                        rs.getString(5) + " " + rs.getString(6));

                //console table printout
                for (int i =1; i <= resultSetMetaData.getColumnCount(); i++)
                    System.out.printf("%-12s\t", rs.getObject(i));
                System.out.println();
            }
            connection.close();
            System.out.println("\nDatabase read and program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
