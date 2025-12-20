package com.dilyara.hospital;

public class Main {
    public static void main(String[] args) {

    System.out.println("Welcome to the Hospital Management System!");
    System.out.println("This project is developed as part of an OOP course.");
    System.out.println("The system will manage patients, doctors, and departments.");
    System.out.println("Project domain: Hospital");
    System.out.println("Author: Dilyara Bauyrzhan");

        // =========================
        // Hospital's objects
        // =========================
        Patient patient1 = new Patient(1, "Anna Kim", 17, false);
        Patient patient2 = new Patient(2, "John S.", 22, true);

        Doctor doctor1 = new Doctor(101, "Dr. Lee", "Cardiology", 4.3);
        Doctor doctor2 = new Doctor(102, "Dr. Ivanov", "Surgery", 4.8);

        Department department1 = new Department(201, "Cardiology", 5, 4);

        // =========================
        // Initial state
        // =========================
        System.out.println("--- PATIENTS ---");
        System.out.println(patient1);
        System.out.println(patient2);

        System.out.println("\n--- DOCTORS ---");
        System.out.println(doctor1);
        System.out.println(doctor2);

        System.out.println("\n--- DEPARTMENT ---");
        System.out.println(department1);

        // =========================
        // Logic demo
        // =========================
        System.out.println("\n--- PATIENT Logic ---");
        System.out.println("Is " + patient1.getFullName() + " a minor? " + patient1.isMinor());
        System.out.println("Can receive free treatment: " + patient1.canReceiveFreeTreatment());

        System.out.println("\n--- DOCTOR Logic ---");
        System.out.println("Is " + doctor2.getName() + " top rated? " + doctor2.isTopRated());
        doctor1.increaseRating(0.5);
        System.out.println("Updated rating for " + doctor1.getName() + ": " + doctor1.getRating());

        System.out.println("\n--- DEPARTMENT Logic ---");
        boolean admitted = department1.admitPatient();
        System.out.println("Admitting patient to department: " + admitted);
        System.out.println("Updated department state: " + department1);

        // =========================
        // End of program
        // =========================
        System.out.println("\n=== Program Complete! ===");
}

}
