package com.dilyara.hospital.menu;

import com.dilyara.hospital.Patient;
import database.PatientDAO;

import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner scanner;
    private final PatientDAO patientDAO;

    public MenuManager() {
        this.scanner = new Scanner(System.in);
        this.patientDAO = new PatientDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM ");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Update Patient");
        System.out.println("4. Delete Patient");
        System.out.println("5. Search Patient by Name");
        System.out.println("6. Search Patient by Age Range");
        System.out.println("7. Search Patient by Min Age");
        System.out.println("0. Exit");
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
                case 2 -> viewAllPatients();
                case 3 -> updatePatient();
                case 4 -> deletePatient();
                case 5 -> searchByName();
                case 6 -> searchByAgeRange();
                case 7 -> searchByMinAge();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // ===== MENU ACTIONS =====

    private void addPatient() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Has insurance? (true/false): ");
        boolean insurance = scanner.nextBoolean();

        Patient patient = new Patient(id, name, age, insurance);
        patientDAO.insertPatient(patient);
    }

    private void viewAllPatients() {
        patientDAO.getAllPatients(); 
    }

    private void updatePatient() {
        System.out.print("Enter patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New name: ");
        String name = scanner.nextLine();

        System.out.print("New age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New diagnosis: ");
        String diagnosis = scanner.nextLine();

        patientDAO.updatePatient(id, name, age, diagnosis);
    }

    private void deletePatient() {
        System.out.print("Enter patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            patientDAO.deletePatient(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<String> results = patientDAO.searchPatientByName(name);
        results.forEach(System.out::println);
    }

    private void searchByAgeRange() {
        System.out.print("Enter min age: ");
        int min = scanner.nextInt();
        System.out.print("Enter max age: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        List<String> results = patientDAO.searchByAgeRange(min, max);
        results.forEach(System.out::println);
    }

    private void searchByMinAge() {
        System.out.print("Enter minimum age: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        List<String> results = patientDAO.searchByMinAge(min);
        results.forEach(System.out::println);
    }
}
