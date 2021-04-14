package backend;

import java.util.Scanner;
import java.util.regex.Pattern;

// Class for user interface
public class PatientProfInterface {

    private PatientProfDB database;         // The Backend.PatientProfDB used for backend database management
    private Scanner in;                     // Scanner object used to scan user input
    private String filename;                // filename that is used to store database information

    // Constructor method
    // Takes in the filename to store the database in
    // creates a new database with the filename and sets the filename attribute to the filename
    PatientProfInterface(String filename){
        this.database = new PatientProfDB(filename);
        this.filename = filename;
    }

    // Prompts the user with a menu of choices for actions to perform
    // Loops and performs functions until the user selects 0 to exit
    public void getUserChoice(){
        int numOfChoices = 8;           // number of menu choices
        boolean exit = false;           // condition to exit the prompting of menu interaction
        in = new Scanner(System.in);    // initialize the Scanner object to read user input

        // Keep looping this prompt until it is time to exit
        do {
            // List options
            System.out.println("Please enter a number to choose an option listed below");
            System.out.println("1: Enter a New Patient Profile");
            System.out.println("2: Delete a Patient Profile");
            System.out.println("3: Find a Patient Profile");
            System.out.println("4: Modify Patient Profile Info");
            System.out.println("5: Display all Patient Profiles");
            System.out.println("6: Write to database");
            System.out.println("7: Initialize database");
            System.out.println("0: Exit");
            System.out.print(">");

            boolean valid = false;      // condition that the choice was valid
            int selection = 0;          // which number was selected

            // Keep looping and prompting the user for a selection until they make a valid choice
            while (!valid) {
                String response = in.nextLine();
                try {
                    selection = Integer.parseInt(response);
                    valid = (selection >= 0 && selection < numOfChoices);
                } catch (NumberFormatException e) {
                }

                if (!valid) {
                    System.out.println("Invalid Choice please choose a number listed above");
                    System.out.print(">");
                }
            }

            // Switch on the selection to choose which function to execute
            switch (selection) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    addNewPatient();
                    break;
                case 2:
                    deletePatientProfile();
                    break;
                case 3:
                    findPatientProfile();
                    break;
                case 4:
                    updatePatientProf();
                    break;
                case 5:
                    displayAllPatientProf();
                    break;
                case 6:
                    writeToDB();
                    break;
                case 7:
                    initDB();
                    break;
                default:
                    throw new RuntimeException("Invalid Menu Choice");
            }

        }while(!exit);

