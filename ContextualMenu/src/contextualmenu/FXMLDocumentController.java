/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contextualmenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

/**
 *
 * @author rafael
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TilePane tilePane;

    @FXML
    private Pane tPain;

    private static int contador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contador = 0;
        ImageView imgView = new ImageView();
        Image image = new Image(getClass().getResource(getImgeURL(contador)).toString());
        imgView.setImage(image);
        AddSetOnContextMenu(imgView);
        imgView.setFitHeight(60);
        imgView.setFitWidth(60);
        tilePane.getChildren().add(imgView);

        tPain.setOnContextMenuRequested(e -> {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem deleteALL = new MenuItem("DeleteAll");
            MenuItem create = new MenuItem("Create");
            create.setOnAction((ActionEvent event) -> {
                ImageView newImgView = new ImageView();
                contador++;
                Image newImage = new Image(getClass().getResource(getImgeURL(contador)).toString());
                newImgView.setImage(newImage);
                AddSetOnContextMenu(newImgView);
                newImgView.setFitHeight(60);
                newImgView.setFitWidth(60);
                tilePane.getChildren().addAll(newImgView);

            });
            deleteALL.setOnAction((ActionEvent event) -> {
                tilePane.getChildren().clear();
            });
            contextMenu.getItems().addAll(deleteALL, create);
            contextMenu.show(tPain, e.getScreenX(), e.getScreenY());
        });
    }

    private void AddSetOnContextMenu(ImageView imgView) {
        imgView.setOnContextMenuRequested((ContextMenuEvent e)
                -> {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem delete = new MenuItem("Delete");

            MenuItem clone = new MenuItem("Clone");

            clone.setOnAction((ActionEvent event) -> {
                ImageView newImgView = new ImageView();
                Image newImage = new Image(getClass().getResource(getImgeURL(contador)).toString());
                newImgView.setImage(newImage);
                AddSetOnContextMenu(newImgView);
                newImgView.setFitHeight(60);
                newImgView.setFitWidth(60);
                tilePane.getChildren().addAll(newImgView);

            });
            delete.setOnAction((ActionEvent event) -> {
                imgView.setManaged(false);
                tilePane.getChildren().remove(imgView);

            });

            contextMenu.getItems().addAll(delete, clone);
            contextMenu.show(imgView, e.getScreenX(), e.getScreenY());
            e.consume();
        });
    }

    private String getImgeURL(Integer contador) {
        return contador % 2 == 0 ? "resources/hagrod.jpg" : "resources/yoda.jpeg";
    }

}
