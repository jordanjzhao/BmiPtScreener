package model;

import static model.Patient.round;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setup() {
        patient = new Patient("Jordan");
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
        assertEquals(170, this.patient.getWeight());
        assertEquals(5, this.patient.getHeightFt());
        assertEquals(11, this.patient.getHeightIn());
        assertEquals(23.7, this.patient.getBmi());
    }

    @Test
    // calculate BMI
    public void bmiTest() {
        assertEquals(23.7, this.patient.getBmi());
    }

    @Test
    // return patient to string
    void returnString() {
        assertEquals("Name: Jordan, Weight: 170 lbs, Height: 5'11\", BMI: 23.7 kg/m^2",
                this.patient.toString());
    }

    @Test
    // test round function input places is >= 0
    void testRoundValid() {
        try {
            round(23.67, 1);
            assertEquals(23.7, round(23.67, 1));
        } catch (IllegalArgumentException e) {
            fail("Caught Illegal Argument Exception when shouldn't have");
        }

        try {
            round(23.67, -1);
            fail("Should be throwing an Illegal Argument Exception");
        } catch (IllegalArgumentException e) {
            // do nothing, pass
        }
    }
}
