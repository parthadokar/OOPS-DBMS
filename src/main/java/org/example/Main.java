package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();
        System.out.println("Hello, Welcome to JAVA OOPS + DATABASE");
        // We have Employees, and they will have Levels of clearnce, L1, L2, L3 & L4
        // Use Postgres and OOPS
        // Once condluded move to spring
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Choose what you wish to do :
                    0 . Exit
                    1 . Add Employee
                    2 . Check Employees
                    3 . Remove Employee
                    """);
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting..");
                    System.exit(0);
                case 1:
                    // Take input from user for name, clearance level and auto generate id
                    System.out.println("Enter the Employee you want to add.");
                    String name = sc.next();
                    System.out.println("Enter Clearance Level (L1, L2, L3, L4)");
                    String level = sc.next();
                    Employee emp = new Employee(0, name, level);
                    EmployeeDAO.addEmployee(emp);
                    break;
                case 2:
                    List<Employee> employees = EmployeeDAO.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No employee found.");
                    } else {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter Employee ID to remove.");
                    int removeId  = sc.nextInt();
                    EmployeeDAO.removeEmployee(removeId);
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
            }
        }
    }
}
