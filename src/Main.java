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
        ArrayList<Customer> customerInfo = c.createListFromFile("customers.txt");
        String input = c.readInput("Inmata namn eller personnummer", null);
        //String message = c.getMessage(input,customerInfo);
        //c.printMessage(message);



        //create new PT file
        //c.addToPTFile(message,customerInfo,input)




        /*
       if message.equals("Nuvarande medlem")
       customerInfo.contains(input)
       customerinfo.getname
       customerinfo.getssn
       add(todaysdate)

       addtofile
        */


    }
}
