/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo.Common;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rafael
 */
public class MathTest {

    public MathTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isNumber method, of class Math.
     */
    @Test
    public void testIsNumber_Value_Number_Result_OK() {
        String number = "10";
        boolean expResult = true;
        boolean result = Math.isNumber(number);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNumber_Value_Null_Result_KO() {
        String number = null;
        boolean expResult = false;
        boolean result = Math.isNumber(number);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNumber_Value_String_Result_KO() {
        String number = "ab";
        boolean expResult = false;
        boolean result = Math.isNumber(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTraingleTypeMessage method, of class Math.
     */
    @Test
    public void testGetTraingleTypeMessage_Values_Equilatero_OK() {
        String textUp = "2";
        String textMiddle = "2";
        String textDown = "2";
        String expResult = Constants.TRIANGULO_EQUILATERO;
        String result = Math.getTraingleTypeMessage(textUp, textMiddle, textDown);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTraingleTypeMessage_Values_Escaleno_OK() {
        String textUp = "2";
        String textMiddle = "3";
        String textDown = "4";
        String expResult = Constants.TRIANGULO_ESCALENO;
        String result = Math.getTraingleTypeMessage(textUp, textMiddle, textDown);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTraingleTypeMessage_Values_Isosceles_OK() {
        String textUp = "3";
        String textMiddle = "2";
        String textDown = "2";
        String expResult = Constants.TRIANGULO_ISOSCELES;
        String result = Math.getTraingleTypeMessage(textUp, textMiddle, textDown);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTraingleTypeMessage_Values_No_Triangulo_OK() {
        String textUp = "1";
        String textMiddle = "2";
        String textDown = "3";
        String expResult = Constants.NOT_TRIANGLE;
        String result = Math.getTraingleTypeMessage(textUp, textMiddle, textDown);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTraingleTypeMessage_Values_LetterValues_KO() {
        String textUp = "a";
        String textMiddle = "b";
        String textDown = "c";
        String expResult = Constants.NOT_TRIANGLE;
        String result = Math.getTraingleTypeMessage(textUp, textMiddle, textDown);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTraingleTypeMessage_Values_NullValues_KO() {
        String textUp = null;
        String textMiddle = null;
        String textDown = null;
        String expResult = Constants.NOT_TRIANGLE;
        String result = Math.getTraingleTypeMessage(textUp, textMiddle, textDown);
        assertEquals(expResult, result);
    }

}
