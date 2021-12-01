/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.game;

import dados.Dados;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author rafael
 */
public class gameController implements Initializable {

    @FXML
    private TextField fieldJugadorUno;
    @FXML
    private TextField fieldJugadorDos;
    @FXML
    private Pane pDown;
    @FXML
    private Pane pUp;
    @FXML
    private ImageView imgCenter;
    @FXML
    private Label lbTotalJugadorUno;
    @FXML
    private Label lbTotalJugadorDos;

    Image imageOne;
    Image imageTwo;
    Image imageThree;
    Image imageFour;
    Image imageFive;
    Image imageSix;
    Image imageBase;

    private int numberJugadorUno;
    private int numberJugadorDos;
    private BettingResult resultJugadorOne;
    private BettingResult resultJugadorTwo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        resultJugadorOne = new BettingResult();
        resultJugadorTwo = new BettingResult();

        imageBase = new LocatedImage(Dados.class.getResource("resources/dados.png").toString());
        imageOne = new LocatedImage(Dados.class.getResource("resources/1.png").toString());
        imageTwo = new LocatedImage(Dados.class.getResource("resources/2.png").toString());
        imageThree = new LocatedImage(Dados.class.getResource("resources/3.jpg").toString());
        imageFour = new LocatedImage(Dados.class.getResource("resources/4.jpeg").toString());
        imageFive = new LocatedImage(Dados.class.getResource("resources/5.png").toString());
        imageSix = new LocatedImage(Dados.class.getResource("resources/6.png").toString());

        EventHandler<javafx.scene.input.MouseEvent> eventHandlerBox = (MouseEvent e) -> {
            if (textFieldIsEmpty(fieldJugadorUno) || textFieldIsEmpty(fieldJugadorDos)) {
                return;
            }

            if ((getFieldValueJugadorTwo() < 20 && getMaxFichasJugadorDos() > 20) || getFieldValueJugadorTwo() > getMaxFichasJugadorDos()) {
                return;
            }

            if ((getFieldValueJugadorOne() < 20 && getMaxFichasJugadorOne() > 20) || getFieldValueJugadorOne() > getMaxFichasJugadorOne()) {
                return;
            }

            if (CurrentGame.getInstance().isFinished()) {
                pUp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                imgCenter.setImage(imageBase);
                updateLabel();
                CurrentGame.getInstance().restart();
                fieldJugadorUno.setDisable(false);
                fieldJugadorDos.setDisable(false);
                checkIsFinished();
                return;
            }

            Random rand = new Random();
            int randomNum = rand.nextInt((6 - 1) + 1) + 1;
            Image imagen = getImage(randomNum);
            imgCenter.setImage(imagen);

            if (!CurrentGame.getInstance().isBeingPlayed()) {
                CurrentGame.getInstance().start();
                pDown.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                numberJugadorUno = randomNum;
                fieldJugadorUno.setDisable(true);
                fieldJugadorDos.setDisable(true);
                return;
            }

            if (CurrentGame.getInstance().isSecondTurn()) {
                pDown.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                pUp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                CurrentGame.getInstance().finish();
                numberJugadorDos = randomNum;
            }

        };

        imgCenter.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerBox);

    }

    private Image getImage(int number) {
        switch (number) {
            case 1:
                return imageOne;
            case 2:
                return imageTwo;
            case 3:
                return imageThree;
            case 4:
                return imageFour;
            case 5:
                return imageFive;
            case 6:
                return imageSix;
        }
        return null;
    }

    private Boolean textFieldIsEmpty(TextField textField) {
        return textField.getText() == null || textField.getText().isEmpty() || textField.getText().trim().isEmpty();
    }

    @FXML
    public void txtFieldNumber_OnKeyTyped(KeyEvent event) {
        if (!event.getCharacter().matches("[0-9]")) {
            event.consume();
        }
    }

    private void updateLabel() {
        if (numberJugadorUno > numberJugadorDos) {
            resultJugadorOne.recordBet(getFieldValueJugadorOne());
            resultJugadorTwo.recordBet(-getFieldValueJugadorTwo());
            lbTotalJugadorUno.setText("Total: " + (getMaxFichasJugadorOne() + getFieldValueJugadorOne()));
            lbTotalJugadorDos.setText("Total: " + (getMaxFichasJugadorDos() - getFieldValueJugadorTwo()));
        }

        if (numberJugadorUno < numberJugadorDos) {
            resultJugadorOne.recordBet(-getFieldValueJugadorOne());
            resultJugadorTwo.recordBet(getFieldValueJugadorTwo());
            lbTotalJugadorUno.setText("Total: " + (getMaxFichasJugadorOne() - getFieldValueJugadorOne()));
            lbTotalJugadorDos.setText("Total: " + (getMaxFichasJugadorDos() + getFieldValueJugadorTwo()));
        }

    }

    public int getMaxFichasJugadorOne() {
        String[] splitedLabelJugadorOne = lbTotalJugadorUno.getText().split(" ");
        return Integer.parseInt(splitedLabelJugadorOne[splitedLabelJugadorOne.length - 1]);
    }

    public int getMaxFichasJugadorDos() {
        String[] splitedLabelJugadorTwo = lbTotalJugadorDos.getText().split(" ");
        return Integer.parseInt(splitedLabelJugadorTwo[splitedLabelJugadorTwo.length - 1]);
    }

    public int getFieldValueJugadorOne() {
        return Integer.parseInt(fieldJugadorUno.getText());
    }

    public int getFieldValueJugadorTwo() {
        return Integer.parseInt(fieldJugadorDos.getText());
    }

    private void checkIsFinished() {
        if (getMaxFichasJugadorOne() == 0) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = (Stage) fieldJugadorUno.getScene().getWindow();
            dialog.initOwner(primaryStage);
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("The winner is Jugador Two"));
            dialogVbox.getChildren().add(new Text("Max earn bet: " + resultJugadorTwo.getMaxEarnBet()));
            dialogVbox.getChildren().add(new Text("Max lost bet: " + resultJugadorTwo.getMaxLostBet()));
            dialogVbox.getChildren().add(new Text("Sum earn bet: " + resultJugadorTwo.getSumEarnBet()));
            dialogVbox.getChildren().add(new Text("Sum lost bet: " + resultJugadorTwo.getSumLostBet()));
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
            return;
        }

        if (getMaxFichasJugadorDos() == 0) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            Stage primaryStage = (Stage) fieldJugadorUno.getScene().getWindow();
            dialog.initOwner(primaryStage);
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("The winner is Jugador One"));
            dialogVbox.getChildren().add(new Text("Max earn bet: " + resultJugadorOne.getMaxEarnBet()));
            dialogVbox.getChildren().add(new Text("Max lost bet: " + resultJugadorOne.getMaxLostBet()));
            dialogVbox.getChildren().add(new Text("Sum earn bet: " + resultJugadorOne.getSumEarnBet()));
            dialogVbox.getChildren().add(new Text("Sum lost bet: " + resultJugadorOne.getSumLostBet()));
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
        }
    }

}
