package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientScreenLogTest {

    private PatientScreenLog ptList;
    private Patient patient;
    private Patient patient2;

    @BeforeEach
    public void setup() {
        ptList = new PatientScreenLog();
        patient = new Patient("jz");
        patient.setWeight(170);
        patient.setHeightFt(5);
        patient.setHeightIn(11);
        patient.setBmi(24.0);
        patient2 = new Patient("jt");
        patient2.setBmi(23.0);
    }

    @Test
    // creating a list
    public void createListTest() {
        ptList.addPatientToList(patient);
        assertEquals(1, ptList.length());
        ptList.addPatientToList(patient2);
        assertEquals(2, ptList.length());
    }

    @Test
    // select patient
    public void selectPatientTest() {
        ptList.addPatientToList(patient);
        assertEquals(ptList.getPatient(0), ptList.getPatient(0));
        ptList.addPatientToList(patient2);
    }

    @Test
    // print the patient as list
    void printListTest() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals(ptList.getPatient(0), ptList.getPatient(0));
    }

    @Test
    // returns the screen log
    void returnListTest() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals(ptList.returnList(), ptList.returnList());
    }

    @Test
    // Removes the patient
    void removePatientTest() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals(2, ptList.length());
        ptList.removePatient(patient);
        assertEquals(1, ptList.length());
    }
}
