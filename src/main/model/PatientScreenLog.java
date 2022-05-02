package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a screen log of patients and their stored bmi measurements
public class PatientScreenLog implements Writable {
    private String name;
    private ArrayList<Patient> screenLog;

    // EFFECTS:  constructs an empty list of type Patient
    // constructs workroom with a name and empty list of patients
    public PatientScreenLog(String name) {
        this.name = name;
        screenLog = new ArrayList<>();
    }

    public String getName() {
        return name;
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
        //for (int i = 0; i < screenLog.size(); i++) {
        //    ptLog.add(screenLog.get(i));
        //}
        //return ptLog;
        return screenLog;
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

    // EFFECTS: returns an unmodifiable list of all patients in this patient screen log
    public List<Patient> getListOfPatients() {
        return Collections.unmodifiableList(screenLog);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Name", name);
        json.put("Patients", patientsToJson());
        return json;
    }

    // EFFECTS: returns patients in this patient screen log as a JSON array
    private JSONArray patientsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Patient p : screenLog) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
