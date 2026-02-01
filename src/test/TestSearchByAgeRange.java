package test;

import database.PatientDAO;
import java.util.List;

public class TestSearchByAgeRange {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        List<String> patients = dao.searchByAgeRange(20, 25);

        for (String p : patients) {
            System.out.println(p);
        }
    }
}

