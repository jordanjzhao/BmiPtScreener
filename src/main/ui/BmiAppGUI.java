package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.apple.eawt.Application;

// GUI Class for BMIApp
public class BmiAppGUI extends JFrame implements ListSelectionListener  {
    private static final String addString = "Add";
    private static final String removeString = "Remove";
    private static final String saveString = "Save";
    private static final String loadString = "Load";
    private static final String JSON_STORE = "./data/screenlog.json";
    private static final String sqrSymbol = "²";


    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JLabel ptNameLabel;
    private JLabel ptWeightLabel;
    private JLabel ptHeightFtLabel;
    private JLabel ptHeightInLabel;

    private JPanel titlePanel;
    private JPanel patientPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel gridPanel;


    private JButton addButton;
    private JButton removeButton;
    private JButton saveButton;
    private JButton loadButton;

    private JTextField ptNameTF;
    private JTextField ptWeightTF;
    private JTextField ptHeightFtTF;
    private JTextField ptHeightInTF;

    // implementation of list model - to manage items displayed by JList control
    private DefaultListModel patientModel;
    // a component that displays a set of Objects and allows user to select one or more items
    private JList patientJList;

    private JOptionPane optionPane;

    private ImageIcon bmiIcon = new ImageIcon("src/images/BmiPtScreener.png");
    private ImageIcon bmiLogo = new ImageIcon("src/images/bmiLogo.png");
    //PTScreenLog Instance:
    private PatientScreenLog ptList = new PatientScreenLog("Physician's Screen Log");


    // Construct new GUI (Graphical User Interface) for Bmi App
    public BmiAppGUI() {
        // Create list model placed in scroll pane
        JScrollPane patientJListScrollPane = setupListModel();
        // Setup panels to be used
        setupPanels();

        // Setup buttons and fields and add to panel
        setupButtonFields();

        //layout
        //JPanel ptListPanel = new JPanel();

        // Setup panel layout adding panels to their specified location
        setupPanelLayout(patientJListScrollPane);

        // Setup JSON
        setupJson();

        // action commands
        setupActionCommands();

        // action button
        setupButtonActions();
    }

    private void setupButtonActions() {
        AddListener addListener = new AddListener(addButton);
        addButton.addActionListener(addListener);
        ptNameTF.addActionListener(addListener);
        ptNameTF.getDocument().addDocumentListener(addListener);
        //String ptName = patientModel.getElementAt(patientJList.getSelectedIndex()).toString();
        addButton.setEnabled(false);

        removeButton.addActionListener(new RemoveListener());
        SaveListener saveListener = new SaveListener(saveButton);
        saveButton.addActionListener(saveListener);
        LoadListener loadListener = new LoadListener(loadButton);
        loadButton.addActionListener(loadListener);

        // JOptionPane on button click
        optionPane = new JOptionPane("JOptionPane");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.informationIcon", bmiLogo);
        optionPane.setSize(200, 200);
        optionPane.setVisible(false);
    }

    private void setupActionCommands() {
        addButton.setActionCommand("add");
        removeButton.setActionCommand("remove");
        saveButton.setActionCommand("save");
        loadButton.setActionCommand("load");
    }

    private void setupJson() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    private void setupPanelLayout(JScrollPane patientJListScrollPane) {
        //resize image
        Image bmiImg = bmiIcon.getImage();
        Image newBmiIcon = bmiImg.getScaledInstance(321, 138,  Image.SCALE_SMOOTH);
        bmiIcon = new ImageIcon(newBmiIcon);
        //set title panel
        JLabel titleIcon = new JLabel(bmiIcon);
        titlePanel.add(titleIcon);
        //titlePanel.add(new JLabel("Patient Screen Log"));

        textPanel.add(ptNameLabel);
        textPanel.add(ptNameTF);
        textPanel.add(ptWeightLabel);
        textPanel.add(ptWeightTF);
        textPanel.add(ptHeightFtLabel);
        textPanel.add(ptHeightFtTF);
        textPanel.add(ptHeightInLabel);
        textPanel.add(ptHeightInTF);

        gridPanel.add(textPanel);
        gridPanel.add(buttonPanel);

        add(patientJListScrollPane);
        add(titlePanel, BorderLayout.NORTH);
        //add(ptListPanel, BorderLayout.CENTER);

        add(gridPanel, BorderLayout.PAGE_END);
    }

    private void setupButtonFields() {
        ptNameLabel = new JLabel("Name:");
        ptNameTF = new JTextField(10);

        ptWeightLabel = new JLabel("Weight (Lbs):");
        ptWeightTF = new JTextField(5);
        ptHeightFtLabel = new JLabel("Height (Ft):");
        ptHeightFtTF = new JTextField(5);
        ptHeightInLabel = new JLabel("Height (In):");
        ptHeightInTF = new JTextField(5);

        addButton = new JButton(addString);
        removeButton = new JButton(removeString);
        saveButton = new JButton(saveString);
        loadButton = new JButton(loadString);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
    }

    private void setupPanels() {
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gridPanel = new JPanel(new GridLayout(2, 1));
    }

