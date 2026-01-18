package com.dilyara.hospital.menu;

import com.dilyara.hospital.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
    private Scanner scanner;
    private ArrayList<Person> people;

    public MenuManager() {
        scanner = new Scanner(System.in);
        people  = new ArrayList<>();
    }

    @Override
    public void displayMenu() {
        System.out.println("========================================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All People");
        System.out.println("4. View Patients Only");
        System.out.println("5. View Doctors Only");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> viewAll();
                case 4 -> viewPatients();
                case 5 -> viewDoctors();
                case 0 -> System.out.println("Exiting program. Goodbye! :)");
                default -> System.out.println("Invalid choice :( Try again.\n");
            }
        } while (choice != 0);

        scanner.close();
    }


    //Add Functions//
    private void addPatient() {
        try {System.out.print("Enter ID: ");
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

        System.out.println("Patient added successfully.\n");} catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void addDoctor() {
        try { System.out.print("Enter ID: ");
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

        System.out.println("Doctor added successfully.\n"); } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    //View functions//
    private void viewAll() {
        System.out.println("\n--- All People ---");
        for (Person p : people) {
            System.out.println(p.getDescription());
        }
        System.out.println();
    }

    private void viewPatients() {
        System.out.println("\n--- Patients Only ---");
        for (Person p : people) {
            if (p instanceof Patient) {
                System.out.println(p.getDescription());
            }
        }
        System.out.println();
    }

    private void viewDoctors() {
        System.out.println("\n--- Doctors Only ---");
        for (Person p : people) {
            if (p instanceof Doctor) {
                System.out.println(p.getDescription());
            }
        }
        System.out.println();
    }
}
