import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;

    Button button = new Button("Convert");

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Temperature Unit Converter");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(layout, 800, 100);
        scene.getStylesheets().add("WindowStyle.css");
        primaryStage.setScene(scene);

        window.show();
    }


}
