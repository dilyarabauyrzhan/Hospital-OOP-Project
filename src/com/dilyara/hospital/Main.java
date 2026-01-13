package com.dilyara.hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Hospital Management System!");
        System.out.println("This project is developed as part of an OOP course.");
        System.out.println("The system will manage patients, doctors, and departments.");
        System.out.println("Project domain: Hospital");
        System.out.println("Author: Dilyara Bauyrzhan");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        int choice;

        do {
            System.out.println("========================================");
            System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Person (General)");
            System.out.println("2. Add Patient");
            System.out.println("3. Add Doctor");
            System.out.println("4. View All People (Polymorphic)");
            System.out.println("5. Demonstrate Polymorphism");
            System.out.println("6. View Patients Only");
            System.out.println("7. View Doctors Only");
            System.out.println("0. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // -------------------------
                // 1. Add Person
                // -------------------------
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    Person person = new Person(id, name, age, "Person");
                    people.add(person);

                    System.out.println("Person added successfully.\n");
                }

                // -------------------------
                // 2. Add Patient
                // -------------------------
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    System.out.print("Has insurance? (true/false): ");
                    boolean insurance = scanner.nextBoolean();

                    Patient patient = new Patient(id, name, age, insurance);
                    people.add(patient);

                    System.out.println("Patient added successfully.\n");
                }

                // -------------------------
                // 3. Add Doctor
                // -------------------------
                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();

                    System.out.print("Enter rating: ");
                    double rating = scanner.nextDouble();

                    Doctor doctor = new Doctor(id, name, age, specialization, rating);
                    people.add(doctor);

                    System.out.println("Doctor added successfully.\n");
                }

                // -------------------------
                // 4. View All (Polymorphic)
                // -------------------------
                case 4 -> {
                    System.out.println("\n--- All People (Polymorphic) ---");
                    for (Person p : people) {
                        System.out.println(p.getDescription());
                    }
                    System.out.println();
                }

                // -------------------------
                // 5. Demonstrate Polymorphism
                // -------------------------
                case 5 -> {
                    System.out.println("\n--- Polymorphism Demo ---");
                    for (Person p : people) {
                        System.out.println(p.getDescription());
                    }
                    System.out.println();
                }

                // -------------------------
                // 6. View Patients Only
                // -------------------------
                case 6 -> {
                    System.out.println("\n--- Patients Only ---");
                    for (Person p : people) {
                        if (p instanceof Patient) {
                            System.out.println(p.getDescription());
                        }
                    }
                    System.out.println();
                }

                // -------------------------
                // 7. View Doctors Only
                // -------------------------
                case 7 -> {
                    System.out.println("\n--- Doctors Only ---");
                    for (Person p : people) {
                        if (p instanceof Doctor) {
                            System.out.println(p.getDescription());
                        }
                    }
                    System.out.println();
                }

                case 0 -> System.out.println("Exiting program. Goodbye! :)");

                default -> System.out.println("Invalid choice :( Try again.\n");
            }

        } while (choice != 0);

        scanner.close();

    }
}
