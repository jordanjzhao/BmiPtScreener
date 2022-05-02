package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setup() {
        patient = new Patient("Jordan");

    }

    @Test
    public void patientTest() {
        //create new instance of patient with name, id
        assertEquals("Jordan", this.patient.getName());
    }
}