/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo;

import estriangulo.Common.Constants;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author rjalamanac
 */
public class FXMLDocumentControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(EsTriangulo.class.getResource("FXMLDocument.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void integrationTest_Equilatero_OK() throws InterruptedException {
        clickOn();
        Label label = lookup("#txtResult").query();
        assertEquals(label.getText(), Constants.TRIANGULO_EQUILATERO);
    }

    private void clickOn(String valueUp, String valueMiddle, String valueDown) {
        clickOn("#textFieldUp").write(valueUp).press(KeyCode.ENTER);
        clickOn("#textFieldMiddle").write(valueMiddle).press(KeyCode.ENTER);
        clickOn("#textFieldDown").write(valueDown).press(KeyCode.ENTER);
    }

    @Test
    public void integrationTest_LetterValues_KO() throws InterruptedException {
        clickOn();
        Label label = lookup("#txtResult").query();
        assertEquals(label.getText(), Constants.TRIANGULO_EQUILATERO);
    }

    @Test
    public void integrationTest__Isosceles_OK() throws InterruptedException {
        clickOn("#textFieldUp").write("2").press(KeyCode.ENTER);
        clickOn("#textFieldMiddle").write("2").press(KeyCode.ENTER);
        clickOn("#textFieldDown").write("3").press(KeyCode.ENTER);
        Label label = lookup("#txtResult").query();
        assertEquals(label.getText(), Constants.TRIANGULO_ISOSCELES);
    }

}
