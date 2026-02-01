package test;

import database.PatientDAO;

import java.util.List;

public class TestSearchByName {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        List<String> patients = dao.searchPatientByName("an");

        for (String p : patients) {
            System.out.println(p);
        }
    }
}

