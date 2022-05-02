package ui;

import model.Patient;
import model.PatientScreenLog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Bmi calculator application
public class BmiApp {
    private Patient pt;
    private Scanner input;
    private PatientScreenLog ptList;

    // EFFECTS: runs the Bmi application
    public BmiApp() {
        ptList = new PatientScreenLog();
        runBmi();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBmi() {
        boolean keepGoing = true;
        String command = "";

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
            doCalculation();
        } else if (command.equals("p")) {
            doCalculation();
        } else {
            System.out.println("Please make a valid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        pt = new Patient("Jordan");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void newPatient() {
        System.out.println("Please enter name of new patient:");
        String ptName = input.next();
        input.nextLine();
        //Patient p = new Patient();

        // System.out.println("Entered name: " + p.getName());
        double ptBmi = doCalculation();

        //p.setName(ptName);
        //p.setBmi(ptBmi);
        Patient p = new Patient(ptName);
        p.setBmi(ptBmi);

        System.out.println("Entered name: " + ptName);
        System.out.println("Calculated BMI: " + ptBmi);
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

        double result = pt.calculateBmi(heightFt, heightIn, weight);
        pt.setWeight(weight);
        pt.setHeightFt(heightFt);
        pt.setHeightIn(heightIn);
        //return result;
        //System.out.println("BMI: " + result);
        return result;
    }
/*
    private ArrayList<Patient> printList() {
        for (Patient pt : ptList) {
            System.out.println(pt);
        }
    }
*/

}
