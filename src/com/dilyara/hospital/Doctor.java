package com.dilyara.hospital;

public class Doctor {
    // =========================
    // 1. Doctor data
    // =========================
    private int doctorId;
    private String name;
    private String specialization;
    private double rating;

    // =========================
    // 2. Constructor
    // =========================
    public Doctor(int doctorId, String name, String specialization, double rating) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
    }

    // =========================
    // 3. Getters
    // =========================
    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getRating() {
        return rating;
    }

    // =========================
    // 4. Setters
    // =========================
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // =========================
    // 5. Logic methods
    // =========================

    public boolean isTopRated() {
        return rating >= 4.5;
    }

    public void increaseRating(double value) {
        if (rating + value <= 5.0) {
            rating += value;
        } else {
            rating = 5.0;
        }
    }

    // =========================
    // 6. toString()
    // =========================
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", rating=" + rating +
                '}';
    }


}
