package persistence;

import model.Patient;
import model.PatientScreenLog;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPatient(String name, Patient patient) {
        assertEquals(name, patient.getName());
    }
}
