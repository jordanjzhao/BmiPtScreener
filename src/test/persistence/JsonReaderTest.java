package persistence;

import model.Patient;
import model.PatientScreenLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            PatientScreenLog ptList = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // do nothing
        }
    }

    @Test
    public void testReaderEmptyPatientScreenLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPatientScreenLog.json");
        try {
            PatientScreenLog ptList = reader.read();
            assertEquals("Physician Log", ptList.getName());
            assertEquals(0, ptList.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderSimplePatientScreenLog() {
        JsonReader reader = new JsonReader("./data/testReaderSimplePatientScreenLog.json");
        try {
            PatientScreenLog ptList = reader.read();
            assertEquals("Physician Log", ptList.getName());
            List<Patient> ptLog = ptList.getListOfPatients();
            assertEquals(1, ptLog.size());
            checkPatient("Jordan", ptLog.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
