package com.ak.entity;
public class Stats {
    private int totalStudents;
    private int totalFaculty;

    // Constructor
    public Stats(int totalStudents, int totalFaculty) {
        this.totalStudents = totalStudents;
        this.totalFaculty = totalFaculty;
    }

    // Getters and Setters
    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalFaculty() {
        return totalFaculty;
    }

    public void setTotalFaculty(int totalFaculty) {
        this.totalFaculty = totalFaculty;
    }
}
