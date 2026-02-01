package test;

import database.PatientDAO;
import java.util.List;

public class TestSearchByMinAge {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        List<String> patients = dao.searchByMinAge(22);

        for (String p : patients) {
            System.out.println(p);
        }
    }
}

