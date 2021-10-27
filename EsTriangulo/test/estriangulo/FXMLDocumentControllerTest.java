/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo;

import estriangulo.Common.Constants;
import estriangulo.Common.JavaFXThreadingRule;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author rafael
 */
@RunWith(MockitoJUnitRunner.class)
public class FXMLDocumentControllerTest {

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Mock
    private Label txtResult;
    @Mock
    private TextField textFieldUp;
    @Mock
    private TextField textFieldMiddle;
    @Mock
    private TextField textFieldDown;

    @InjectMocks
    private FXMLDocumentController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }

    public FXMLDocumentControllerTest() {

    }

    /**
     * Test of txtNumbers_OnKeyTyped method, of class FXMLDocumentController.
     */
    @Test
    public void testTxtNumbers_OnKeyTyped() throws Exception {
        txtResult = Mockito.mock(Label.class);
        textFieldUp = Mockito.mock(TextField.class);
        textFieldMiddle = Mockito.mock(TextField.class);
        textFieldDown = Mockito.mock(TextField.class);
        when(textFieldUp.getText()).thenReturn("1");
        when(textFieldMiddle.getText()).thenReturn("1");
        when(textFieldDown.getText()).thenReturn("1");
        controller.txtNumbers_AreEmpty(null);
        assertEquals(txtResult.getText(), Constants.TRIANGULO_EQUILATERO);
    }

}
