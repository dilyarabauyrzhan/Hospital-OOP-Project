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
        setRating(rating);
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

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Warning! Rating must be between 0 and 5. Setting rating to 0.");
            this.rating = 0;
        }
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
