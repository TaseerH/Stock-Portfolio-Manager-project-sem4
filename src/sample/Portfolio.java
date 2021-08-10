package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Scanner;

import static javafx.fxml.FXMLLoader.load;

public class Portfolio {
    public Button addnew;
    public Button update;
    public Button backbt;
    public TextArea portfoliolist;

    public void addnewstock(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = load(Objects.requireNonNull(getClass().getResource("addnew.fxml")));
        primaryStage.setTitle("Add to Portfolio");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public void gobacktousrpage(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = load(Objects.requireNonNull(getClass().getResource("userpage.fxml")));
        primaryStage.setTitle("Add to Portfolio");
        primaryStage.setScene(new Scene(root, 1000, 450));
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public void UPDATEtext(ActionEvent event) throws Exception {
        portfoliolist.setText(""+ "\n");
        FileInputStream fis = new FileInputStream("CompanyData.txt");
        Scanner in = new Scanner(fis);
        while (in.hasNext()){
            String text = in.nextLine();
            portfoliolist.appendText(text);
            portfoliolist.appendText("\n");
        }

    }
}
