package ui;

import model.Patient;

import java.util.Scanner;

// Bmi calculator application
public class BmiApp {
    private Patient pt;
    private Scanner input;

    // EFFECTS: runs the Bmi application
    public BmiApp() {
        runBmi();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBmi() {
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
        System.out.println("\tq => Quit");
    }
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            pt.calculateBmi();
            System.out.println("BMI: " + pt.getBmi());
        } else if (command.equals("s")) {
            pt.calculateBmi();
        } else if (command.equals("s")) {
            pt.calculateBmi();
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

}
