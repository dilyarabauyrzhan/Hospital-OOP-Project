package com.dilyara.hospital;

public class Doctor extends Person {
    // =========================
    // 1. Doctor data
    // =========================
    private String specialization;
    private double rating;

    // =========================
    // 2. Constructor
    // =========================
    public Doctor(int id, String name, int age, String specialization, double rating) {
        super(id, name, age);
        this.specialization = specialization;
        this.rating = rating;
    }


    // =========================
    // 3. Getters
    // =========================
    public String getSpecialization() {
        return specialization;
    }

    public double getRating() {
        return rating;
    }

    // =========================
    // 4. Setters
    // =========================

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.rating = rating;
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
    // 6.  Overridden methods
    // =========================
    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String getDescription() {
        return "Doctor: " + name + ", age " + age +
                ", specialization: " + specialization +
                ", rating: " + rating;
    }

}
