import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame{

    //Fields for panel one
    private JComboBox<String> innerBox;
    private JComboBox<String> middleBox;
    private JComboBox<String> outerBox;

    private JTextField initalTextField;
    private JButton encryptButton;
    private JButton decryptButton;

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    int innerIndex;
    int middleIndex;
    int outerIndex;

    String initalPos;
    String input;
    String decrypt;
    String output;

    String[] args;

    //Not enirely sure how many rotors I need because I sucked at the Enigma code so I am going to start at 5
    private final String rotorArgs[] = {"1" , "2" , "3", "4", "5"};    

    public EnigmaFrame(){
        super();    
        //I Am going to make one panels to organize the GUI easily
        //One will Hold the inner, middle, outer roters, inital position text box and the Encrypt and Decrypt buttons
        //These panels will be in the north side of the JFrame

        //The Input and output box will be simply placed the JFrame in the center and south position

        //The total JFrame object setup
        this.setTitle("Enigma GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //Top panel objects
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        //Comboboxes to store the rotor values
        innerBox = new JComboBox<String>(rotorArgs);
        middleBox = new JComboBox<String>(rotorArgs);
        outerBox = new JComboBox<String>(rotorArgs);
        
        //Textbox to store the inital setupt
        initalTextField = new JTextField();xx

        //Buttons to setup the Encrypt and Decryption
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        //Set up the flow layout of the topPanel ie: inner rotor -> middle rotor -> ... -> encrypt button -> decrypt button
        topPanel.add(new JLabel("Inner "));
        topPanel.add(innerBox);

        topPanel.add(new JLabel("Middle "));
        topPanel.add(middleBox);

        topPanel.add(new JLabel("Outer "));
        topPanel.add(outerBox);

        topPanel.add(new JLabel("Inital Position "));
        topPanel.add(initalTextField);

        topPanel.add(encryptButton);
        topPanel.add(decryptButton);

        //Now we have the objects in the frame to setup
        //Finally the text boxes for input and output
        //We will set outputTextArea to false. Sure it doesnt matter in the backend as we will never be accepting it
        //as a input and when encrypting and decrypting we will overwrite their text value but its better to encapsulate
        //to prevent consumers from messing with stuff then not.
        inputTextArea = new JTextArea();
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        //Adds all the objects to the frame
        this.add(topPanel, BorderLayout.NORTH);

        this.add(new JLabel("Input "), BorderLayout.CENTER);
        this.add(inputTextArea, BorderLayout.CENTER);

        this.add( new JLabel("Output "), BorderLayout.SOUTH);
        this.add(outputTextArea, BorderLayout.SOUTH);

        //When configuring all the inputs to the enigma we want to have one listener to
        //Write all the values.
        EnigmaActionListener a = new EnigmaActionListener();
        innerBox.addActionListener(a);
        middleBox.addActionListener(a);
        outerBox.addActionListener(a);
        initalTextField.addActionListener(a);

        //Creates a action for decrypting the code
        decryptButton.addActionListener((e) -> {
            args[0] = String.valueOf(innerIndex) + 1;
            args[1] = String.valueOf(middleIndex) + 1;
            args[2] = String.valueOf(outerIndex) + 1;
            args[3] = initalPos;
            args[4] = "decrypt";
            args[5] = input;
            output = Comms.run(args);
        });
        //Creates a action for encrypting the code
        encryptButton.addActionListener((e) -> {
            args[0] = String.valueOf(innerIndex) + 1;
            args[1] = String.valueOf(middleIndex) + 1;
            args[2] = String.valueOf(outerIndex) + 1;
            args[3] = initalPos;
            //technically doesnt matter since it can be everything but decrypt
            args[4] = "encrypt";
            args[5] = input;
            output = Comms.run(args);
        });
        //Packs the code
        this.pack();
    }

    //Creates a private inner class to handle events that sets up the Enigma
    private class EnigmaActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Gets the index of the rotor number of each rotor
            innerIndex = innerBox.getSelectedIndex();
            middleIndex = middleBox.getSelectedIndex();
            outerIndex = outerBox.getSelectedIndex();

            //Gets the inital position of the rotors
            initalPos = initalTextField.getText();

            //Gets the text of the input
            input = inputTextArea.getSelectedText();

        }
    }
}