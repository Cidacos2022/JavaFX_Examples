/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo;

import java.net.URL;
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
    private Label txtResult;
    @FXML
    private TextField textFieldUp;
    @FXML
    private TextField textFieldMiddle;
    @FXML
    private TextField textFieldDown;

    @FXML
    public void txtNumbers_OnKeyTyped(KeyEvent event) throws Exception {
        FXMLDocumentControllerHelper.txtNumbers_OnKeyTyped(event);
    }

    @FXML
    public void txtNumbers_AreEmpty(KeyEvent event) throws Exception {

        txtResult.setText(FXMLDocumentControllerHelper.txtNumbers_AreEmpty(textFieldUp.getText(),
                textFieldMiddle.getText(), textFieldDown.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
