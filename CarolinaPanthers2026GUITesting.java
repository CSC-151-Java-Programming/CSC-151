import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;

public class CarolinaPanthers2026GUITesting extends JFrame {
    private JPanel mainPanel, buttonPanel, itemPanel;
    private JButton button1, button2;
    private JList<String> itemList;
    private DefaultListModel<String> listModel;

    private String[] players = {
        // Place players here.
    };

    private String[] coaches = {
        // Place coaches/staff here.
    };

    public CarolinaPanthers2026GUITesting() {
        setTitle("NFL Carolina Panthers 2026 Season Info");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel(new CardLayout());
        buttonPanel = new JPanel();
        itemPanel = new JPanel();

        buttonPanel.setBackground(Color.WHITE);
        itemPanel.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.BLACK);

        button1 = new JButton("Players");
        button2 = new JButton("Coaches/Staff");

        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLUE);

        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLUE);

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setVisibleRowCount(10);

        itemList.setBackground(Color.WHITE);
        itemList.setForeground(Color.BLUE);
        itemList.setSelectionBackground(Color.BLUE);
        itemList.setSelectionForeground(Color.WHITE);

        itemList.addListSelectionListener(new ItemSelectionListener());

        JScrollPane scrollPane = new JScrollPane(itemList);
        itemPanel.setLayout(new BorderLayout());
        itemPanel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Go Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLUE);
        itemPanel.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(buttonPanel, "Buttons");
        mainPanel.add(itemPanel, "Items");

        add(mainPanel, BorderLayout.CENTER);

        button1.addActionListener(new ButtonClickListener("Players"));
        button2.addActionListener(new ButtonClickListener("Coaches/Staff"));
        backButton.addActionListener(e -> showButtons());
    }

    private class ButtonClickListener implements ActionListener {
        private String itemCategory;

        public ButtonClickListener(String itemCategory) {
            this.itemCategory = itemCategory;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updateItemList();
            showItems();
        }

        private void updateItemList() {
            listModel.clear();
            String[] items = null;
            if (itemCategory.equals("Players")) {
                items = players;
            } else if (itemCategory.equals("Coaches/Staff")) {
                items = coaches;
            }

            if (items != null) {
                for (String item : items) {
                    listModel.addElement(item);
                }
            }
        }
    }

    private class ItemSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedItem = itemList.getSelectedValue();
                if (selectedItem != null) {
                    showItemDetail(selectedItem);
                }
            }
        }
    }

    private void showItemDetail(String selectedItem) {
        String message = "Details about " + selectedItem;
        String title = playersListContains(selectedItem) ? "Players Details" : "Coaches/Staff Details";

        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean playersListContains(String selectedItem) {
        for (String player : players) {
            if (player.equals(selectedItem)) {
                return true;
            }
        }
        return false;
    }

    private void showItems() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "Items");
    }

    private void showButtons() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "Buttons");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarolinaPanthers2026GUITesting viewer = new CarolinaPanthers2026GUITesting();
            viewer.setVisible(true);
        });
    }
}
