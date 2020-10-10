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


    //Exception
    //error

    @Test
    public final void createListFromFileTest() {
        ArrayList<Customer> customerInfo = c.createListFromFile("customers.txt");
        assertEquals("Alhambra Aromes", customerInfo.get(0).getName());
        assertEquals("Nahema Ninsson", customerInfo.get(customerInfo.size() - 1).getName());
        assertNotEquals("8104021234", customerInfo.get(0).getSsNumber());
    }

    @Test
    public final void readInputTest() {
        c.setTest(true);
        assertEquals("8104021234", c.readInput("Inmata namn eller personnummer", "8104021234"));
        assertNotEquals("8104021234", c.readInput("Inmata namn eller personnummer", "10"));

    }



}
