package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class Controller {
    public Button login;
    public TextField usrname;
    public PasswordField password;
    public Label labelErrorer;
    public void HandleButtonClick(ActionEvent event) throws Exception{
        if (usrname.getText().equals("Investor") && password.getText().equals("123")){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = load(Objects.requireNonNull(getClass().getResource("Userpage.fxml")));
            primaryStage.setTitle("User Panel");
            primaryStage.setScene(new Scene(root, 1000, 450));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        else if (usrname.getText().equals("Admin123") && password.getText().equals("admin123")){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Adminpage.fxml"));
            primaryStage.setTitle("Admin Panel");
            primaryStage.setScene(new Scene(root, 1000, 450));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        else{
            labelErrorer.setText("Incorrect Details!");

        }
    }
}