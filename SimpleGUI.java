// Making comments to learn along the way

// import javax.swing.*: 
// Imports the Swing library, 
// which provides classes for 
// building graphical user interfaces (e.g., JFrame, JLabel, JButton)

// import java.awt.event:
// Imports event handling classes that 
// allow you to manage user interactions, 
// such as clicking a button 


import javax.swing.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

// public class SimpleGUI: 
// Defines the main class; entry point of program

public class SimpleGUI {
    private static JButton loginButton; // Declare the button at the class level

    // public static void main(String[] args):
    // main method is the starting point of the application.
    // JVM calls method to run the program.
    public static void main(String[] args) {
        
        // Create the main window
        // JFrame: Represents the main window of the application
        // setDefaultCloseOperation: Ensures program terminates when user closes window
        // setSize: Sets dimensions of the window (300 pixels wide, 200 pixels tall)

        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);

        // Create a panel to hold components
        // JPanel: A container that can hold components. Organizes the layout and adds
        // components like labels, text fields, and buttons
        // frame.add(panel): Adds the panel to the frame
        // placeComponents(panel): Calls a method to place components on panel

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // frame.SetVisible: Set the window to be visible on screen.
        // Without it, window will not be visible

        frame.setVisible(true);
    }

    // placeComponents: A method that adds components to panel
    // setLayout(null): Sets the layout manager to null, allowing 
    // for absolute positioning of components

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a label
        // JLabel: Displays text (in this case, "User:")
        // setBounds: Sets the position (x=10, y=20) and size
        // (width=80, height=25) of the label in panel

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Create a text field
        // JTextField: A field where users can input text

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Create a button
        // JButton: A button that's clickable

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        panel.add(loginButton);

        // Add action listener to button
        // addActionListener: Attaches an event listener to the button
        // actionPerformed(ActionEvent e): Method is called when button is clicked
            // userText.getText(): Retrieves the text entered by the user in the text field
            // JOptionPane.showMessageDialog: Displays a dialog box showing a greeting that
            // includes the user's name
            
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                JOptionPane.showMessageDialog(panel, "Hello " + userName);
            }
        });
    }
}