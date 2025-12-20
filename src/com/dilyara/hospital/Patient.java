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
        this.fullName = fullName;
        this.age = age;
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
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
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


