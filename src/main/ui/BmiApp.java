package ui;

import model.Patient;
import model.PatientScreenLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


// Citation note: Code referenced from TellerApp application
// BMI calculator application
public class BmiApp {
    private static final String JSON_STORE = "./data/screenlog.json";

    private Patient pt;
    private Scanner input;
    private PatientScreenLog ptList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the BMI application
    public BmiApp() throws FileNotFoundException {
        runBmiApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBmiApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nFinished");
    }

    // EFFECTS: prints instruction menu for user reference
    private void displayMenu() {
        System.out.println("\nWelcome, select from the following options to continue:");
        System.out.println("\tAdd -> Add a patient and calculate BMI");
        System.out.println("\tSelect -> Select a patient to view BMI");
        System.out.println("\tRemove -> Remove a patient from screen log");
        System.out.println("\tReturn -> Return your patient screen log of all patients");
        System.out.println("\tExport -> Compile your patient screen log for export");
        System.out.println("\tSave -> Save your patient screen log to file");
        System.out.println("\tLoad -> Load your patient screen log from file");
        System.out.println("\tQuit => Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            newPatient();
        } else if (command.equals("select")) {
            selectPatient();
        } else if (command.equals("return")) {
            printList();
        }  else if (command.equals("export")) {
            exportList();
        } else if (command.equals("remove")) {
            removePatient();
        } else if (command.equals("save")) {
            savePatientScreenLog();
        } else if (command.equals("load")) {
            loadPatientScreenLog();
        } else {
            System.out.println("Please make a valid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes PatientScreenLog and scanner
    private void init() {
        ptList = new PatientScreenLog("Physician's Screen Log");
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        input.useDelimiter("\n");
    }

    // EFFECTS: instantiates a new patient with BMI and adds the patient to the screen log
    private void newPatient() {
        System.out.println("Please enter name of new patient:");
        String ptName = input.next();
        input.nextLine();

        pt = new Patient(ptName);
        double ptBmi = doCalculation();

        System.out.println("Entered name: " + ptName);
        System.out.println("BMI Score: " + ptBmi + " kg/m^2");

        ptList.addPatientToList(pt);
    }

    // EFFECTS: calculates the BMI
    private double doCalculation() {
        System.out.println("Please enter the patient weight (lbs):");
        int weight = input.nextInt();
        System.out.println("Please enter the patient height (ft) [1 of 2]:");
        int heightFt = input.nextInt();
        System.out.println("Please enter the patient height (in) [2 of 2]:");
        int heightIn = input.nextInt();
        input.nextLine(); // clears the line;
        // otherwise the carriage return is taken as the
        // next input and you get a blank "selected" loop

        double result = pt.calculateBmi(weight, heightFt, heightIn);
        return result;
    }

    // EFFECTS: prints selected patient BMI
    private void selectPatient() {
        System.out.println("Enter the name of the patient you would like to select: ");
        String patientSelect = input.next();

        for (int i = 0; i < ptList.length(); i++) {
            if (patientSelect.equals(ptList.getPatient(i).getName())) {
                System.out.println("You have selected: " + ptList.getPatient(i).getName());
                this.pt = ptList.getPatient(i);
                System.out.println("Name: " + pt.getName() + ", BMI: " + pt.getBmi() + " kg/m^2");
            }
        }
    }

    // EFFECTS: removes selected patient from screen log
    private void removePatient() {
        System.out.println("Enter the name of the patient you would like to remove: ");
        String patientSelect = input.next();

        for (int i = 0; i < ptList.length(); i++) {
            if (patientSelect.equals(ptList.getPatient(i).getName())) {
                System.out.println("You have selected: " + ptList.getPatient(i).getName());
                ptList.removePatient(ptList.getPatient(i));
            }
        }
    }

    // EFFECTS: loops through screen log of patients to print
    private void printList() {
        int index = 0;
        while (index < ptList.length()) {
            System.out.println(ptList.getPatient(index).toString());
            index = index + 1;
        }
    }

    // EFFECTS: returns complete log of all patients
    private void exportList() {
        System.out.println("Patient Screen Log: " + ptList.returnList());
    }

    // EFFECTS: saves the patient screen log to file
    private void savePatientScreenLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(ptList);
            jsonWriter.close();
            System.out.println("Saved " + ptList.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads patient screen log from file
    private void loadPatientScreenLog() {
        try {
            ptList = jsonReader.read();
            System.out.println("Loaded " + ptList.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
