package ui;

import java.io.FileNotFoundException;
import ui.BmiAppGUI;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            // EFFECTS: Call from main to run GUI
            public void run() {
                BmiAppGUI.createAndDisplayGUI();
            }
        });
        try {
            new BmiApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
