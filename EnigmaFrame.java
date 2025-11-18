import javax.swing.*;
import java.awt.*;

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
        initalTextField = new JTextField();

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

        inputTextArea = new JTextArea();
        outputTextArea = new JTextArea();

        //Adds all the objects to the frame
        this.add(topPanel, BorderLayout.NORTH);

        this.add(new JLabel("Input "), BorderLayout.CENTER);
        this.add(inputTextArea, BorderLayout.CENTER);

        this.add( new JLabel("Output "), BorderLayout.SOUTH);
        this.add(outputTextArea, BorderLayout.SOUTH);

        this.pack();
    }
}