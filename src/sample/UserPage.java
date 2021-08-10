package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.util.Scanner;

public class UserPage {
    public Button usrlogout;
    public Button viewportfolio;

    public void Handleclick(@NotNull ActionEvent event) throws Exception{

            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Stock Portfolio Manger");
            primaryStage.setScene(new Scene(root, 350, 250));
            primaryStage.setResizable(false);
            primaryStage.show();

    }

    public Button viewstonks;
    public TextArea Stonkus;
    public void bonks(ActionEvent event) throws Exception {
        Stonkus.setText(""+ "\n");
        FileInputStream fis = new FileInputStream("Masterlist.txt");
        Scanner in = new Scanner(fis);
        while (in.hasNext()){
            String text = in.nextLine();
            Stonkus.appendText(text);
            Stonkus.appendText("\n");
        }

    }

    public void Checkportfolio(@NotNull ActionEvent event) throws Exception{

        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Portfolio.fxml"));
        primaryStage.setTitle("User Portfolio");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
