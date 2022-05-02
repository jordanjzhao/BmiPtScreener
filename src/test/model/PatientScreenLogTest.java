package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PatientScreenLogTest {

    private PatientScreenLog ptList;
    private Patient patient;
    private Patient patient2;

    @BeforeEach
    public void setup() {
        ptList = new PatientScreenLog();
        patient = new Patient("jz");
        //patient.setName("jz");
        patient.setWeight(170);
        patient.setHeightFt(5);
        patient.setHeightIn(11);
        patient.setBmi(24.0);
        patient2 = new Patient("jt");
        //patient2.setName("jt");
        patient2.setBmi(23.0);
    }

    //creating a list
    @Test
    public void createListTest() {
        ptList.addPatientToList(patient);
        assertEquals(1, ptList.length());
        ptList.addPatientToList(patient2);
        assertEquals(2, ptList.length());
    }

    @Test
    public void selectPatientTest() {
        ptList.addPatientToList(patient);
        assertEquals(ptList.getPatient(0), ptList.getPatient(0));
        ptList.addPatientToList(patient2);
    }

    //print the list
    @Test
    void printListTest() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals(ptList.getPatient(0), ptList.getPatient(0));
    }

    @Test
    void returnListTest() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);

        assertEquals(ptList.returnList(), ptList.returnList());
    }

    @Test
    void removePatientTest() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals(2, ptList.length());
        ptList.removePatient(patient);
        assertEquals(1, ptList.length());
    }
}
