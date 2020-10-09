import java.time.LocalDate;

/**
 * Created by Max Erling
 * Date: 2020-10-09
 * Copyright: MIT
 * Class: Java20B
 */
public class Customer {
    private String name;
    private String ssNumber;
    private LocalDate membership;

    public Customer(String name, String ssNumber, LocalDate membership) {
        this.name = name;
        this.ssNumber =  ssNumber;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }


    public LocalDate getMembership() {
        return membership;
    }

    public String getSsNumber() {
        return ssNumber;
    }
}
