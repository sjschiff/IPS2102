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
        startUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== mainMenu.getSelect()){
            System.out.println("Select Clicked");
        }
    }

    public void startUp(){
        JFileChooser fc = new JFileChooser();
        int i = fc.showOpenDialog(this);
        if(i==JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            filePath = file.getPath();
            database = new PatientProfDB(filePath);
            database.initializeDatabase(filePath);
        }
    }

    public static void main(String[] args){
        new PatientSystemGUI();
    }
}
