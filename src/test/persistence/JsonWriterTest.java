package persistence;

import model.Patient;
import model.PatientScreenLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// when testing JsonWriter, strategy: design tests for JsonWriter that aims to
// write data to a file, and then use the reader to read it back in
// then check that we read in a copy of what was written out
public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            PatientScreenLog ptList = new PatientScreenLog("Physician Log");
            JsonWriter writer = new JsonWriter("./data\0illgal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // should pass
        }
    }

    @Test
    public void testWriterEmptyPatientList() {
        try {
            PatientScreenLog ptList = new PatientScreenLog("Physician Log");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPatientLog.json");
            writer.open();
            writer.write(ptList);
            writer.close();
            // compiles log of empty Patient Screen Log, now should be able to read this back
            JsonReader reader = new JsonReader("./data/testWriterEmptyPatientLog.json");
            ptList = reader.read();
            assertEquals("Physician Log", ptList.getName());
            assertEquals(0, ptList.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterSimplePatientScreenLog() {
        try {
            PatientScreenLog ptList = new PatientScreenLog("Physician Log");
            ptList.addPatientToList(new Patient("Jordan"));
            JsonWriter writer = new JsonWriter("./data/testWriterSimplePatientScreenLog.json");
            writer.open();
            writer.write(ptList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterSimplePatientScreenLog.json");
            ptList = reader.read();
            assertEquals("Physician Log", ptList.getName());
            List<Patient> ptLog = ptList.getListOfPatients();
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
