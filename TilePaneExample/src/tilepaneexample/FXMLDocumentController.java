/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilepaneexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

/**
 *
 * @author rjalamanac
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtField;
    @FXML
    private TilePane tlPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void txtField_OnKeyTyped(KeyEvent event) throws Exception {

        if (!event.getCharacter().matches("[0-9]")) {
            event.consume();
        }
    }

    @FXML
    public void txtField_OnKeyReleased(KeyEvent event) throws Exception {
        /*
        if (txtField.getText().matches("[0-9]+")) {
            int numero = Integer.parseInt(txtField.getText());
            for (int i = 1; i <= numero; i++) {
                Text texto = new Text();
                texto.setText("Texto " + i);
                tlPane.getChildren().add(texto);
            }
        }

        if (txtField.getText().matches("[0-9]+")) {
            int numero = Integer.parseInt(txtField.getText());
            for (int i = 1; i <= numero; i++) {
                ImageView imageView = new ImageView();
                Image imagE = new Image(TilePaneExample.class.getResource("imagenes/meme.jpg").toString());
                imageView.setImage(imagE);
                imageView.setFitHeight(60);
                imageView.setFitWidth(60);
                tlPane.getChildren().add(imageView);
            }
        }
         */
        tlPane.getChildren().clear();
        if (txtField.getText().matches("[0-9]+")) {
            int numero = Integer.parseInt(txtField.getText());
            for (int i = 1; i <= numero; i++) {
                Text texto = new Text();
                texto.setText("Texto " + i);
                ImageView imageView = new ImageView();
                Image imagE = new Image(TilePaneExample.class.getResource("imagenes/meme.jpg").toString());
                imageView.setImage(imagE);
                imageView.setFitHeight(60);
                imageView.setFitWidth(60);
                BorderPane borde = new BorderPane();
                borde.setCenter(imageView);
                borde.setBottom(texto);
                tlPane.getChildren().addAll(borde);
            }
        }
    }

}
