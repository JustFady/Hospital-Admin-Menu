import java.io.*;
import java.util.*;

// Represents a patient in the hospital system
class Patient {
    private String id;
    private String name;
    private int age;
    private String ailment;
    private double bill;

    public Patient(String id, String name, int age, String ailment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.bill = 0.0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAilment() { return ailment; }
    public double getBill() { return bill; }

    public void updateBill(double amount) {
        this.bill += amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment + ", Bill: $" + bill;
    }
}