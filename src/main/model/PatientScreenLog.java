package model;


import java.util.ArrayList;
import java.util.Arrays;

// Represents a screen log of patients and their stored measurements
public class PatientScreenLog {
    private ArrayList<Patient> screenLog;

    //EFFECTS:  constructs an empty list of type Patient
    public PatientScreenLog() {
        screenLog = new ArrayList<>();
    }

    // EFFECTS: return Patient at given index of list
    //public void getPatient(String name) {
    //    screenLog.get(name);
    //}

    // MODIFIES: this
    // EFFECTS: add patient to list
    public void addPatientToList(Patient patient) {
        screenLog.add(patient);
    }
/*
    public void getList() {
        return screenLog;
    }
*/

    //EFFECTS: return list
    public ArrayList<Patient> returnList() {
        //return screenLog;
        ArrayList<Patient> ptLog = new ArrayList<>();
        for (int i = 0; i < screenLog.size(); i++) {
            ptLog.add(screenLog.get(i));
            // return list // and then print it out in the ui
        }
        return ptLog;
    }

    //EFFECTS: return size of list
    public int length() {
        return screenLog.size();
    }

    //EFFECTS: get patient
    public Patient getPatient(int index) {
        return screenLog.get(index);
    }

    //EFFECTS: remove patient
    public Boolean removePatient(Patient p) {
        return screenLog.remove(p);
    }

}
