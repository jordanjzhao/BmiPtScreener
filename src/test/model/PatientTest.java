package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setup() {
        this.patient = new Patient("Jordan");

    }

    @Test
    public void patientTest() {
        //create new instance of patient with name, id
        assertEquals("Jordan", this.patient.getName());
    }

    @Test
    public void bmiTest() {
        this.patient.calculateBmi(170,5,11);
        assertEquals(24, this.patient.getBmi());
    }

    //make sure it returns the list
    @Test
    void returnString() {
        assertEquals("Jordan 0.0", this.patient.toString());
    }
}