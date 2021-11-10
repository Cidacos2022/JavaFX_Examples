/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estriangulo;

import estriangulo.Common.Constants;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author rjalamanac
 */
public class FXMLDocumentControllerHelperTest {

    @Test
    public void txtNumbers_OnKeyTyped() {

    }

    @Test
    public void txtNumbers_AreEmpty() {

        assertEquals(FXMLDocumentControllerHelper.txtNumbers_AreEmpty("1", "1", "1"), Constants.TRIANGULO_EQUILATERO
        );
    }
}
