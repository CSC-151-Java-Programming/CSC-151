import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    private static JButton loginButton; // Declare the button at the class level
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set the window to be visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a label
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Create a text field
        JTextField userText = new JTextField(20);
        userText.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Create a button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,80,165,25);
        panel.add(loginButton);

        // Add action listener to button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                JOptionPane.showMessageDialog(panel, "Hello " + userName);
            }
        });
    }
}