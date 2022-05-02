package persistence;

import model.Patient;
import model.PatientScreenLog;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Citation note: Code referenced from JsonSerializationDemo application
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: read patient screen log from file and returns it
    // throws IOException if an error occurs reading data from file
    public PatientScreenLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePatientScreenLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses patient screen log from JSON object and returns it
    private PatientScreenLog parsePatientScreenLog(JSONObject jsonObject) {
        String name = jsonObject.getString("Name");
        PatientScreenLog pt = new PatientScreenLog(name);
        addPatients(pt, jsonObject);
        return pt;
    }
    // MODIFIES: psl
    // EFFECTS: parses patients from JSON object and adds them to patient screen log
    private void addPatients(PatientScreenLog psl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Patients");
        for (Object json : jsonArray) {
            JSONObject nextPatient = (JSONObject) json;
            addPatient(psl, nextPatient);
        }
    }

    // MODIFIES: psl
    // EFFECTS: parses patient from JSON object and adds them
    private void addPatient(PatientScreenLog psl, JSONObject jsonObject) {
        String name = jsonObject.getString("Name");
        int weight = jsonObject.getInt("Weight");
        int heightFt = jsonObject.getInt("HeightFt");
        int heightIn = jsonObject.getInt("HeightIn");
        double bmi = Patient.round(jsonObject.getFloat("BMI"), 1);
        Patient pt = new Patient(name);
        pt.setWeight(weight);
        pt.setHeightFt(heightFt);
        pt.setHeightIn(heightIn);
        pt.setBmi(bmi);
        psl.addPatientToList(pt);
    }
}