    private JScrollPane setupListModel() {
        patientModel = new DefaultListModel<>();
        patientJList = new JList<>(patientModel);
        patientJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        patientJList.setSelectedIndex(0);
        patientJList.addListSelectionListener(this);
        patientJList.setVisibleRowCount(10);
        JScrollPane patientJListScrollPane = new JScrollPane(patientJList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar bar = patientJListScrollPane.getVerticalScrollBar();
        bar.setPreferredSize(new Dimension(200, 200));
        return patientJListScrollPane;
    }

    class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = patientJList.getSelectedIndex();
            patientModel.remove(index);

            int size = patientModel.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                removeButton.setEnabled(false);

            } else { //Select an index.
                if (index == patientModel.getSize()) {
                    //removed item in last position
                    index--;
                }

                patientJList.setSelectedIndex(index);
                patientJList.ensureIndexIsVisible(index);
                //UIManager.put("OptionPane.okButtonText", "Ok");
                JOptionPane.showMessageDialog(optionPane, "Patient removed");
            }
        }
    }

    class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            Patient pt = new Patient(ptNameTF.getText());
            int weight = Integer.parseInt(ptWeightTF.getText());
            int heightFt = Integer.parseInt(ptHeightFtTF.getText());
            int heightIn = Integer.parseInt(ptHeightInTF.getText());
            double ptBmi = pt.calculateBmi(weight, heightFt, heightIn);
            setPatientToAdd(pt, weight, heightFt, heightIn, ptBmi);

            if (pt.getName().equals("") || alreadyInList(pt.getName())) {
                Toolkit.getDefaultToolkit().beep();
                ptNameTF.requestFocusInWindow();
                ptNameTF.selectAll();
                return;
            }

            int index = patientJList.getSelectedIndex();
            if (index == -1) {
                index = 0;
            } else {
                index++;
            }

            insertPatientToModel(ptBmi, index);

            resetPatientToAdd(index);
            //UIManager.put("OptionPane.okButtonText", "Ok");
            JOptionPane.showMessageDialog(optionPane, "Patient added: " + pt.getName());
        }

        private void insertPatientToModel(double ptBmi, int index) {
            patientModel.insertElementAt("Name: " + ptNameTF.getText() + " "
                    + "Weight: " + ptWeightTF.getText() + "lbs "
                    + "Height: " + ptHeightFtTF.getText() + "\'" + ptHeightInTF.getText() + "\" "
                            + "BMI: " + ptBmi + " kg/m" + sqrSymbol,
                    index);
        }

        private void resetPatientToAdd(int index) {
            ptNameTF.requestFocusInWindow();
            ptNameTF.setText("");
            ptWeightTF.setText("");
            ptHeightFtTF.setText("");
            ptHeightInTF.setText("");
            patientJList.setSelectedIndex(index);
            patientJList.ensureIndexIsVisible(index);
        }

        private void setPatientToAdd(Patient pt, int weight, int heightFt, int heightIn, double ptBmi) {
            pt.setWeight(weight);
            pt.setHeightFt(heightFt);
            pt.setHeightIn(heightIn);
            pt.setBmi(ptBmi);
            ptList.addPatientToList(pt);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return patientModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (patientJList.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                removeButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                removeButton.setEnabled(true);
            }
        }
    }

    class SaveListener implements ActionListener {
        private JButton button;

        public SaveListener(JButton button) {
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            savePatientScreenLog();
        }
    }

    class LoadListener implements ActionListener {
        private JButton button;

        public LoadListener(JButton button) {
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            loadPatientScreenLog();
        }
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                newPatient();
                break;
            case "save":
                savePatientScreenLog();
                break;
            case "load":
                loadPatientScreenLog();
                break;
        }
    }


    // MODIFIES: ptLog
    // EFFECTS: instantiates a new patient with BMI and adds the patient to the screen log
    private void newPatient() {
        Patient pt = new Patient(ptNameTF.getText());
        int weight = Integer.parseInt(ptWeightTF.getText());
        int heightFt = Integer.parseInt(ptHeightFtTF.getText());
        int heightIn = Integer.parseInt(ptHeightInTF.getText());
        double ptBmi = pt.calculateBmi(weight, heightFt, heightIn);

        ptList.addPatientToList(pt);
        patientModel.addElement(ptNameTF.getText());
    }
/*
    // MODIFIES: ptLog
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
*/
    // EFFECTS: saves the patient screen log to file
    private void savePatientScreenLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(ptList);
            jsonWriter.close();
            JOptionPane.showMessageDialog(optionPane, "Patient screen log saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads patient screen log from file
    private void loadPatientScreenLog() {
        try {
            patientModel.removeAllElements();
            ptList = jsonReader.read();
            for (Patient pt : ptList.getListOfPatients()) {
                //patientModel.addElement(pt.getName());
                patientModel.addElement(
                        "Name: " + pt.getName() + " " + "Weight: " + pt.getWeight() + "lbs "
                        + "Height: " + pt.getHeightFt() + "\'" + pt.getHeightIn() + "\" "
                        + "BMI: " + pt.getBmi() + " kg/m" + sqrSymbol
                );
            }
            JOptionPane.showMessageDialog(optionPane, "Patient screen log loaded");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    public static void createAndDisplayGUI() {
        BmiAppGUI app = new BmiAppGUI();
        app.setSize(800, 600);
        app.setLocation(100, 100);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule job for event-dispatching thread:
        //creating and showing BmiApp GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Application application = Application.getApplication();
                Image image = Toolkit.getDefaultToolkit().getImage("src/images/bmiLogo.png");
                application.setDockIconImage(image);

                JOptionPane startPane = new JOptionPane("Welcome");
                ImageIcon bmiStart = new ImageIcon("src/images/bmiStart.gif");
                UIManager.put("OptionPane.informationIcon", bmiStart);
                UIManager.put("OptionPane.okButtonText", "Start");
                JOptionPane.showMessageDialog(startPane, "Welcome");
                createAndDisplayGUI();
            }
        });
    }
}
