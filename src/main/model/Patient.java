package model;

import java.util.Scanner;

// Represents a patient having a patient id, patient name, and BMI
public class Patient {
    public static final int CONVERSIONFACTOR = 703;

    private String name;
    private double bmi;
    private int weight;
    private int height;
    private int heightFt;
    private int heightIn;



    public Patient(String name) {
        this.name = name;
        this.height = 0;
        this.weight = 0;
        this.bmi = 0;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeightFt(int heightFt) {
        this.heightFt = heightFt;
    }

    public void setHeightIn(int heightIn) {
        this.heightIn = heightIn;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getName() {
        return name;
    }

    public double getBmi() {
        return bmi;
    }

    // REQUIRES: height, weight in imperial metric
    // MODIFIES: this
    // EFFECTS: calculate the patient BMI and return a BMI value
    public double calculateBmi(int weight, int heightFt, int heightIn) {
        this.weight = weight;
        this.heightFt = heightFt;
        this.heightIn = heightIn;
        this.height = (heightFt * 12) + heightIn;
        this.bmi = (weight * CONVERSIONFACTOR) / (height * height);
        return bmi;
    }

    public String toString() {
        return (this.name + ", Weight: " + this.weight + ", Height: " + this.heightFt + "'" + this.heightIn + //
                "\"" + ", BMI: " + this.bmi);
    }

}
