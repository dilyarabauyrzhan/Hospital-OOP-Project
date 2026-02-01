package test;

import com.dilyara.hospital.Patient;
import database.PatientDAO;

public class TestInsert {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        dao.insertPatient(new Patient(1, "Anna", 19, true));
        dao.insertPatient(new Patient(2, "Dana", 21, true));
        dao.insertPatient(new Patient(3, "Alex", 22, false));
        dao.insertPatient(new Patient(4, "Murat", 25, true));
        dao.insertPatient(new Patient(5, "Anel", 20, true));
    }
}

