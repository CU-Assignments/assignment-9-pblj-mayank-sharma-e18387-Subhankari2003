package hard;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    private int id;
    private String name;
    private double balance;

    public Account() {}

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters and Setters
}
