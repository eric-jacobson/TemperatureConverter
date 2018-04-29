import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Temperature Unit Converter");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(8);
        layout.setHgap(10);

        Label tempLabel = new Label("Temperature:");
        tempLabel.setStyle("-fx-text-fill: #E8E8E8");
        GridPane.setConstraints(tempLabel, 0, 2);

        TextField tempInput = new TextField();
        GridPane.setConstraints(tempInput, 1, 2);

        Button celsiusButton = new Button("Convert to C");
        GridPane.setConstraints(celsiusButton, 20, 2);
        celsiusButton.setOnAction(e -> AlertBox.displayAlert("Error!", "Alert box is working!"));

        Button fahrenheitButton = new Button("Convert to F");
        GridPane.setConstraints(fahrenheitButton, 21, 2);

        layout.getChildren().addAll(tempLabel, tempInput, celsiusButton, fahrenheitButton);

        Scene scene = new Scene(layout, 800, 100);
        scene.getStylesheets().add("WindowStyle.css");
        primaryStage.setScene(scene);

        window.show();
    }


}
