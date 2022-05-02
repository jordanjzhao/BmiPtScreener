package model;


import java.util.ArrayList;

// Represents a screen log of patients and their stored measurements
public class PatientScreenLog {
    private ArrayList<Patient> screenLog;

    //EFFECTS:  constructs an empty list of type Patient
    public PatientScreenLog() {
        screenLog = new ArrayList<>();
    }

    // EFFECTS: return Patient at given index of list
    public void getPatient(int index) {
        screenLog.get(index);
    }

    // MODIFIES: this
    // EFFECTS: Creates new Patient
    public void addPatient(Patient patient) {
        screenLog.add(patient);
    }

}