        // Close the scanner on exit
        in.close();

    }

    // Prompts the user for the adminID and lastName of a patient and deletes their profile from the database
    public void deletePatientProfile(){
        String adminID;         // adminID of patient to delete
        String lastName;        // lastName of patient to delete
        boolean valid;          // condition that the input is valid

        // Keep prompting user for an adminID until it is a valid entry
        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);


        // Keep prompting user for a lastName until it is a valid entry
        do{
            System.out.print("Enter Last Name: ");
            lastName =  in.nextLine();
            valid = Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName);
            if (!valid){
                System.out.println("Invalid Last Name. Please try again");
            }
        }while(!valid);

        // Print out an error message if the deletion could not be performed
        if(!database.deleteProfile(adminID, lastName)){
            System.out.println("ERROR: Deletion could not be completed");
        }
    }

    // Prompts the user for an adminID and lastName of a patient and then finds and displays that
    // patient's information
    public void findPatientProfile(){
        String adminID;             // adminID of patient to find
        String lastName;            // lastName of patient to find
        boolean valid;              // condition that the inputs are valid

        // Keep prompting user for an adminID until it is a valid entry
        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        valid = false;

        // Keep prompting user for a lastName until it is a valid entry
        do{
            System.out.print("Enter Last Name: ");
            lastName =  in.nextLine();
            valid = Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName);
            if (!valid){
                System.out.println("Invalid Last Name. Please try again");
            }
        }while(!valid);

        // Get the Backend.PatientProf from the database using the given information
        PatientProf profile = database.findProfile(adminID, lastName);

        // If the profile could be found display all patient information
        // If it can not be found print an error message
        if (profile != null){
            displayPatientProf(profile);
        }else{
            System.out.println("ERROR: Patient could not be found");
        }

    }

    // Prompts the user for and adminID and lastName of a Patient
    // Then, provides the user choices of what Patient data to change
    public void updatePatientProf(){

        String adminID;             // adminID of patient
        String lastName;            // lastName of patient
        boolean valid;              // condition that the input is valid
        int numOfChoices = 10;      // Number of choices to choose from

        System.out.println("Enter AdminID and Last Name of Patient you want to modify");

        // Keep prompting user for an adminID until it is a valid entry
        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        valid = false;

        // Keep prompting user for a lastName until it is a valid entry
        do{
            System.out.print("Enter Last Name: ");
            lastName =  in.nextLine();
            valid = Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName);
            if (!valid){
                System.out.println("Invalid Last Name. Please try again");
            }
        }while(!valid);

        // Try to find the profile
        // If not found print an error message
        PatientProf profile = database.findProfile(adminID, lastName);

        if (profile == null){
            System.out.println("Profile does not exist");
        }else {

            // Print the options for the user
            System.out.println("Please enter a number to choose an option listed below");
            System.out.println("1: Modify Address");
            System.out.println("2: Modify Phone number");
            System.out.println("3: Modify Insurance Type");
            System.out.println("4: Modify Co-pay");
            System.out.println("5: Modify Patient Type");
            System.out.println("Medical Condition Options");
            System.out.println("6: Modify Medical Contact");
            System.out.println("7: Modify Medical Contact Phone Number");
            System.out.println("8: Modify Allergy Type");
            System.out.println("9: Modify Illness Type");
            System.out.println("0: Exit");
            System.out.print(">");

            valid = false;              // condition that the input is valid
            int selection = 0;          // selection that is chosen

            // Keep prompting the user for a selection until they choose a valid choice
            while (!valid) {
                String response = in.nextLine();
                try {
                    selection = Integer.parseInt(response);
                    valid = (selection >= 0 && selection < numOfChoices);
                } catch (NumberFormatException e) {
                }

                if (!valid) {
                    System.out.println("Invalid Choice please choose a number listed above");
                    System.out.print(">");
                }
            }

            boolean exit = false;               // condition that newValue is valid and user can exit

            // Keep looping until the newValue to enter is valid
            do {
                System.out.print("Enter new value: ");
                String newValue = in.nextLine();

                // Switch on the selection to choose which value to change
                switch (selection) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        try {
                            profile.updateAddress(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            profile.updatePhone(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            profile.updateInsuType(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            profile.updateCoPay(Float.parseFloat(newValue));
                            exit = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Co-pay must be a number");
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            profile.updatePatientType(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            MedCond medCondInfo = profile.getMedCondInfo();
                            medCondInfo.updateMdContact(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        try {
                            MedCond medCondInfo = profile.getMedCondInfo();
                            medCondInfo.updateMdPhone(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 8:
                        try {
                            MedCond medCondInfo = profile.getMedCondInfo();
                            medCondInfo.updateAlgType(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 9:
                        try {
                            MedCond medCondInfo = profile.getMedCondInfo();
                            medCondInfo.updateIllType(newValue);
                            exit = true;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

            } while (!exit);
        }

    }

    // Takes in a Backend.PatientProf and displays all of the data contained
    private void displayPatientProf(PatientProf profile){

        // Print out all data and then wait for a newLine to move on the next screen
        System.out.println("Patient Information");
        System.out.println("First Name: " + profile.getFirstName());
        System.out.println("Last Name: " + profile.getLastName());
        System.out.println("Admin ID: " + profile.getadminID());
        System.out.println("Address: " + profile.getAddress());
        System.out.println("Phone: " + profile.getPhone());
        System.out.println("Co-pay: " + profile.getCoPay());
        System.out.println("Insurance Type: " + profile.getInsuType());
        System.out.println("Patient Type: " + profile.getPatientType());
        System.out.println("Medical Condition Information");
        System.out.println("Medical Contact: " + profile.getMedCondInfo().getMdContact());
        System.out.println("Number of Medical Contact: " + profile.getMedCondInfo().getMdPhone());
        System.out.println("Known Allergies: " + profile.getMedCondInfo().getAlgType());
        System.out.println("Known Illnesses: " + profile.getMedCondInfo().getIllType());
        System.out.print("Hit <ENTER> to continue...");
        in.nextLine();

    }

    // Prompts the user for an adminID and then displays the information for all patients under that admin
    public void displayAllPatientProf(){
        String adminID;             // adminID of Patient
        boolean valid;              // condition that the input is valid

        // Keep prompting the user for an adminID until it is valid
        do{
            System.out.print("Enter Admin ID: ");
            adminID =  in.nextLine();
            valid = Pattern.matches("PA\\d+", adminID);
            if (!valid){
                System.out.println("Invalid Admin ID. Please try again");
            }
        }while(!valid);

        // Find the first profile in the database that is connected to the given adminID
        PatientProf curProfile = database.findFirstProfile(adminID);

        // Keep displaying the current profile and then retrieve the next profile
        // The curProfile will be null when no more profiles are found
        while(curProfile != null){
            displayPatientProf(curProfile);
            curProfile = database.findNextProfile();
        }

        // Tell the user that the last of the profiles have been found
        // and then wait for a newLine to display the next screen
        System.out.println("End of Profiles for Admin ID: " + adminID);

        System.out.print("Hit <ENTER> to continue...");
        in.nextLine();

    }

    // Write all of the PatientProfiles to the file that is specified by filename
    public void writeToDB(){
        database.writeAllPatientProf(filename);
    }

    // Load in all of the PatientProfiles from the file that is specified by filename
    public void initDB(){
        try {
            database.initializeDatabase(filename);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    // Gets a new patient through the createNewPatientProf method and adds it to the database
    public void addNewPatient(){
        PatientProf newPatient = createNewPatientProf();
        database.insertNewProfile(newPatient);
    }

    // Prompts the user for all of the information needed to create a new PatientProfile
    // Returns the newly created Backend.PatientProf
    public PatientProf createNewPatientProf(){
        boolean valid;                      // condition that the input is valid
        PatientProf newPatient = null;      // The newPatient to be returned

        do {
            // Prompt the user for all the information needed
            System.out.println("Fill in the information for the patient below");
            try {
                System.out.print("Admin ID: ");
                String adminID = in.nextLine();
                System.out.print("First Name: ");
                String firstName = in.nextLine();
                System.out.print("Last Name: ");
                String lastName = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();
                System.out.print("Phone: ");
                String phone = in.nextLine();
                System.out.print("Co-Pay: ");
                float coPay = Float.parseFloat(in.nextLine());
                System.out.print("Insurance Type: ");
                String insuType = in.nextLine();
                System.out.print("Patient Type: ");
                String patientType = in.nextLine();

                MedCond medCondInfo = createNewMedCond();

                newPatient = new PatientProf(adminID, firstName, lastName, address, phone,
                        coPay, insuType, patientType, medCondInfo);

                // If no exceptions were raised, the inputs are valid and the loop breaks
                valid = true;

                // Catch Exceptions that rise from invalid input and then print an error message
            } catch (NumberFormatException e) {
                valid = false;
                System.out.println("Invalid Input: ");
                System.out.println("Co-pay must be a number.");
            } catch (RuntimeException e) {
                valid = false;
                System.out.println("Invalid Input: ");
                System.out.println(e.getMessage());
            }
        }while(!valid);

        // Return the newly created patient
        return newPatient;
    }

    // Prompts the user for all the information needed to create a Backend.MedCond object
    // Returns a new Backend.MedCond object
    public MedCond createNewMedCond(){
        // Create a new Backend.MedCond with dummy values that will be updated
        MedCond rv = new MedCond("NULL","0000000000","None", "None");

        System.out.println("Fill in the Medical information for the patient below");
        boolean valid = false;          // condition that input is valid

        // Keep prompting the user for a medical contact until the input is valid
        do {
            try {
                System.out.print("Medical Contact: ");
                String mdContact = in.nextLine();
                rv.updateMdContact(mdContact);
                valid = true;
            } catch (RuntimeException e) {
                System.out.println("Invalid Input: ");
                System.out.println(e.getMessage());
            }
        }while(!valid);

        valid = false;

        // Keep prompting the user for a medical contact phone number until the input is valid
        do {
            try {
                System.out.print("Medical Contact Phone Number: ");
                String mdPhone = in.nextLine();
                rv.updateMdPhone(mdPhone);
                valid = true;
            } catch (RuntimeException e) {
                System.out.println("Invalid Input: ");
                System.out.println(e.getMessage());
            }
        }while(!valid);

        valid = false;

        // Keep prompting the user for an allergy type until the input is valid
        do {
            try {
                System.out.print("Allergy Type: ");
                String algType = in.nextLine();
                rv.updateAlgType(algType);
                valid = true;
            } catch (RuntimeException e) {
                System.out.println("Invalid Input: ");
                System.out.println(e.getMessage());
            }
        }while(!valid);

        valid = false;

        // Keep prompting the user for an illness type until the input is valid
        do {
            try {
                System.out.print("Illness Type: ");
                String illType = in.nextLine();
                rv.updateIllType(illType);
                valid = true;
            } catch (RuntimeException e) {
                System.out.println("Invalid Input: ");
                System.out.println(e.getMessage());
            }
        }while(!valid);

        // Return the new Backend.MedCond object
        return rv;
    }

    // Main method to actually start up the user interface
    // Creates an instance of the Backend.PatientProfInterface with the database file
    // Then calls the method to get the user's choices
    public static void main(String[] args){
        PatientProfInterface test = new PatientProfInterface("testdatabase.txt");
        test.getUserChoice();
    }

}
