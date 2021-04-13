package IPSGUI;

import backend.PatientProfDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class PatientSystemGUI extends JFrame implements ActionListener {

    PatientProfDB database;
    String filePath;
    MainMenu mainMenu;
    CreateProfile createProfile;
    DeleteProfile deleteProfile;
    UpdateProfile updateProfile;

    public PatientSystemGUI(){
        mainMenu = new MainMenu(this);
        createProfile = new CreateProfile(this);
        deleteProfile = new DeleteProfile(this);
        updateProfile = new UpdateProfile(this);

        startUp();
    }

    // Function that handles the startup of the program, selecting the file to run with and launching the main menu
    public void startUp(){

        // Create a new object to choose a file
        JFileChooser fc = new JFileChooser("C:\\Users\\samsc\\Documents\\UCONN\\CSE2102\\RealProjects\\IPS2102");
        boolean valid = false;
        // Keep trying to choose and open a file until it works with a valid file or user hits CANCEL
        while(!valid) {
            int i = fc.showOpenDialog(this);
            // Open file branch
            if (i == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filePath = file.getPath();
                try {
                    database = new PatientProfDB(filePath);
                    database.initializeDatabase(filePath);
                    valid = true;
                    mainMenu.setVisible(true);
                } catch (RuntimeException e){
                    new ErrorBox(e.getMessage());
                }
            }
            // Cancel branch
            else if (i == JFileChooser.CANCEL_OPTION){
                valid = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== mainMenu.getSelect()){
            handleMainMenu();
        }
    }

    // Method to handle clicking select in MainMenu
    private void handleMainMenu(){
        String selection = mainMenu.getSelction();
        switch (selection){
            case "create":
                mainMenu.setVisible(false);
                createProfile.setVisible(true);
                break;
            case "delete":
                mainMenu.setVisible(false);
                deleteProfile.setVisible(true);
                break;
            case "update":
                mainMenu.setVisible(false);
                updateProfile.setVisible(true);
                break;
            case "find":
                break;
            case "displayAll":
                break;
        }
    }

    public static void main(String[] args){
        new PatientSystemGUI();
    }
}
