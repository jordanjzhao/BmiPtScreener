package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientScreenLogTest {

    private PatientScreenLog ptList;
    private Patient patient;
    private Patient patient2;

    @BeforeEach
    public void setup() {
        ptList = new PatientScreenLog();
        patient = new Patient();
        patient.setName("jz");
        patient2 = new Patient();
        patient2.setName("jt");
    }

    //creating a list
    @Test
    public void createList() {
        ptList.addPatientToList(patient);
        assertEquals(1, ptList.getSize());
        ptList.addPatientToList(patient2);
        assertEquals(2, ptList.getSize());
    }

    //print the list
    @Test
    void printList() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals("jz, Weight: 0, Height: 0'0\", BMI: 0.0", ptList.getPatient(0));
    }
}
