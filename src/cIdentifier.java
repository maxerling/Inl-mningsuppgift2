import java.io.*;
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
    private boolean test = false;

    public ArrayList<Customer> createListFromFile() {
        String file = "customers.txt";
        String row = null;
        String row2 = null;
        ArrayList<Customer> customerInfo = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((row = reader.readLine()) != null && (row2 = reader.readLine()) != null) {
                String[] info = row.split(",");
                String ssn = info[0];
                String name = info[1].trim();
                LocalDate date = LocalDate.parse(row2);
                Customer customer = new Customer(name, ssn, date);
                customerInfo.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil går ej att hitta");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fil går ej att läsa");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ospecifierat fel har uppstått");
            e.printStackTrace();
        }

        return customerInfo;
    }

    public String readInput(String prompt, String testInput) {
        Scanner sc;
        if (test) {
            sc = new Scanner(testInput);
        } else {
            sc = new Scanner(System.in);
        }


        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine();


                if (input.isEmpty()) {
                    System.out.println("Tom inmatning, försök igen!");

                } else {
                    return input;
                }


            } catch (Exception e) {
                System.out.println("Ospecifierat fel inträffade, försök igen!");
                e.printStackTrace();
                sc.nextLine();
            }
        }
    }

    public String getMessage(String input, ArrayList<Customer> list) {
        LocalDate oneYearAgo = LocalDate.now().minusMonths(12);

        for (Customer c : list) {
            if ((c.getName().equalsIgnoreCase(input) || c.getSsNumber().equalsIgnoreCase(input)) && c.getMembership().isAfter(oneYearAgo)) {
                return "Nuvarande medlem";
            } else if (c.getName().equalsIgnoreCase(input) || c.getSsNumber().equalsIgnoreCase(input)) {
                return "En före detta medlem";
            }
        }

        return "Aldrig varit medlem";
    }

    public void addToPTFile(String message, String input, ArrayList<Customer> list) {
        if (message.equalsIgnoreCase("Nuvarande medlem")) {
            for (Customer c : list) {
                if (input.equals(c.getName()) || input.equals(c.getSsNumber())) {
                    try {

                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("PTFile.txt", true)));
                        out.println(c.toString() + '\n' + LocalDate.now());
                        out.close();

                    } catch (IOException e) {
                        System.out.println("Fel uppstod vid skrivande till fil");
                    } catch (Exception e) {
                        System.out.println("Ospecifierat fel har uppstått");
                    }

                }
            }


        }

    }

    public void setTest(boolean test) {
        this.test = test;
    }


}
