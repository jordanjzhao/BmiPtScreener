package persistence;

import org.json.JSONObject;

// Citation note: Code referenced from JsonSerializationDemo application
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
