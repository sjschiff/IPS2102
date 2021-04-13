package IPSGUI;

import backend.PatientProf;
import backend.PatientProfDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// Main GUI class
public class PatientSystemGUI extends JFrame implements ActionListener {

    PatientProfDB database;
    String filePath;
    MainMenu mainMenu;
    CreateProfile createProfile;
    DeleteProfile deleteProfile;
    DeleteStatus deleteStatus;
    UpdateProfile updateProfile;
    UpdateInfo updateInfo;
    DisplayPrompt displayPrompt;
    DisplayProfile currentDisplayProfile;
    DisplayAllProfiles displayAllProfiles;
    PatientProf curProfile;


    public PatientSystemGUI(){
        mainMenu = new MainMenu(this);
        createProfile = new CreateProfile(this);
        deleteProfile = new DeleteProfile(this);
        updateProfile = new UpdateProfile(this);
        displayPrompt = new DisplayPrompt(this);
        displayAllProfiles = new DisplayAllProfiles(this);

        startUp();
    }

    // Function that handles the startup of the program, selecting the file to run with and launching the main menu
    public void startUp(){

        // Create a new object to choose a file
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
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
        if(e.getSource()==createProfile.getSubmit()){
            handleCreateProfile();
        }
        if(e.getSource()==deleteProfile.getDelete()){
            handleDeleteProfile();
        }
        if(deleteStatus != null && e.getSource()==deleteStatus.getOK()){
            handleDeleteOK();
        }

        if (e.getSource()==updateProfile.getFind()){
            handleUpdateProfile();
        }

        if (updateInfo != null && e.getSource()==updateInfo.getSubmit()){
            handleUpdateInfo();
        }

        if(e.getSource()==displayPrompt.getSearch()){
            handleDisplayProfile();
        }
        if(e.getSource()==displayAllProfiles.getSearch()){
            handleDisplayAllProfiles();
        }
        if(currentDisplayProfile!= null && e.getSource()==currentDisplayProfile.getExit()){
            handleDisplayProfileExit();
        }
        if(currentDisplayProfile!= null && e.getSource()==currentDisplayProfile.getNext()){
            handledDisplayProfileNext();
        }

    }

