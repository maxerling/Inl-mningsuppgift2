import java.util.ArrayList;

/**
 * Created by Max Erling
 * Date: 2020-10-10
 * Copyright: MIT
 * Class: Java20B
 */


public class Main {
    public static void main(String[] args) {
        cIdentifier c = new cIdentifier();
        ArrayList<Customer> customerInfo = c.createListFromFile();
        String input = c.readInput("Inmata fullständigt namn eller personnummer", null);
        String message = c.getMessage(input, customerInfo);
        System.out.println(message);
        c.addToPTFile(message, input, customerInfo);


    }
}
