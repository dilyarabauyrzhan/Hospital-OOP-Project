package database;

import com.dilyara.hospital.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PatientDAO {

    public void insertPatient(Patient patient) {

        String sql = "INSERT INTO patient (name, age, diagnosis, admission_date) " +
                "VALUES (?, ?, ?, CURRENT_DATE)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, "General checkup");

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Patient inserted successfully");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Insert failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public void getAllPatients() {

        String sql = "SELECT * FROM patient";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            var resultSet = statement.executeQuery();

            System.out.println("\n--- ALL PATIENTS FROM DATABASE ---");

            while (resultSet.next()) {
                int id = resultSet.getInt("patient_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String diagnosis = resultSet.getString("diagnosis");
                var date = resultSet.getDate("admission_date");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age +
                                ", Diagnosis: " + diagnosis +
                                ", Date: " + date
                );
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean updatePatient(int patientId, String newName, int newAge, String newDiagnosis) {

        String sql = "UPDATE patient " +
                "SET name = ?, age = ?, diagnosis = ? " +
                "WHERE patient_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, newName);
            statement.setInt(2, newAge);
            statement.setString(3, newDiagnosis);
            statement.setInt(4, patientId); // WHERE condition

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Patient updated successfully (ID: " + patientId + ")");
                return true;
            } else {
                System.out.println("⚠️ No patient found with ID: " + patientId);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("❌ Update failed");
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean deletePatient(int patientId) {

        String sql = "DELETE FROM patient WHERE patient_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("✅ Patient deleted (ID: " + patientId + ")");
                return true;
            } else {
                System.out.println("⚠️ No patient found with ID: " + patientId);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete failed");
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public List<String> searchPatientByName(String name) {

        List<String> results = new ArrayList<>();

        String sql = "SELECT * FROM patient WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return results;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%"); // wildcard

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("patient_id");
                String patientName = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String diagnosis = resultSet.getString("diagnosis");

                String info = "ID: " + id +
                        ", Name: " + patientName +
                        ", Age: " + age +
                        ", Diagnosis: " + diagnosis;

                results.add(info);
            }

            resultSet.close();
            statement.close();

            System.out.println("🔍 Found " + results.size() + " patients");

        } catch (SQLException e) {
            System.out.println("❌ Search failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return results;
    }

    public List<String> searchByAgeRange(int minAge, int maxAge) {

        List<String> results = new ArrayList<>();

        String sql = "SELECT * FROM patient " +
                "WHERE age BETWEEN ? AND ? " +
                "ORDER BY age";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return results;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("patient_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String diagnosis = resultSet.getString("diagnosis");

                String info = "ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Diagnosis: " + diagnosis;

                results.add(info);
            }

            resultSet.close();
            statement.close();

            System.out.println("🔍 Found " + results.size() + " patients");

        } catch (SQLException e) {
            System.out.println("❌ Search by age range failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return results;
    }

    public List<String> searchByMinAge(int minAge) {

        List<String> results = new ArrayList<>();

        String sql = "SELECT * FROM patient " +
                "WHERE age >= ? " +
                "ORDER BY age";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return results;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("patient_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String diagnosis = resultSet.getString("diagnosis");

                String info = "ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Diagnosis: " + diagnosis;

                results.add(info);
            }

            resultSet.close();
            statement.close();

            System.out.println("🔍 Found " + results.size() + " patients");

        } catch (SQLException e) {
            System.out.println("❌ Search by min age failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return results;
    }


}



