import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Max Erling
 * Date: 2020-10-09
 * Copyright: MIT
 * Class: Java20B
 */
public class cIdentifier {


    public ArrayList<Customer> createListFromFile(String file) {

        String row = null;
        String row2 = null;
        ArrayList<Customer> customerInfo = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((row = reader.readLine()) != null && (row2 = reader.readLine()) != null) {
                String[] info = row.split(",");
                String ssn = info[0];
                String name = info[1].trim();
                LocalDate date = LocalDate.parse(row2);
                Customer customer = new Customer(name, ssn, date);
                customerInfo.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fil ej hittad!");
        }
        return customerInfo;
    }

    public String readInput(String prompt) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine();


            } catch ()
        }




    }
}
