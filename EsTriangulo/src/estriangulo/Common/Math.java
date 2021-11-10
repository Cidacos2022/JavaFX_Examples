/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo.Common;

/**
 *
 * @author rafael
 */
public class Math {

    public static boolean isNumber(String number) {
        if (number == null) {
            return false;
        }
        return number.matches(Constants.NUMBER_REGEX);
    }

    public static String getTraingleTypeMessage(String textUp, String textMiddle, String textDown) {

        if (textUp == null || textMiddle == null || textDown == null) {
            return Constants.NOT_TRIANGLE;
        }

        try {
            int numberUp = Integer.parseInt(textUp);
            int numberMiddle = Integer.parseInt(textMiddle);
            int numberDown = Integer.parseInt(textDown);

            if (numberUp == numberMiddle && numberUp == numberDown) {
                return Constants.TRIANGULO_EQUILATERO;
            }

            if (numberUp >= numberMiddle + numberDown || numberMiddle >= numberUp + numberDown || numberDown >= numberUp + numberMiddle) {
                return Constants.NOT_TRIANGLE;
            }

            if (numberUp == numberMiddle || numberUp == numberDown || numberMiddle == numberDown) {
                return Constants.TRIANGULO_ISOSCELES;
            }
            return Constants.TRIANGULO_ESCALENO;
        } catch (NumberFormatException ex) {
            return Constants.NOT_TRIANGLE;
        }
    }
}
