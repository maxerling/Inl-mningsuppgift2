import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Max Erling
 * Date: 2020-10-09
 * Copyright: MIT
 * Class: Java20B
 */
public class cIdentifierTest {
    cIdentifier c = new cIdentifier();



    @Test
    public final void createListFromFileTest() {
        ArrayList<Customer> customerInfo = c.createListFromFile();
        assertEquals("Alhambra Aromes", customerInfo.get(0).getName());
        assertEquals("Nahema Ninsson", customerInfo.get(customerInfo.size() - 1).getName());
        assertNotEquals("8104021234", customerInfo.get(0).getSsNumber());
    }

    @Test
    public final void readInputTest() {
        c.setTest(true);
        assertEquals("8104021234", c.readInput("Inmata fullständigt namn eller personnummer", "8104021234"));
        assertNotEquals("8104021234", c.readInput("Inmata fullständigt namn eller personnummer", "10"));

    }

    @Test
    public final void getMessageTest() {
        c.setTest(true);
        ArrayList<Customer> customerInfo = c.createListFromFile();
        String input = "Egg";
        assertEquals("Aldrig varit medlem", c.getMessage(input, customerInfo));

        input = "Alhambra Aromes";
        assertEquals("En före detta medlem", c.getMessage(input, customerInfo));

        input = "8104021234";
        assertEquals("En före detta medlem", c.getMessage(input, customerInfo));


        input = c.readInput("Inmata fullständigt namn eller personnummer", "Mitsuko Mayotte");
        assertEquals("En före detta medlem", c.getMessage(input, customerInfo));

        input = "7512166544";
        assertEquals("Nuvarande medlem", c.getMessage(input, customerInfo));

        input = "Ida Idylle";
        assertNotEquals("Nuvarande medlem", c.getMessage(input, customerInfo));

        input = "Ida Idylle";
        assertNotEquals("Aldrig varit medlem", c.getMessage(input, customerInfo));
    }


}
