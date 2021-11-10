/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo;

import estriangulo.Common.Constants;
import static estriangulo.Common.Math.getTraingleTypeMessage;
import static estriangulo.Common.Math.isNumber;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author rjalamanac
 */
public class FXMLDocumentControllerHelper {

    public static void txtNumbers_OnKeyTyped(KeyEvent event) {
        if (!event.getCharacter().matches("[0-9]")) {
            event.consume();
        }
    }

    public static String txtNumbers_AreEmpty(String textFieldUp, String textFieldMiddle, String textFieldDown) {
        if (isNumber(textFieldUp)
                && isNumber(textFieldMiddle)
                && isNumber(textFieldDown)) {

            return getTraingleTypeMessage(textFieldUp,
                    textFieldMiddle,
                    textFieldDown);
        } else {
            return Constants.NO_HAY_DATOS_SUFICIENTES;
        }
    }
}
