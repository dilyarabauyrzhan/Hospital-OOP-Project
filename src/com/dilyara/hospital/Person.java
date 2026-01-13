package com.dilyara.hospital;

public class Person {
    // =========================
    // Fields (are for all persons)
    // =========================
    protected int id;
    protected String name;
    protected int age;
    protected String role;

    // =========================
    // Constructor
    // =========================
    public Person(int id, String name, int age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    // =========================
    // Methods to be overridden
    // =========================
    public String getRole() {
        return role;
    }

    public String getDescription() {
        return "Person: " + name + ", age " + age;
    }

    // =========================
    // Common method
    // =========================
    public boolean isAdult() {
        return age >= 18;
    }

    // =========================
    // toString
    // =========================
    @Override
    public String toString() {
        return "[" + role + "] " + name + " (ID: " + id + ", Age: " + age + ")";
    }

}
