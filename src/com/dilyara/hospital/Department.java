package com.dilyara.hospital;

public class Department {
    // =========================
    // 1. Department data
    // =========================
    private int departmentId;
    private String name;
    private int capacity;
    private int currentPatients;

    // =========================
    // 2. Constructor
    // =========================
    public Department(int departmentId, String name, int capacity, int currentPatients) {
        this.departmentId = departmentId;
        this.name = name;
        this.capacity = capacity;
        this.currentPatients = currentPatients;
    }

    // =========================
    // 3. Getters
    // =========================
    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentPatients() {
        return currentPatients;
    }

    // =========================
    // 4. Setters
    // =========================
    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // =========================
    // 5. Business logic methods
    // =========================

    public boolean hasAvailableBeds() {
        return currentPatients < capacity;
    }

    public boolean admitPatient() {
        if (hasAvailableBeds()) {
            currentPatients++;
            return true;
        }
        return false;
    }

    // =========================
    // 6. toString()
    // =========================
    @Override
    public String toString() {
        return "Department{" +
                "id=" + departmentId +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", currentPatients=" + currentPatients +
                '}';
    }

}
