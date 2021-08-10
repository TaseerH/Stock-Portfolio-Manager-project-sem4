package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class addnew{
    public Button Addtoportfolio;
    public TextField stockN;
    public TextField stockP;
    public TextField stockS;
    public TextField noStocks;
    public Label emptlbl;


    public void backtoportfolio(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = load(Objects.requireNonNull(getClass().getResource("Portfolio.fxml")));
        primaryStage.setTitle("Add to Portfolio");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();


    }



    public void Handleaddtoportfolio(ActionEvent event) throws Exception {
        if (stockN.getText().equals("") || stockP.getText().equals("") || noStocks.getText().equals("") || stockS.getText().equals("")) {
            emptlbl.setText("Complete All Fields");
        } else {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = load(Objects.requireNonNull(getClass().getResource("Portfolio.fxml")));
            primaryStage.setTitle("User Panel");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setResizable(false);
            primaryStage.show();

            String Cname = stockN.getText();
            String Cprice = stockP.getText();
            String Csymbol = stockS.getText();
            String Noofstocks = noStocks.getText();

            FileOutputStream fos = null;

            {
                try {
                    fos = new FileOutputStream("CompanyData.txt", true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            PrintWriter pw = new PrintWriter(fos);
            pw.println("Company Name: " + Cname);
            pw.println("Company Stock Price: " + Cprice);
            pw.println("Company Symbol: " + Csymbol);
            pw.println("Number of Stocks: " + Noofstocks);
            pw.println("-----");
            pw.close();
        }
    }


}
