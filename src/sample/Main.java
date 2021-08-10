package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        root = load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Stock Portfolio Manager");
        primaryStage.setScene(new Scene(root, 350, 250));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
