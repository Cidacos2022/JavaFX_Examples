/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rafael
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public Text txtUser;
    @FXML
    public Text txtOs;
    @FXML
    public Text txtDate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SimpleDateFormat format = new SimpleDateFormat("dd-mmm-yyyy HH:MM:SS.ss");
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.add(Calendar.DAY_OF_MONTH, 13);
        txtUser.setText(txtUser.getText() + System.getProperty("user.name"));
        txtOs.setText(txtOs.getText() + System.getProperty("os.name"));
        txtDate.setText(txtDate.getText() + format.format(instance.getTime()));
    }

    @FXML
    public void mouseClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) txtUser.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(Dados.class.getResource("game/game.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
