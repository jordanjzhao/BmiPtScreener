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

    /*
    // EFFECTS: return list
    public ArrayList<Patient> returnList() {
        //return screenLog;
        for (int i = 0; i < screenLog.size(); i++) {
            Patient pt = screenLog.get(i);
            return pt;
            // return list // and then print it out in the ui
        }
    }
    */



    //EFFECTS: return size of list
    public int getSize() {
        return screenLog.size();
    }

    //EFFECTS: get patient
    public Patient getPatient(int index) {
        return screenLog.get(index);
    }

}
