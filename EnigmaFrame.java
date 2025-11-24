import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

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

    String output;

    String[] args = new String[6];

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

        //Top panel objects
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        //Making individual panels for the input and output boxes
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout());

        //Comboboxes to store the rotor values
        innerBox = new JComboBox<String>(rotorArgs);
        middleBox = new JComboBox<String>(rotorArgs);
        outerBox = new JComboBox<String>(rotorArgs);
        
        //Textbox to store the inital setupt
        initalTextField = new JTextField(3);

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
        inputTextArea = new JTextArea(10, 100);
        outputTextArea = new JTextArea(10, 100);
        outputTextArea.setEditable(false);

        inputPanel.add(new JLabel("Input "));
        inputPanel.add(inputTextArea);
        
        outputPanel.add( new JLabel("Output "));
        outputPanel.add(outputTextArea);

        //Adds all the objects to the frame
        this.add(topPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.SOUTH);

        //When configuring all the inputs to the enigma we want to have one listener to
        //Write all the values.        
        //Creates a action for decrypting the code
        decryptButton.addActionListener((e) -> {
            args[0] = String.valueOf(innerBox.getSelectedIndex() + 1);
            args[1] = String.valueOf(middleBox.getSelectedIndex() + 1);
            args[2] = String.valueOf(outerBox.getSelectedIndex() + 1);
            args[3] = initalTextField.getText();
            args[4] = "decrypt";
            args[5] = inputTextArea.getText();

            outputTextArea.setText(Comms.run(args));
        });
        //Creates a action for encrypting the code
        encryptButton.addActionListener((e) -> {
            args[0] = String.valueOf(innerBox.getSelectedIndex() + 1);
            args[1] = String.valueOf(middleBox.getSelectedIndex() + 1);
            args[2] = String.valueOf(outerBox.getSelectedIndex() + 1);
            args[3] = initalTextField.getText();
            args[4] = "encrypt";
            args[5] = inputTextArea.getText();

            outputTextArea.setText(Comms.run(args));
        });
        //Packs the code
        this.pack();
    }

}