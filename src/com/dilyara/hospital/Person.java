package com.dilyara.hospital;

public abstract class Person {
    // =========================
    // Fields (are for all persons)
    // =========================
    protected int id;
    protected String name;
    protected int age;

    // =========================
    // Constructor
    // =========================
    public Person(int id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    // =========================
    // Abstract method
    // =========================
    public abstract String getRole();

    // =========================
    // Method to be overridden
    // =========================
    public String getDescription() {
        return "Person: " + name + ", age " + age;
    }

    // =========================
    // Setters
    // =========================
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        this.age = age;
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
        return "[" + getRole() + "] " + name + " (ID: " + id + ", Age: " + age + ")";
    }

}
