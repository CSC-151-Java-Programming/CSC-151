import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GroupProject_02Prototype {
    
    public static void main(String[] args) {
        // Creating file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a CSV file");

        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            
        }

        // Showing open dialog
        int userSelection = fileChooser.showOpenDialog(null);

        // If the user selects a file
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            System.out.println("Opening: " + fileToOpen.getAbsolutePath());
            displayCSV(fileToOpen);
        } else {
            System.out.println("No file selected");
        }
    }

    private static void displayCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
