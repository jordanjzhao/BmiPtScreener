package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setup() {
        patient = new Patient("Jordan");
        //patient.setName("Jordan");
        double bmi = patient.calculateBmi(170,5,11);
        patient.setBmi(bmi);
    }

    @Test
    // set patient name
    public void setNameTest() {
        Patient p = new Patient("Ed");
        p.setName("Jordan");
        assertEquals("Jordan", this.patient.getName());
    }

    @Test
    // create new instance of patient with name
    public void patientTest() {
        assertEquals("Jordan", this.patient.getName());
    }

    @Test
    // calculate BMI
    public void bmiTest() {
        assertEquals(23.0, this.patient.getBmi());
    }

    @Test
    // return patient to string
    void returnString() {
        assertEquals("Name: Jordan, Weight: 170 lbs, Height: 5'11\", BMI: 23.0 kg/m^2", this.patient.toString());
    }
}
