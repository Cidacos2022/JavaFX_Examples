/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularionumerosprimos;

import formularionumerosprimos.Common.Constants;
import formularionumerosprimos.Common.Math;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author alumno
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtNumbers;

    @FXML
    private Label lbIsPrime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void txtNumbers_OnKeyTyped(KeyEvent event) {
        String resultado = Constants.STRING_EMPTY;
        if (!event.getCharacter().matches("[0-9]")) {
            event.consume();
        } else {
            resultado = MessageFormat.format("The number {0} is not prime.", txtNumbers.getText() + event.getCharacter());
            if (Math.isPrime(txtNumbers.getText() + event.getCharacter())) {
                resultado = MessageFormat.format("The number {0} is prime.", txtNumbers.getText() + event.getCharacter());
            }
        }
        lbIsPrime.setText(resultado);

    }

}
