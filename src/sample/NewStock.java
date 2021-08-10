package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class NewStock {
    public Button newstock;
    public Button backbt;
    public TextField newsymbol;
    public TextArea newdetails;
    public TextField newprice;
    public TextField newname;
    public TextField newstonks;
    public Label validation;

    public void backtoadminpage(ActionEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = load(Objects.requireNonNull(getClass().getResource("Adminpage.fxml")));
        primaryStage.setTitle("User Panel");
        primaryStage.setScene(new Scene(root, 1000, 450));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void Handlenewstockbutton(ActionEvent event) throws Exception {
        if (newsymbol.getText().equals("") || newdetails.getText().equals("") || newprice.getText().equals("") || newname.getText().equals("") || newstonks.getText().equals("")) {
            validation.setText("Complete All Fields");
        } else {

            FileOutputStream fos = new FileOutputStream("Masterlist.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("Company Name: " + newname.getText() +"     " + "Stock Price: " + newprice.getText() +"     " + "Stock Symbol: " + newsymbol.getText() +"     " + "Number of Stocks Available: " + newstonks.getText());
            pw.println("Company Details: " + newdetails.getText());
            pw.println("-----");
            pw.close();

            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = load(Objects.requireNonNull(getClass().getResource("Adminpage.fxml")));
            primaryStage.setTitle("User Panel");
            primaryStage.setScene(new Scene(root, 1000, 450));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }
}
