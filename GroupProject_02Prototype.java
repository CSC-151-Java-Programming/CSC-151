import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// A. Young (Aly3673) - Made the GUI
public class GroupProject_02Prototype {
    public static void main(String[] args) {
        // Creating file chooser
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Open CSV File");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new FlowLayout());

            JButton openButton = new JButton("Open CSV File");
            openButton.addActionListener(e -> openFile());

            frame.add(openButton);
            frame.setVisible(true);
        });
    }
        
        
    private static void openFile() { 
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            String filePath = fileToOpen.getAbsolutePath();

            try {
                readCsvFile(fileToOpen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readCsvFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}