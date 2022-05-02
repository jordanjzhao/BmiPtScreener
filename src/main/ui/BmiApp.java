package ui;

import model.Patient;
import model.PatientScreenLog;

import java.util.Scanner;

// Bmi calculator application
public class BmiApp {
    private Patient pt;
    private Scanner input;
    private PatientScreenLog ptList;

    // EFFECTS: runs the Bmi application
    public BmiApp() {
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

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nFinished");
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add Patient");
        System.out.println("\ts -> Select Patient");
        System.out.println("\tp -> Print Patient Screen Log");
        System.out.println("\tq => Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            newPatient();
        } else if (command.equals("s")) {
            selectPatient();
        } else if (command.equals("p")) {
            returnList();
        } else {
            System.out.println("Please make a valid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        ptList = new PatientScreenLog();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void newPatient() {
        System.out.println("Please enter name of new patient:");
        String ptName = input.next();
        input.nextLine();

        pt = new Patient(ptName);
        double ptBmi = doCalculation();

        System.out.println("Entered name: " + ptName);
        System.out.println("Calculated BMI: " + ptBmi);

        ptList.addPatientToList(pt);
    }

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

    private void selectPatient() {
        System.out.println("Enter the name of the patient you would like to select: ");
        String patientSelect = input.next();

        for (int i = 0; i < ptList.length(); i++) {
            if (patientSelect.equals(ptList.getPatient(i).getName())) {
                System.out.println("You have selected: " + ptList.getPatient(i).getName());
                this.pt = ptList.getPatient(i);
                System.out.println(pt.getName() + ", BMI: " + pt.getBmi());
            }
        }
    }

    private void printList() {
        int index = 0;
        while (index < ptList.length()) {
            System.out.println(ptList.getPatient(index));
            index = index + 1;
        }
    }

    private void returnList() {
        System.out.println("Patients: " + ptList.returnList());
    }
}
