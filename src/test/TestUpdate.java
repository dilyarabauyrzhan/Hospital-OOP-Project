package test;

import database.PatientDAO;

public class TestUpdate {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        boolean updated = dao.updatePatient(
                1,
                "Updated Name",
                25,
                "Updated diagnosis"
        );

        System.out.println("Update result: " + updated);
    }
}
