import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Max Erling
 * Date: 2020-10-09
 * Copyright: MIT
 * Class: Java20B
 */
public class cIdentifier {
    private Scanner sc;
    private boolean test = false;

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

    public String readInput(String prompt, String testInput) {
        if (test) {
            sc = new Scanner(testInput);
        } else {
            sc = new Scanner(System.in);
        }

        while (true) {
            try {
                System.out.println(prompt);

                return sc.nextLine();

            } catch (NoSuchElementException e) {
                System.out.println("Indata saknas");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ospecifierat fel inträffade, försök igen!");
                e.printStackTrace();
                sc.nextLine();
            }
        }
    }

    public String getMessage(String input, ArrayList<Customer> list) {
        LocalDate oneYearAgo = LocalDate.now().plusMonths(-12);

        for (Customer c : list) {
            if ((c.getName().equalsIgnoreCase(input) || c.getSsNumber().equalsIgnoreCase(input)) && c.getMembership().isAfter(oneYearAgo)) {
                return "Nuvarande medlem";
            } else if (c.getName().equalsIgnoreCase(input) || c.getSsNumber().equalsIgnoreCase(input)) {
                return "En före detta medlem";
            }
        }

        return "Aldrig varit medlem";
    }

        public void setTest (boolean test){
            this.test = test;
        }


    }
