package com.dilyara.hospital;

public class Patient extends Person {
    // =========================
    // 1. Patient data
    // =========================
    private boolean insuranceActive;

    // =========================
    // 2. Constructor
    // =========================
    public Patient(int id, String name, int age, boolean insuranceActive) {
        super(id, name, age, "Patient");
        this.insuranceActive = insuranceActive;
    }

    // =========================
    // 3. Getters
    // =========================
    public boolean isInsuranceActive() {
        return insuranceActive;
    }

    // =========================
    // 4. Setters
    // =========================
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
    // 6. Overridden methods
    // =========================
    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String getDescription() {
        return "Patient: " + name + ", age " + age +
                ", insurance active: " + insuranceActive;
    }


}


