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
    public void patientTest() {
        //create new instance of patient with name, id
        assertEquals("Jordan", this.patient.getName());
    }

    @Test
    public void bmiTest() {
        //double bmi = patient.calculateBmi(5,11,170);
        //patient.setBmi(bmi);
        assertEquals(23.0, this.patient.getBmi());
    }

    //make sure it returns the list
    @Test
    void returnString() {
        assertEquals("Jordan, Weight: 170, Height: 5'11\", BMI: 23.0", this.patient.toString());
    }
}
