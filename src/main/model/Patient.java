package model;

import org.json.JSONObject;
import persistence.Writable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// Represents a patient having a patient name and a BMI score
public class Patient implements Writable {
    public static final double CONVERSION_FACTOR = 703.0;

    private String name;
    private double bmi;
    private int weight;
    private int height;
    private int heightFt;
    private int heightIn;
    private double finalBmi;


    // EFFECTS: constructs a new patient with given name; initializes the weight, height, and bmi to 0
    public Patient(String name) {
        this.name = name;
        this.weight = 0;
        this.height = 0;
        this.bmi = 0;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // REQUIRES: height, weight in imperial metric
    // MODIFIES: this
    // EFFECTS: calculates and returns the patient BMI score
    public double calculateBmi(int weight, int heightFt, int heightIn) {
        this.weight = weight;
        this.heightFt = heightFt;
        this.heightIn = heightIn;
        this.height = (heightFt * 12) + heightIn;
        this.bmi = (weight * CONVERSION_FACTOR) / (height * height);
        finalBmi = round(bmi, 1);
        this.bmi = finalBmi;
        return bmi;
    }

    // REQUIRES: patient name
    // MODIFIES: this
    // EFFECTS: sets the name of patient to the given name
    public void setName(String name) {
        this.name = name;
    }

    // REQUITES: foot component of height
    // EFFECTS: sets the patient to given feet height
    public void setHeightFt(int heightFt) {
        this.heightFt = heightFt;
    }

    // REQUIRES: inch component of height
    // EFFECTS: sets the patient to given inch height
    public void setHeightIn(int heightIn) {
        this.heightIn = heightIn;
    }

    // REQUIRES: weight in lbs
    // EFFECTS: sets the patient to given weight
    public void setWeight(int weight) {
        this.weight = weight;
    }

    // REQUIRES: bmi score in kg/m^2
    // EFFECTS: sets patient to calculated bmi
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    // EFFECTS: returns patient name
    public String getName() {
        return name;
    }

    // EFFECTS: returns patient bmi score
    public double getBmi() {
        return bmi;
    }

    // EFFECTS: returns the toString print of the patient screened
    public String toString() {
        return ("Name: " + this.name + ", Weight: " + this.weight + " lbs" + ", Height: " + this.heightFt + "'" + //
                this.heightIn + "\"" + ", BMI: " + this.bmi + " kg/m^2");
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Name", name);
        json.put("Weight", weight);
        json.put("HeightFt", heightFt);
        json.put("HeightIn", heightIn);
        json.put("BMI", bmi);
        return json;
    }
}
