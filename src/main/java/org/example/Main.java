package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to JAVA OOPS + DATABASE");
        // We have Employees, and they will have Levels of clearnce, L1, L2, L3 & L4
        // Use Postgres and OOPS
        // Once condluded move to spring
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you wish to do :\n" +
                    "0 . Exit\n" +
                    "1 . Add Employee\n" +
                    "2 . Check Employees\n" +
                    "3 . Remove Employee\n");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting..");
                    System.exit(0);
                case 1:
                    // Take input from user for name, clearance level and auto generate id
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
            }
        }
    }
}
