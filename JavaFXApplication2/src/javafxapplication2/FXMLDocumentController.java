/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxapplication2.Common.Constants;
import javafxapplication2.Common.Math;

/**
 *
 * @author rafael
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtNumber;

    @FXML
    private Label isPrime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void txtNumber_Changed(KeyEvent event) {
        String lbText = Constants.STRING_EMPTY;
        if (!Math.isInteger(txtNumber.getText())) {
            txtNumber.setText(
                    txtNumber.getText()
                            .replace(event.getText(), Constants.STRING_EMPTY));

        } else {
            lbText = MessageFormat.format("The number {0} is not prime.", txtNumber.getText());

            if (Math.isPrime(txtNumber.getText())) {
                lbText = MessageFormat.format("The number {0} is prime.", txtNumber.getText());

            }
        }

        isPrime.setText(lbText);
    }

    @FXML
    public void nextPrimeNumber_Clicked(MouseEvent event) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);

        String result = MessageFormat.format("The next prime number is {0}", Math.nextPrime(txtNumber.getText()));

        dialogVbox.getChildren().add(new Text(result));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
