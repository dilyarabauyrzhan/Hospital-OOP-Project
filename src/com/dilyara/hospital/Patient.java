package com.dilyara.hospital;

public class Patient {
    // =========================
    // 1. Patient data
    // =========================
    private int patientId;
    private String fullName;
    private int age;
    private boolean insuranceActive;

    // =========================
    // 2. Constructor
    // =========================
    public Patient(int patientId, String fullName, int age, boolean insuranceActive) {
        this.patientId = patientId;
        setFullName(fullName);
        setAge(age);
        this.insuranceActive = insuranceActive;
    }

    // =========================
    // 3. Getters
    // =========================
    public int getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public boolean isInsuranceActive() {
        return insuranceActive;
    }

    // =========================
    // 4. Setters
    // =========================
    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            System.out.println("Warning! Name cannot be empty.");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Warning! Age cannot be negative. Setting age to 0.");
            this.age = 0;
        }
    }

    public void setInsuranceActive(boolean insuranceActive) {
        this.insuranceActive = insuranceActive;
    }

    // =========================
    // 5. Logic methods
    // =========================

    public boolean isMinor() {
        return age <= 17;
    }

    public boolean canReceiveFreeTreatment() {
        return insuranceActive || isMinor();
    }

    // =========================
    // 6. toString()
    // =========================
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + patientId +
                ", name='" + fullName + '\'' +
                ", age=" + age +
                ", insuranceActive=" + insuranceActive +
                '}';
    }

}