    // Method to handle clicking select in MainMenu
    // Gets the selection from the main menu and switches to choose which window to show
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
                mainMenu.setVisible(false);
                displayPrompt.setVisible(true);
                break;
            case "displayAll":
                mainMenu.setVisible(false);
                displayAllProfiles.setVisible(true);
                break;
        }
    }

    // Method to handle hitting "Submit" in createProfile screen
    // Tries to receive a profile and if any exceptions are caught, creates a new ErrorBox
    // showing the error message to the user
    private void handleCreateProfile(){
        PatientProf profile;
        try{
            profile = createProfile.getProfile();
            database.insertNewProfile(profile);
            createProfile.hideScreen();
            mainMenu.setVisible(true);
        } catch (NumberFormatException e){
            new ErrorBox("Co-pay must be a number.");
        }
        catch(RuntimeException e){
            new ErrorBox(e.getMessage());
        }
    }

    // Method to handle hitting "Delete" in DeleteProfile
    // Gets the data from the DeleteProfile form and tries to delete the profile from the database
    // If the deletion succeeds, create a pop up saying the profile was deleted
    // If the deletion fails, create a pop up saying the profile could not be deleted
    private void handleDeleteProfile(){
        String[] data = deleteProfile.getData();
        String adminID = data[0];
        String lastName = data[1];
        if(database.deleteProfile(adminID, lastName)){
            deleteProfile.hideScreen();
            deleteStatus = new DeleteStatus(this, "Profile Deleted!");
        } else{
            deleteProfile.hideScreen();
            deleteStatus = new DeleteStatus(this, "Profile Deletion Failed");
        }
    }

    // Method to handle hitting OK in the deletion status window
    // Returns the user to the main menu
    private void handleDeleteOK(){
        deleteStatus.setVisible(false);
        mainMenu.setVisible(true);
    }

    // Method to handle hitting find in UpdateProfile
    private void handleUpdateProfile(){
        String[] data = updateProfile.getData();
        String adminID = data[0];
        String lastName = data[1];
        String uInfo = data[2];
        PatientProf patient = database.findProfile(data[0], data[1]);
        if (patient != null){
            updateProfile.hideScreen();
            updateInfo = new UpdateInfo(this, adminID, lastName, uInfo);
        } else{
            new ErrorBox("Patient Could Not Be Found");
        }
    }

    private void handleUpdateInfo(){
        boolean valid = false;
        String[] data = updateInfo.getData();
        String adminID = data[0];
        String lastName = data[1];
        String uField = data[2];
        String newVal = data[3];
        PatientProf profile = database.findProfile(adminID, lastName);

        // TODO: Error checking in updates for bad inputs
        try {
            switch (uField) {
                case "Address":
                    profile.updateAddress(newVal);
                    valid = true;
                    break;
                case "Phone Number":
                    profile.updatePhone(newVal);
                    valid = true;
                    break;
                case "Insurance Type":
                    profile.updateInsuType(newVal);
                    valid = true;
                    break;
                case "Co-pay":
                    profile.updateCoPay(Float.parseFloat(newVal));
                    valid = true;
                    break;
                case "Patient Type":
                    profile.updatePatientType(newVal);
                    valid = true;
                    break;
                case "Medical Contact":
                    profile.getMedCondInfo().updateMdContact(newVal);
                    valid = true;
                    break;
                case "Medical Contact Phone Number":
                    profile.getMedCondInfo().updateMdPhone(newVal);
                    valid = true;
                    break;
                case "Allergy Type":
                    profile.getMedCondInfo().updateAlgType(newVal);
                    valid = true;
                    break;
                case "Illness Type":
                    profile.getMedCondInfo().updateIllType(newVal);
                    valid = true;
                    break;
            }
        } catch (NumberFormatException e) {
            new ErrorBox("Co-pay must be a number.");
        } catch (RuntimeException e) {
            new ErrorBox(e.getMessage());
        }

        if (valid) {
            updateInfo.hideScreen();
            mainMenu.setVisible(true);
        }


    }

    // Method to handle finding and displaying one profile
    // Gets the data from the displayPrompt and attempts to find the profile
    // If profile found, create a new DisplayProfile to display the information
    // If profile not found, create a new ErrorBox saying the patient could not be found
    private void handleDisplayProfile(){
        String[] data = displayPrompt.getData();
        PatientProf patient = database.findProfile(data[0], data[1]);
        if (patient != null){
            displayPrompt.hideScreen();
            currentDisplayProfile = new DisplayProfile(this, patient, true);
        }else{
            new ErrorBox("Patient Could Not Be Found");
        }
    }

    // Method to handle displaying all of the profiles when "Search" is clicked
    // Gets the adminID that the user and will display all of the patients under that adminID
    // Sends an ErrorBox error message if adminID has no patients
    private void handleDisplayAllProfiles(){
        String adminID = displayAllProfiles.getData();
        PatientProf nextProfile;
        curProfile = database.findFirstProfile(adminID);
        if (curProfile == null){
            new ErrorBox("Admin ID has no patients");
        } else{
            nextProfile = database.findNextProfile();
            if (nextProfile == null){
                displayAllProfiles.hideScreen();
                currentDisplayProfile = new DisplayProfile(this, curProfile, true);
            } else{
                displayAllProfiles.hideScreen();
                currentDisplayProfile = new DisplayProfile(this, curProfile, false);
                curProfile = nextProfile;
            }
        }
    }

    // Handle hitting the exit button from displaying a profile. Returns the user to the main menu.
    private void handleDisplayProfileExit(){
        currentDisplayProfile.setVisible(false);
        mainMenu.setVisible(true);
    }

    // Handle hitting the next button from displaying a profile. Attempts to find the next profile and
    // creates another displayProfile window with the correct button, "Next" or "Exit"
    private void handledDisplayProfileNext(){
        PatientProf nextProfile = database.findNextProfile();
        if (nextProfile == null){
            currentDisplayProfile.setVisible(false);
            currentDisplayProfile = new DisplayProfile(this, curProfile, true);
        } else{
            currentDisplayProfile.setVisible(false);
            currentDisplayProfile = new DisplayProfile(this, curProfile, false);
            curProfile = nextProfile;
        }
    }

    public static void main(String[] args){
        new PatientSystemGUI();
    }
}
