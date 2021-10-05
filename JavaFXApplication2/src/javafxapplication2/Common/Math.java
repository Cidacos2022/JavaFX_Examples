/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Common;

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

    public static int nextPrime(String sNumber) {
        try {
            int number = Integer.parseInt(sNumber);
            int result = Integer.MIN_VALUE;
            do {
                number++;
                if (isPrime(String.valueOf(number))) {
                    result = number;
                }

            } while (result == Integer.MIN_VALUE);
            return result;

        } catch (NumberFormatException ex) {
            return 1;
        }
    }
}
