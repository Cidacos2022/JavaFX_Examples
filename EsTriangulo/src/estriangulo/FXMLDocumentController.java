/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo;

import static estriangulo.Common.Math.getTraingleTypeMessage;
import static estriangulo.Common.Math.isNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static estriangulo.Common.Constants.NO_HAY_DATOS_SUFICIENTES;

/**
 *
 * @author alumno
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label txtResult;
    @FXML
    private TextField textFieldUp;
    @FXML
    private TextField textFieldMiddle;
    @FXML
    private TextField textFieldDown;

    @FXML
    public void txtNumbers_OnKeyTyped(KeyEvent event) throws Exception {

        if (!event.getCharacter().matches("[0-9]")) {
            event.consume();
        }
    }

    @FXML
    public void txtNumbers_AreEmpty(KeyEvent event) throws Exception {

        if (isNumber(textFieldUp.getText())
                && isNumber(textFieldMiddle.getText())
                && isNumber(textFieldDown.getText())) {

            txtResult.setText(getTraingleTypeMessage(textFieldUp.getText(),
                    textFieldMiddle.getText(),
                    textFieldDown.getText()
            ));
        } else {
            txtResult.setText(NO_HAY_DATOS_SUFICIENTES);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
