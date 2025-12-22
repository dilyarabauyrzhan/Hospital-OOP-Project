package com.dilyara.hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    System.out.println("Welcome to the Hospital Management System!");
    System.out.println("This project is developed as part of an OOP course.");
    System.out.println("The system will manage patients, doctors, and departments.");
    System.out.println("Project domain: Hospital");
    System.out.println("Author: Dilyara Bauyrzhan");


    patients.add(new Patient(1, "Anna Kim", 17, false));
    patients.add(new Patient(2, "John S.", 22, true));

    doctors.add(new Doctor(101, "Dr. Lee", "Cardiology", 4.3));
    doctors.add(new Doctor(102, "Dr. Ivanov", "Surgery", 4.8));

    boolean running = true;

    while (running) {

        System.out.println("\n=== HOSPITAL MENU ===");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
                case 1:
                    addPatient();
                    break;

                case 2:
                    viewAllPatients();
                    break;

                case 3:
                    addDoctor();
                    break;

                case 4:
                    viewAllDoctors();
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

    }

    private static void addPatient() {
        System.out.print("Enter full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Has insurance (true/false): ");
        boolean insurance = scanner.nextBoolean();
        scanner.nextLine();

        Patient patient = new Patient(patients.size() + 1, name, age, insurance);
        patients.add(patient);

        System.out.println("Patient added successfully.");
    }

    private static void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n--- PATIENT LIST ---");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private static void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter rating (0–5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        Doctor doctor = new Doctor(doctors.size() + 1, name, specialization, rating);
        doctors.add(doctor);

        System.out.println("Doctor added successfully.");
    }

    private static void viewAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("\n--- DOCTOR LIST ---");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

}
