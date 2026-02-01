package test;

import database.PatientDAO;

import java.util.Scanner;

public class TestDelete {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        System.out.print("Enter patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            boolean deleted = dao.deletePatient(id);
            System.out.println("Delete result: " + deleted);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}

