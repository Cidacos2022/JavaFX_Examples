/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularionumerosprimos.Common;

/**
 *
 * @author rafael
 */
public class Math {

    public static Boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static Boolean isPrime(String sNumber) {
        try {
            int number = Integer.parseInt(sNumber);

            if (number == 0) {
                return false;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
