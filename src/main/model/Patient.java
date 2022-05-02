package model;

import java.util.Scanner;

// Represents a patient having a patient id, patient name, and BMI
public class Patient {
    public static final int CONVERSIONFACTOR = 703;
    private static int nextAccountId = -1;

    private int id;
    private String name;
    private double bmi;
    private Scanner scanner;

    public Patient(String patientName) {
        id = nextAccountId++;
        name = patientName;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    // REQUIRES: height, weight in imperial metric
    // MODIFIES: this
    // EFFECTS: calculate the patient BMI and return a BMI value
    public double calculateBmi() {
        int bmi = 0;
        int height = 0;

        System.out.println("Please enter the patient weight (lbs):");
        int weight = scanner.nextInt();
        System.out.println("Please enter the patient height (ft) [1 of 2]:");
        int heightFt = scanner.nextInt();
        System.out.println("Please enter the patient height (in) [2 of 2]:");
        int heightIn = scanner.nextInt();
        scanner.nextLine(); // clears the line;
        // otherwise the carriage return is taken as the
        // next input and you get a blank "selected" loop
        height = (heightFt * 12) + heightIn;
        bmi = (weight * CONVERSIONFACTOR) / (height * height);
        return bmi;
        //stub
    }

    public double getBmi() {
        return bmi;
        //stub
    }
}
