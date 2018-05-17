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

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window;
        window = primaryStage;
        window.setTitle("Temperature Unit Converter");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(8);
        layout.setHgap(10);

        Label tempLabel;
        tempLabel = new Label("Temperature:");
        tempLabel.setStyle("-fx-text-fill: #E8E8E8");
        GridPane.setConstraints(tempLabel, 0, 2);

        TextField tempInput;
        tempInput = new TextField();
        GridPane.setConstraints(tempInput, 1, 2);

        Label equLabel;
        equLabel = new Label(" = ");
        equLabel.setStyle("-fx-text-fill: #E8E8E8");
        GridPane.setConstraints(equLabel, 2, 2);

        TextField tempOutput;
        tempOutput = new TextField();
        GridPane.setConstraints(tempOutput, 3, 2);

        Button celsiusButton;
        celsiusButton = new Button("Convert to C");
        GridPane.setConstraints(celsiusButton, 5, 2);
        celsiusButton.setOnAction(e -> {
            if(verifyInput(tempInput, tempInput.getText())){
                celsius(tempInput, tempOutput);
            }
        });

        Button fahrenheitButton;
        fahrenheitButton = new Button("Convert to F");
        GridPane.setConstraints(fahrenheitButton, 6, 2);
        fahrenheitButton.setOnAction(e -> {
            if(verifyInput(tempInput, tempInput.getText())){
                fahrenheit(tempInput, tempOutput);
            }
        });

        layout.getChildren().addAll(tempLabel, tempInput, equLabel, tempOutput, celsiusButton, fahrenheitButton);

        Scene scene = new Scene(layout, 800, 100);
        scene.getStylesheets().add("WindowStyle.css");
        primaryStage.setScene(scene);

        window.show();
    }

    private boolean verifyInput(TextField input, String message){
        try {
            double temp = Double.parseDouble(message);
            return true;
        }catch (NumberFormatException e){
            AlertBox.displayAlert("Input Error", "Input must be a number!");
            return false;
        }
    }

    private void celsius(TextField input, TextField output){
        double temp = Double.parseDouble(input.getText());
        temp = ConvertF.convertF(temp);
        output.setText(temp + "°");
    }

    private void fahrenheit(TextField input, TextField output){
        double temp = Double.parseDouble(input.getText());
        temp = ConvertC.convertC(temp);
        output.setText(temp + "°");
    }
}
