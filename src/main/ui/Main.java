package ui;

import java.io.FileNotFoundException;

import model.Event;
import model.EventLog;
import ui.BmiAppGUI;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            // EFFECTS: Call from main to run GUI
            public void run() {
                BmiAppGUI.createAndDisplayGUI();
            }
        });
        // Prints EventLog on Program Termination
        // Source: https://stackoverflow.com/questions/5824049/running-a-method-when-closing-the-program
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString() + "\n");
                }
            }
        }, "Shutdown-thread"));
        /*
        try {
            new BmiApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
         */
    }
}
