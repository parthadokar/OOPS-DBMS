package org.example;

public class Employee {
    //  Employee class (OOP)
    private int id;
    private String name;
    private String clearanceLevel; // L1, L2m L3, L4

    public Employee (int id, String name, String clearanceLevel) {
        this.id = id;
        this.name = name;
        this.clearanceLevel = clearanceLevel;
    }

    // Getters
    public int getId() { return id; }
    public String getEmployeeName() { return name; }
    public String getEmployeeLevel() { return clearanceLevel; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Clearance: " + clearanceLevel;
    }
}
