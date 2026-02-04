import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarolinaPanthers2026 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("NFL Carolina Panthers 2026 Season Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        setupComponents(panel);

        frame.setVisible(true);
    }

    private static void setupComponents(JPanel panel) {
        JButton showItemsButton = new JButton("Show Items");
        panel.add(showItemsButton);

        showItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] items = { "Item 1", "Item 2", "Item 3", "Item 4" };
                String message = "Select an item:";

                String selectedItem = (String) JOptionPane.showInputDialog(
                    panel,
                    message,
                    "Select Item",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    items,
                    items[0]
                );

                if (selectedItem != null) {
                    String info = getItemInfo(selectedItem);
                    JOptionPane.showMessageDialog(panel, info);
                }
            }
        });
    }

    private static String getItemInfo(String item) {
        switch (item) {
            case "Item 1":
                return "Information about Item 1.";
            case "Item 2":
                return "Information about Item 2.";
            case "Item 3":
                return "Information about Item 3.";
            case "Item 4":
                return "Information about Item 4.";
            default:
                return "No information available.";
        }
    }
}