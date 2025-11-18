import javax.swing.*;
import java.awt.*;

public class EnigmaFrame {
    public static void main(String args[]){

        //I Am going to make 2 panels to organize the GUI easily
        //One will Hold the inner, middle, and outer roters.
        //The Second Will hold the inital position text box and the Encrypt and Decrypt buttons
        //These two panels will be in the north side of the JFrame

        //The Input and output box will be simply placed the JFrame in the center and south position

        //The total JFrame object setup
        JFrame enigmaFrame = new JFrame();
        enigmaFrame.setTitle("Enigma GUI");
        enigmaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enigmaFrame.setVisible(true);

        //Rotor panel objects
        JPanel rotorPanel = new JPanel();
        rotorPanel.setLayout(new BorderLayout());

        //Rotor labels
        JLabel innerRotorLabel = new JLabel("Inner ");
        JLabel middleRotorLabel = new JLabel("Middle ");
        JLabel outerRotorLabel = new JLabel("Outer ");

        //Not enirely sure how many rotors because I sucked at the Enigma code so I am going to start at 5
        String rotorArgs[] = {"1" , "2" , "3", "4", "5"};

        //Comboboxes to store the rotor values
        JComboBox innerBox = new JComboBox<>(rotorArgs);
        JComboBox middleBox = new JComboBox<>(rotorArgs);
        JComboBox outerBox = new JComboBox<>(rotorArgs);

        //First of all setting up the layout of the rotorPanel
        rotorPanel.add(innerRotorLabel, BorderLayout.WEST);
        rotorPanel.add(innerBox, BorderLayout.WEST);

        rotorPanel.add(middleRotorLabel, BorderLayout.CENTER);
        rotorPanel.add(middleBox, BorderLayout.CENTER);

        rotorPanel.add(outerRotorLabel, BorderLayout.EAST);
        rotorPanel.add(outerBox, BorderLayout.EAST);

        //Inital Positions/Ecrypt/Decrypt panel will be called miscPanel
        JPanel miscPanel = new JPanel();
        rotorPanel.setLayout(new BorderLayout());

        //Inital position objects
        JLabel initalPosLabel = new JLabel("Inital Position ");
        JTextField initalTextField = new JTextField();

        //Encrypt and Decrypt Buttons
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");

        //Setting up the layout of the rotorPanel
        miscPanel.add(initalPosLabel, BorderLayout.WEST);
        miscPanel.add(initalTextField, BorderLayout.WEST);

        miscPanel.add(encryptButton, BorderLayout.CENTER);
        miscPanel.add(decryptButton, BorderLayout.EAST);

        //Finally the text boxes for input and output
        JLabel inputLabel = new JLabel("Input ");
        JLabel outputLabel = new JLabel("Output ");

        JTextArea inputTextArea = new JTextArea();
        JTextArea outputTextArea = new JTextArea();

        //Adds the input and output to the frame
        enigmaFrame.add(inputLabel, BorderLayout.CENTER);
        enigmaFrame.add(inputTextArea, BorderLayout.CENTER);

        enigmaFrame.add(outputLabel, BorderLayout.SOUTH);
        enigmaFrame.add(outputTextArea, BorderLayout.SOUTH);

        enigmaFrame.pack();
    }
}