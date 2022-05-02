package model;

import java.util.ArrayList;
import java.util.Arrays;

// Represents a screen log of patients and their stored bmi measurements
public class PatientScreenLog {
    private ArrayList<Patient> screenLog;

    //EFFECTS:  constructs an empty list of type Patient
    public PatientScreenLog() {
        screenLog = new ArrayList<>();
    }

    // REQUIRES: patient to be added
    // MODIFIES: this
    // EFFECTS: adds patient to screen log
    public void addPatientToList(Patient patient) {
        screenLog.add(patient);
    }

    //EFFECTS: return full list of screen log
    public ArrayList<Patient> returnList() {
        ArrayList<Patient> ptLog = new ArrayList<>();
        for (int i = 0; i < screenLog.size(); i++) {
            ptLog.add(screenLog.get(i));
        }
        return ptLog;
    }

    //EFFECTS: return size of screen log
    public int length() {
        return screenLog.size();
    }

    // REQUIRES: indexed value of patient of interest
    // EFFECTS: returns patient at selected index
    public Patient getPatient(int index) {
        return screenLog.get(index);
    }

    // REQUIRES: selected patient of interest
    // MODIFIES: this
    // EFFECTS: removes patient from the screen log
    public Boolean removePatient(Patient p) {
        return screenLog.remove(p);
    }

}
