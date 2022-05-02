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
    public void createList() {
        ptList.addPatientToList(patient);
        assertEquals(1, ptList.length());
        ptList.addPatientToList(patient2);
        assertEquals(2, ptList.length());
    }

    //print the list
    @Test
    void printList() {
        ptList.addPatientToList(patient);
        ptList.addPatientToList(patient2);
        assertEquals("jz, Weight: 170, Height: 5'11\", BMI: 24.0", ptList.getPatient(0));
    }
}
